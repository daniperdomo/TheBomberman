package entidad;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;
import main.UtilityTool;

public class Entidad {
	Panel gp;
    public int x, y, velocidad;
    public BufferedImage arriba1, arriba2, abajo1, abajo2, izq1, izq2, der1, der2, bombmenu;
    public String direccion = "abajo";
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean colisionOn = false;
    public BufferedImage image, image2;
	public String nombre;
	public boolean colision = false;
    
    //Estado de personaje
    public int vidamax;
    public int vida;
    
    public Entidad(Panel gp) {
    	this.gp = gp;
    	 
    }
    
    public BufferedImage setup (String imagePath) {
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
    		image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
    		image = uTool.scaleImage(image, gp.window_size, gp.window_size);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return image;
    }
    
    public void draw(Graphics2D g2) {
    	BufferedImage image = null;
    	
    	switch(direccion){
        case "arriba":
        	if(spriteNum == 1) {
        		image = arriba1;
        	}
        	if(spriteNum == 2) {
        		image = arriba2;
        	}
            break;
        case "abajo":
        	if(spriteNum == 1) {
        		image = abajo1;
        	}
        	if(spriteNum == 2) {
        		image = abajo2;
        	}
            break;
        case "izquierda":
        	if(spriteNum == 1) {
        		image = izq1;
        	}
        	if(spriteNum == 2) {
        		image = izq2;
        	}
            break;
        case "derecha":
        	if(spriteNum == 1) {
        		image = der1;
        	}
        	if(spriteNum == 2) {
        		image = der2;
        	}
            break;
    }
    	
    	g2.drawImage(image, x, y, gp.window_size, gp.window_size, null);
    }
}
