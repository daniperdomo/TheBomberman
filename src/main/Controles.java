package main;
import java.awt.event.KeyEvent;

//Implementando KeyListener debes hacer uso de 3 metodos, key typed/pressed/released
import java.awt.event.KeyListener; 

/**
 *
 * @author usuario
 */
public class Controles implements KeyListener{
    
    public Boolean arriba = false, abajo = false, izquierda = false, derecha = false;
    
    @Override
    public void keyTyped(KeyEvent e) {
    //No se usa.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
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
        
    }
}

