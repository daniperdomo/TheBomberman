package entidad;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
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
    public int actionLockCounter;
    public boolean invencible = false;
    public int contInvencible = 0;
	public int tipo; //0 = jugador, 1 = monstruo;     
    
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
    
    public void setAction() {}
    
    public void update() {
    	setAction();
    	
    	colisionOn = false;
    	gp.cChecker.checkTile(this);
    	gp.cChecker.checkEntidad(this, gp.monstruo);
    	gp.cChecker.checkObjeto(this, false);
    	boolean contactPlayer = gp.cChecker.checkPlayer(this);
    	
    	if(this.tipo == 1 && contactPlayer == true) {
    		if(gp.jugador.invencible == false) {
    			//Para recibir daño.
    			gp.jugador.vida -= 1;
    			gp.jugador.invencible = true;
    		}
    	}
    	
    	//Si la colision es falsa, el jugador no se mueve.
        if(colisionOn == false) {
        	switch (direccion) {
        	case "arriba":
        		y = y - velocidad;
        		break;
        	case "abajo":
        		y = y + velocidad;
        		break;
        	case "izquierda":
        		x = x - velocidad;
        		break;
        	case "derecha":
        		x = x + velocidad;
        		break;
        	}
        	
        }
        
        
        spriteCounter++;
        if(spriteCounter > 14) {
        	if(spriteNum == 1) {
        		spriteNum = 2;
        	}
        	else if(spriteNum == 2) {
        		spriteNum = 1;
        	}
        	spriteCounter = 0;
        }
    	
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
    	
    	if(invencible == true) {
     	   g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
    	
    	g2.drawImage(image, x, y, gp.window_size, gp.window_size, null);
    	
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
