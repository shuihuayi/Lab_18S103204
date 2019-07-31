package weiqi;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class ChessPoint_black extends Canvas implements MouseListener
{
		/**
	 * 
	 */
	
		ChessPad chesspad=null;
		ChessPoint_black(ChessPad p)
		{
			setSize(20,20);
			chesspad=p;
			addMouseListener(this);
		}
//绘制棋子的大小
		public void paint(Graphics g)
		{
			g.setColor(Color.black);
			g.fillOval(0,0,20,20);
		}
		public void mousePressed(MouseEvent e)
		{
			if(e.getModifiers()==InputEvent.BUTTON3_MASK){
				chesspad.remove(this);
				chesspad.棋子颜色=1;
				chesspad.text_2.setText(null);
				chesspad.text_1.setText("请黑棋下子");
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

class ChessPoint_white extends Canvas implements MouseListener{
	ChessPad chesspad=null;
	ChessPoint_white(ChessPad p){
		setSize(20,20);
		chesspad=p;
		addMouseListener(this);
	}
//绘制棋子的大小
    public void paint(Graphics g){
    	g.setColor(Color.white);
    	g.fillOval(0,0,20,20);
    }

    public void mousePressed(MouseEvent e){
    	if(e.getModifiers()==InputEvent.BUTTON3_MASK){
    		chesspad.remove(this);
    		chesspad.棋子颜色=-1;
    		chesspad.text_2.setText("请白棋下子");
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