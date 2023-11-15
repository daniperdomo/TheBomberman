/**package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import objeto.Obj_Bomb;

public class UI {
	
	Panel gp;
	Font italic_40;
	BufferedImage bombaImage;
	
	public UI (Panel gp) {
		this.gp = gp;
		italic_40 = new Font("Italic", Font.PLAIN, 40);
		
		//1. Bomba
		Obj_Bomb bomba = new Obj_Bomb();
		bombaImage = bomba.image;
		
		
		
	}
	
	
	//Dibuja cantidad de objetos que tiene el jugador.
	public void draw(Graphics2D g2) {
		g2.setFont(italic_40);
		g2.setColor(Color.yellow);
		
		//Inventario de bombas
		g2.drawImage(bombaImage, gp.window_size/2, gp.window_size/2, gp.window_size, gp.window_size, null);
		g2.drawString(": " + gp.jugador.tieneBomba, 74, 65);
		
		//Inventario de patines.
		if(gp.jugador.tienePatines > 0) {
			g2.drawImage(bombaImage, gp.window_size/2, gp.window_size/2, gp.window_size, gp.window_size, null);
			g2.drawString("Patines: " + gp.jugador.tienePatines, 10, 40);
		}
		
		
	}
	
}
*/