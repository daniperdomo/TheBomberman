package entidad;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Panel;

public class Entidad {
	Panel gp;
    public int x, y, velocidad;
    public BufferedImage arriba1, arriba2, abajo1, abajo2, izq1, izq2, der1, der2, bombmenu;
    public String direccion;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean colisionOn = false;
    
    //Estado de personaje
    public int vidamax;
    public int vida;
    
    public Entidad(Panel gp) {
    	this.gp = gp;
    	 
    }
}
