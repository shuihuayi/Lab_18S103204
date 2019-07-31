package test;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JTextArea;

//�������̵���
class ChessPad extends Panel implements MouseListener,ActionListener
{
	ArrayList<String> list = new ArrayList<String>();
	int x=-1,y=-1,������ɫ=1;
	Button button = new Button("���¿���");
	Button button1 = new Button("��������");
	TextField text_1 = new TextField("���������");
	TextField text_2 = new TextField();
	JTextArea  jta = new JTextArea("�����¼\n");
   
  	
	ChessPad(){
		setSize(600,600);
		setLayout(null);
		setBackground(Color.lightGray);
		addMouseListener(this);
		add(button);
		button.setBounds(10,5,60,26);
		button.addActionListener(this);
		add(text_1);
		text_1.setBounds(90,5,90,24);
		add(text_2);
		text_2.setBounds(250,5,90,24);
		text_1.setEditable(false);
		text_2.setEditable(false); 
		add(button1);
		button1.setBounds(360,5,60,26);
		button1.addActionListener(this);
		add(jta);
		jta.setBounds(10,450,400,50);
		jta.setLineWrap(true);// �����Զ����й���
		jta.setWrapStyleWord(true);// ������в����ֹ���
		jta.setBackground(Color.BLUE);
	}
		
	

//����Χ�����̵����
	public void paint(Graphics g){
	
		for(int i=40;i<=400;i+=20){
			g.drawLine(40,i,400,i);
		}
	
		for(int j=40;j<=400;j+=20){
			g.drawLine(j,40,j,400);
		}
//���С��
		g.fillOval(97,97,6,6);
		g.fillOval(97,337,6,6);
		g.fillOval(337,97,6,6);
		g.fillOval(337,337,6,6);
		g.fillOval(217,217,6,6);
	}

//�����������������¼�
	public void mousePressed(MouseEvent e){
		if(e.getModifiers() == InputEvent.BUTTON1_MASK){
			x=(int)e.getX();
			y=(int)e.getY();
			ChessPoint_black chesspoint_black = new ChessPoint_black(this);
			ChessPoint_white chesspoint_white = new ChessPoint_white(this);

			int a=(x+10)/20,b=(y+10)/20;
//����λ�ó������̣���������
			if(x/20<2 || y/20<2 || x/20>19 || y/20>19){
				
			}else{
				if(������ɫ==1){
					this.add(chesspoint_black);
					chesspoint_black.setBounds(a*20-10,b*20-10,20,20);������ɫ = ������ɫ*(-1);
					String move ="���ӣ�"+a+" "+b;
					list.add(move);
					text_1.setText(null);
					text_2.setText("���������");
				}
				else if(������ɫ==-1)
				{
					this.add(chesspoint_white);
					chesspoint_white.setBounds(a*20-10,b*20-10,20,20);
					String move ="���ӣ�"+a+" "+b;
					list.add(move);
					������ɫ = ������ɫ*(-1);
					text_1.setText("���������");
					text_2.setText(null);
				}
			}
		}
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
//��Ӧbutton �¼�
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			this.removeAll();
			
			������ɫ=1;
			add(button);
			button.setBounds(10,5,60,26);
			
			add(text_1);
			text_1.setBounds(90,5,90,24);
			add(text_2);
			text_2.setBounds(250,5,90,24);
			text_1.setText("���º���");
			text_2.setText(null);
			add(button1);
			button1.setBounds(360,5,60,26);
			add(jta);
			jta.setBounds(10, 500,400,50);
			jta.setLineWrap(true);// �����Զ����й���
			jta.setWrapStyleWord(true);// ������в����ֹ���
			jta.setText("�����¼\n");

		}else if( e.getSource()== button1){
			jta.setBounds(10, 450,400,200);
			jta.setLineWrap(true);// �����Զ����й���
			jta.setWrapStyleWord(true);// ������в����ֹ���
			jta.setBackground(Color.BLUE);
			jta.setText("�����¼\n");
			jta.setLineWrap(true);// �����Զ����й���
			jta.setWrapStyleWord(true);// ������в����ֹ���
			jta.setBackground(Color.pink);
			int size = list.size();
			for(int i=0;i<size;i++){
				jta.append(list.get(i)+"\n");
			}
			
		}
		
	}
} 





