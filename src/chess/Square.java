package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Square {
	public static final int  SIZE=100;
	private int row, col;
	private int color;
	Color c;
	chessPeace p =null;
	boolean clicked = false;
	boolean possibleMove = false;
	public Square(int row , int col,int color) {
		this.row=row*SIZE;
		this.col=col*SIZE;
		this.color=color;
	
	}
	public int getCol() {
		return col/SIZE;
	}
	public int getRow() {
		return row/SIZE;
	}
	public void draw(Graphics g) {
		
		
		if(color==0) {
			c=new Color(87,58,46);
			g.setColor(c);
			g.fillRect(row, col, SIZE, SIZE);
		}
		else {
			
			c=new Color(252, 204, 116);
			g.setColor(c);
			g.fillRect(row, col, SIZE, SIZE);
		}
		if(clicked) {
			c=new Color(144,238,144);
			g.setColor(c);
			g.fillRect(row, col, SIZE, SIZE);
			
		
		}
	
		if(p!=null) {
			p.draw(g, row, col, SIZE, SIZE);
			
		}

		g.setColor(Color.black);
		
		g.drawRect(row, col, SIZE, SIZE);
		
	}
	public void addPiece(chessPeace p) {
		this.p=p;
	}
	public void remove() {
		this.p= null;
	}
	public chessPeace getPiece() {
		return p;
	}
	public void click() {
		if(clicked==true) {
			clicked =false;
		}else {
			clicked = true;
		}
	}
	public boolean checkPiece() {
		boolean r = false;
		if(p!=null) {
			r=true;
		}
		return r;
	}
}
