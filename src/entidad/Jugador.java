package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Controles;
import main.Panel;       
/**
 *
 * @author usuario
 */
public class Jugador extends Entidad {
    Panel gp;
    Controles control;
    public int tieneBomba = 1;
    public int tienePatines = 0;
    
    
    public Jugador (Panel gp, Controles control){
        this.gp = gp;
        this.control = control;
        
        solidArea = new Rectangle(8, 16, 32, 32);  //Hitbox de Colision (x, y, ancho, largo)
        solidAreaDefaultX = 8;
        solidAreaDefaultY = 16;
        
        setPredeterminado();
        getPlayerImage();
    }
    
    public void setPredeterminado(){
        x = 46;
        y = 46;
        velocidad = 1;
        direccion = "abajo";
    }
    
    public void getPlayerImage(){
        try{

            arriba1 = ImageIO.read(getClass().getResourceAsStream("/player/arriba1.png"));
            arriba2 = ImageIO.read(getClass().getResourceAsStream("/player/arriba2.png"));
            abajo1 = ImageIO.read(getClass().getResourceAsStream("/player/abajo1.png"));
            abajo2 = ImageIO.read(getClass().getResourceAsStream("/player/abajo2.png"));
            izq1 = ImageIO.read(getClass().getResourceAsStream("/player/izquierda1.png"));
            izq2 = ImageIO.read(getClass().getResourceAsStream("/player/izquierda2.png"));
            der1 = ImageIO.read(getClass().getResourceAsStream("/player/derecha1.png"));
            der2 = ImageIO.read(getClass().getResourceAsStream("/player/derecha2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar() {
    	
    	if (control.arriba == true || control.abajo == true || control.izquierda == true || control.derecha == true) {  //
    	
	        if (control.arriba == true){
	            direccion = "arriba";
	        }
	        else if (control.abajo == true){
	            direccion = "abajo";
	        }
	        else if (control.izquierda == true){
	            direccion = "izquierda";
	        }
	        else if (control.derecha == true){
	            direccion = "derecha";
	        }
	        
	        //Chequeo de colision.
	        colisionOn = false;
	        gp.cChecker.checkTile(this);
	        
	        //Chequeo de colision con objeto.
	        int objIndex=  gp.cChecker.checkObjeto(this, true);
	        recogerObjeto(objIndex);
	        
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
        
    }
    
    public void recogerObjeto(int i){ //Tambien sirve para la interaccion entre objetos,
    	if(i != 999){
    		String nombreObjeto = gp.obj[i].nombre;
    		
    		switch(nombreObjeto) {
    			case "bomba":
    				tieneBomba++;
    				gp.obj[i] = null;
    				System.out.println("Bomba: " + tieneBomba);
    				break;
    				
    			case "patines":
    				tienePatines++;
    				gp.playSE(1);
    				velocidad = velocidad + 1;
    				gp.obj[i] = null;
    				break; 
    				
    		}
    	}
    }
    
    public void dibujar(Graphics2D g2){
        
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
