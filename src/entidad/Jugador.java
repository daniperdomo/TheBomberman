package entidad;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.Controles;
import main.Panel;
import objeto.Obj_Bomb;    
/**
 *
 * @author usuario
 */
public class Jugador extends Entidad {
	
    Controles control;
    
    
    public Jugador (Panel gp, Controles control){
        
    	super(gp);
        this.control = control;
        
        solidArea = new Rectangle(8, 16, 32, 32);  //Hitbox de Colision (x, y, ancho, largo)
        solidAreaDefaultX = 8;
        solidAreaDefaultY = 16;
        
        setPredeterminado();
        getPlayerImage();
        //getPlayerAttackImage();
        
        proyectil = new Obj_Bomb(gp);
        
    }
    
    public void setPredeterminado(){
        x = 48;
        y = 90;
        velocidad = 1;
        direccion = "abajo";
        
        //Estado de jugador
        vidamax = 2;
        vida = vidamax;
    }
    
    public void getPlayerImage(){
        
        arriba1 = setup("/player/arriba1", gp.window_size, gp.window_size);
        arriba2 = setup("/player/arriba2", gp.window_size, gp.window_size);
        abajo1 = setup("/player/abajo1", gp.window_size, gp.window_size);
        abajo2 = setup("/player/abajo2", gp.window_size, gp.window_size);
        izq1 = setup("/player/izquierda1", gp.window_size, gp.window_size);
        izq2 = setup("/player/izquierda2", gp.window_size, gp.window_size);
        der1 = setup("/player/derecha1", gp.window_size, gp.window_size);
        der2 = setup("/player/derecha2", gp.window_size, gp.window_size);
        
    }
    
    /**public void getPlayerAttackImage() {
    	ataque = setup("/player/bomba1", gp.window_size, gp.window_size);
    	
    }*/
    
    public void actualizar() {
    	
    	/**if(atacando == true) {
    		atacandoMethod();
    	}*/
    	
    	/**else*/ if (control.arriba == true || control.abajo == true || control.izquierda == true || control.derecha == true) {  //
    	
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
	        
	        //Chequear colision de monstruo
	        int indexMonstruo = gp.cChecker.checkEntidad(this, gp.monstruo);
	        contactMonstruo(indexMonstruo);
	        
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
        
    	if(gp.control.espacio == true && proyectil.alive == false) {
    		proyectil.set(x, y, direccion, true);
    		
    		//Añadimos proyectil a la lista.
    		gp.proyectilLista.add(proyectil);
    		
    	}
    	
    	if(invencible == true) {
    		contInvencible++;
    		if (contInvencible > 60) {
    			invencible = false;
    			contInvencible = 0;
    		}
    	} 
    	
    }
    
    /**public void atacandoMethod() {
    	spriteCounter++;
    	if(spriteCounter <= 5) {
    		spriteNum = 1;
    	}
    	if(spriteCounter > 5 && spriteCounter <= 25) {
    		spriteNum = 2;
    	}
    	if(spriteCounter > 25) {
    		spriteNum = 1;
    		spriteCounter = 0;
    		atacando = false;
    	}
    }*/
    
    public void recogerObjeto(int i){ //Tambien sirve para la interaccion entre objetos,
    	if(i != 999){
    		String nombreObjeto = gp.obj[i].nombre;
    		
    		switch(nombreObjeto) {
    			case "bomba":
    				gp.obj[i] = null;
    				break;
    				
    			case "patines":
    				gp.playSE(1);
    				velocidad = velocidad + 1;
    				gp.obj[i] = null;
    				break; 
    				
    			case "vidaextra":
    				gp.playSE(1);
    				if (vida<vidamax){
    					vida = vida + 1;
    				}
    				gp.obj[i] = null;
    				break;
    		}
    	}
    }
    
    /**public void ataqueChecker() {
    	if (gp.control.espacio == true) {
    		atacando = true;
    	}
    }*/
    
    public void contactMonstruo(int i) {
    	if(i != 999) {
    		if(invencible == false) {
    			vida = vida - 1;
    			invencible = true;
    		}
    	}
    }
    
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        //ataqueChecker();
        
        switch(direccion){
            case "arriba": 
	            	if(spriteNum == 1) {image = arriba1;}
	            	if(spriteNum == 2) {image = arriba2;}
                break;
                
            case "abajo":
            	if(spriteNum == 1) {image = abajo1;}
            	if(spriteNum == 2) {image = abajo2;}
                break;
                
            case "izquierda":
            	if(spriteNum == 1) {image = izq1;}
            	if(spriteNum == 2) {image = izq2;}
                break;
                
            case "derecha":
            	if(spriteNum == 1) {image = der1;}
            	if(spriteNum == 2) {image = der2;}
                break;
        }
        
        //if(atacando == true) {
        	//image = ataque;
        //}
       g2.drawImage(image, x, y, null);
       
    }
    
}