//���𴴽���ɫ���ӵ���
	class ChessPoint_black extends Canvas implements MouseListener
	{
		ChessPad chesspad=null;
		ChessPoint_black(ChessPad p)
		{
			setSize(20,20);
			chesspad=p;
			addMouseListener(this);
		}
//�������ӵĴ�С
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval(0,0,20,20);
	}
	public void mousePressed(MouseEvent e)
	{
		if(e.getModifiers()==InputEvent.BUTTON3_MASK){
			chesspad.remove(this);
			chesspad.������ɫ=1;
			chesspad.text_2.setText(null);
			chesspad.text_1.setText("���������");
		}
	}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
    	if(e.getClickCount()>=2)
    		chesspad.remove(this);
    }
}
//���𴴽���ɫ���ӵ���
class ChessPoint_white extends Canvas implements MouseListener{
	ChessPad chesspad=null;
	ChessPoint_white(ChessPad p){
		setSize(20,20);
		chesspad=p;
		addMouseListener(this);
	}
//�������ӵĴ�С
    public void paint(Graphics g){
    	g.setColor(Color.white);
    	g.fillOval(0,0,20,20);
    }

    public void mousePressed(MouseEvent e){
    	if(e.getModifiers()==InputEvent.BUTTON3_MASK){
    		chesspad.remove(this);
    		chesspad.������ɫ=-1;
    		chesspad.text_2.setText("���������");
    		chesspad.text_1.setText(null);
    }
}

public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseClicked(MouseEvent e){
	if(e.getClickCount()>=2)
		chesspad.remove(this);
	}
}

class Chess extends Frame
{
	ChessPad chesspad = new ChessPad();
	
    public void start(){
    	setVisible(true);
    	setLayout(null);
  
    	Label label = new Label("������������ӣ�������˫�������Ҽ������ӻ���",Label.CENTER);
    	add(label);
    	label.setBounds(70,55,440,26);
    	label.setBackground(Color.white);
    	add(chesspad);
    	chesspad.setBounds(70,90,440,440);
    	addWindowListener(new WindowAdapter(){
    		public void windowClosing(WindowEvent e){
    			System.exit(0);
    		}
    	}
    	);
    	pack();
    	setSize(800,800);
    	
    }
    
    public void play(){
    	setVisible(true);
    	setLayout(null);
    	Label label = new Label("������������ӣ�������˫�������Ҽ������ӻ���",Label.CENTER);
    	add(label);
    	label.setBounds(70,55,440,26);
    	label.setBackground(Color.white);
    	add(chesspad);
    	chesspad.setBounds(70,90,440,600);
    	addWindowListener(new WindowAdapter(){
    		public void windowClosing(WindowEvent e){
    			System.exit(0);
    		}
    	}
    	);
    	pack();
    	setSize(700,700);
    }
    
    public void end(){
    	setVisible(true);
    	setLayout(null);
    	Label label = new Label("������������ӣ�������˫�������Ҽ������ӻ���",Label.CENTER);
    	add(label);
    	label.setBounds(70,55,440,26);
    	label.setBackground(Color.white);
    	add(chesspad);
    	chesspad.setBounds(70,90,440,440);
    	addWindowListener(new WindowAdapter(){
    		public void windowClosing(WindowEvent e){
    			System.exit(0);
    		}
    	}
    	);
    	pack();
    	setSize(600,550);
    }
    
 /* 
    public static void main(String args[]){
    	Chess chess = new Chess();
    	chess.start();
    }
    */
}