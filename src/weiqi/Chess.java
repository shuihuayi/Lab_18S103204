package weiqi;


import java.awt.*;
import java.awt.event.*;
//创建棋盘的类


class Chess extends Frame
{
	ChessPad chesspad = new ChessPad();
    Chess(){
    	setVisible(true);
    	setLayout(null);
    	Label label = new Label("单机左键下棋子，吃棋子双击，用右键击棋子悔棋",Label.CENTER);
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