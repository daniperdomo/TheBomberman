package main;
import java.awt.event.KeyEvent;

//Implementando KeyListener debes hacer uso de 3 metodos, key typed/pressed/released
import java.awt.event.KeyListener; 

/**
 *
 * @author usuario
 */
public class Controles implements KeyListener{
    Panel gp;
    public Boolean arriba = false, abajo = false, izquierda = false, derecha = false, espacio = false;
    
    public Controles(Panel gp) {
    	this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    //No se usa.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        //EN MENU DE INICIO
        if (gp.estadoJuego == gp.menuInicio) {
        	if (code == KeyEvent.VK_W){
        		if(gp.ui.comando > 0) {
                gp.ui.comando--; }
            }
            
            if (code == KeyEvent.VK_S){
            	if (gp.ui.comando < 2) {
            	gp.ui.comando++; }
            }
        	
            if(code == KeyEvent.VK_ENTER) {
            	if(gp.ui.comando == 0) {
            		gp.estadoJuego = gp.enJuego;
            		gp.stopMusic();
            		gp.playMusic(0);
            	}
            	if(gp.ui.comando == 1) {
            		//Luego se hace el panel de estadisticas
            	}
            	
            	if(gp.ui.comando == 2) {
            		//Luego se hace el panel de ayuda
            	}
            }
            
        }
        
        //EN JUEGO
        if (code == KeyEvent.VK_W){
            arriba = true;
        }
        
        if (code == KeyEvent.VK_S){
            abajo = true;
        }
        
        if (code == KeyEvent.VK_A){
            izquierda = true;
        }
        
        if (code == KeyEvent.VK_D){
            derecha = true;
        }
        
        if (code == KeyEvent.VK_SPACE){
            espacio = true;
        }
        
        if (code == KeyEvent.VK_P){
            if(gp.estadoJuego == gp.enJuego) {
            	gp.estadoJuego = gp.enPausa;
            }
            else if(gp.estadoJuego == gp.enPausa) {
            	gp.estadoJuego = gp.enJuego;
            	
            }
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_W){
            arriba = false;
        }
        
        if (code == KeyEvent.VK_S){
            abajo = false;
        }
        
        if (code == KeyEvent.VK_A){
            izquierda = false;
        }
        
        if (code == KeyEvent.VK_D){
            derecha = false;
        }
        
        if (code == KeyEvent.VK_E){
            espacio = false;
        }
        
    }
}

