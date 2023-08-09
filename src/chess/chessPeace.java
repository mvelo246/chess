package chess;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class chessPeace {
	private Image image=null;
	private String s;
	
	
	public chessPeace(String s) {
		this.s=s;
		try{
			image = ImageIO.read(new File("ChessPiecesImages/"+s+".gif"));
			
		} catch (IOException e) {
			System.out.print("Image not found");
			
			
		}
	}
	public void draw(Graphics g, int x, int y, int height, int width){
		if(image != null)
			g.drawImage(image, x +10 , y+10, (int)(width*0.7), (int)(height*0.7), null);
	}
	
	public String getName() {
		return s;
	}

}
