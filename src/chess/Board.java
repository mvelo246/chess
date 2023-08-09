package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;


public class Board extends JPanel implements MouseListener{
	private Square[][] squares = new Square[8][8]; 
	private Square firstSelected = null; 
	private Square secondSelected = null;
	chessPeace p;
	public Board() {
		Color c = new Color(188,143,143);
		this.setBackground(c);
		for(int i = 0; i < 8; i++){
	    	for(int j = 0; j < 8; j++){
	    		if(j%2==0&&i%2==1) {
	    		squares[i][j] = new Square(i,j,0);
	    		
	    			
	    		}
	    		else if(i%2==0&&j%2==1){
	    			squares[i][j] = new Square(i,j,0);
	    		}
	    		else {
	    			squares[i][j] = new Square(i,j,1);
	    		}
	    		if(j==6) {
	    		squares[i][j].addPiece(new chessPeace("pawnw"));
	    		}
	    		if(j==1) {
		    		squares[i][j].addPiece(new chessPeace("pawnb"));
		    		}
	    		
	    		
	    	}
	    	    		
	    }
		squares[0][0].addPiece(new chessPeace("rookb"));
		squares[7][0].addPiece(new chessPeace("rookb"));
		squares[1][0].addPiece(new chessPeace("knightb"));
		squares[6][0].addPiece(new chessPeace("knightb"));
		squares[2][0].addPiece(new chessPeace("bishopb"));
		squares[5][0].addPiece(new chessPeace("bishopb"));
		squares[3][0].addPiece(new chessPeace("kingb"));
		squares[4][0].addPiece(new chessPeace("queenb"));
		
		squares[7][7].addPiece(new chessPeace("rookw"));
		squares[0][7].addPiece(new chessPeace("rookw"));
		squares[1][7].addPiece(new chessPeace("knightw"));
		squares[6][7].addPiece(new chessPeace("knightw"));
		squares[2][7].addPiece(new chessPeace("bishopw"));
		squares[5][7].addPiece(new chessPeace("bishopw"));
		squares[3][7].addPiece(new chessPeace("kingw"));
		squares[4][7].addPiece(new chessPeace("queenw"));
		
		this.addMouseListener(this);
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < 8; i++){
		    	for(int j = 0; j < 8; j++){
		    		squares[i][j].draw(g);
		    	}
		    }
		g.drawString("BY MVELO MLANGENI", 810, 790);
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Square s = squares[e.getX()/Square.SIZE][e.getY()/Square.SIZE];
	
		if(this.firstSelected == null && s.checkPiece()){
			firstSelected = s;
			firstSelected.click();
			repaint();
		}
		else{
			
			secondSelected = s;
			new Move().move();
			repaint();
		}
				
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public class Move{
		public Move() {
			
		}
	
		public void move(){
			if(firstSelected.getPiece() != null){
				if( new Move().path(firstSelected.getPiece().getName())) {
				chessPeace p = firstSelected.getPiece();
				firstSelected.remove();
				secondSelected.addPiece(p);
				firstSelected.click();
				firstSelected = null;
				secondSelected = null;
				repaint();
				}

			}
		}
		public boolean path(String s) {
			boolean  result= false;
			//coordinates
			int changeRow = Math.abs(firstSelected.getRow()-secondSelected.getRow());
			int changeCol= Math.abs(firstSelected.getCol()-secondSelected.getCol());
			
			
			//name boolean
			boolean king = s.equals("kingb")||s.equals("kingw");
			boolean bishop = s.equals("bishopb")||s.equals("bishopw");
			boolean queen = s.equals("queenb")||s.equals("queenw");
			boolean rook = s.equals("rookb")||s.equals("rookw");
			boolean pawn = s.equals("pawnb")||s.equals("pawnw");
			boolean knight = s.equals("knightb")||s.equals("knightw");
			
			//conditions
			if(king) {
				if((changeRow==1&&changeCol==0)||(changeRow==0&&changeCol==1)||(changeRow==1&&changeCol==1)) {
					result=true;
				}
				
			}
			else if(rook) {
				if((changeRow>0&&changeCol==0)||(changeRow==0&&changeCol>0)){
					result = true;
				}
			}
			else if(bishop) {
				if((changeRow==changeCol)) {
					result = true;
				}
			}
			else if(queen) {
				if((changeRow>0&&changeCol==0)||(changeRow==0&&changeCol>0)){
					result = true;
				}
				else if((changeRow==changeCol)) {
					result = true;
				}
				
			}
			else if(knight) {
				int fr = firstSelected.getRow();
				int fc = firstSelected.getCol();
				int sr = secondSelected.getRow();
				int sc = secondSelected.getCol();
				if(fr-1==sr&&fc-2==sc) {
					result=true;
				}
				else if(fr+1==sr&&fc-2==sc) {
					result=true;
				}
				else if(fr-1==sr&&fc+2==sc) {
					result=true;
				}
				else if(fr+1==sr&&fc+2==sc) {
					result=true;
				}
				
			}
			else if(pawn) {
				if((changeRow==0&&changeCol==1)) {
					result=true;
				}
			}
			
			return result;
		}

}
}
