package weiqi;


import java.awt.*;
import java.awt.event.*;
//�������̵���


class Chess extends Frame
{
	ChessPad chesspad = new ChessPad();
    Chess(){
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
    */
}