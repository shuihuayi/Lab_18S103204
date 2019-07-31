package weiqi;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
class ChessPad extends Panel implements MouseListener,ActionListener
{
	/**
	 * 
	 */
	
	int x=-1,y=-1,棋子颜色=1;
	Button button = new Button("重新开局");
	Button button1 = new Button("结束本局");
	TextField text_1 = new TextField("请黑子下棋");
	TextField text_2 = new TextField();
	ChessPad(){
		
		setSize(440,440);
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
	}

//绘制围棋棋盘的外观
	public void paint(Graphics g){
	
		for(int i=40;i<=400;i+=20){
			g.drawLine(40,i,400,i);
		}
	
		for(int j=40;j<=400;j+=20){
			g.drawLine(j,40,j,400);
		}
//五个小点
		g.fillOval(97,97,6,6);
		g.fillOval(97,337,6,6);
		g.fillOval(337,97,6,6);
		g.fillOval(337,337,6,6);
		g.fillOval(217,217,6,6);
	}

//按下鼠标左键下棋子事件
	public void mousePressed(MouseEvent e){
		if(e.getModifiers() == InputEvent.BUTTON1_MASK){
			x=(int)e.getX();
			y=(int)e.getY();
			ChessPoint_black chesspoint_black = new ChessPoint_black(this);
			ChessPoint_white chesspoint_white = new ChessPoint_white(this);

			int a=(x+10)/20,b=(y+10)/20;
//鼠标的位置超出棋盘，则不下棋子
			if(x/20<2 || y/20<2 || x/20>19 || y/20>19){
				
			}else{
				if(棋子颜色==1){
					this.add(chesspoint_black);
					chesspoint_black.setBounds(a*20-10,b*20-10,20,20);棋子颜色 = 棋子颜色*(-1);
					text_1.setText(null);
					text_2.setText("请白棋下子");
				}
				else if(棋子颜色==-1)
				{
					this.add(chesspoint_white);
					chesspoint_white.setBounds(a*20-10,b*20-10,20,20);
					棋子颜色 = 棋子颜色*(-1);
					text_1.setText("请黑棋下子");
					text_2.setText(null);
				}
			}
		}
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
//响应button 事件
	public void actionPerformed(ActionEvent e){
		this.removeAll();
		棋子颜色=1;
		add(button);
		button.setBounds(10,5,60,26);
		
		add(text_1);
		text_1.setBounds(90,5,90,24);
		add(text_2);
		text_2.setBounds(250,5,90,24);
		text_1.setText("请下黑棋");
		text_2.setText(null);
		add(button1);
		button1.setBounds(360,5,60,26);
	}
} 


