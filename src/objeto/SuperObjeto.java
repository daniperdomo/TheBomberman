package objeto;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Panel;

public class SuperObjeto {

	public BufferedImage image;
	public String nombre;
	public boolean colision = false;
	public int x, y;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, Panel gp) {
		
		g2.drawImage(image, x, y, gp.window_size, gp.window_size, null);
	}
	
	
}
