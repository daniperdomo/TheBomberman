package main;

import entidad.Jugador;
import objeto.SuperObjeto;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *
 * @author usuario
 */
public class Panel extends JPanel implements Runnable{
    //Ajustes de pantalla.
    final int original_window_size = 16;  //ventana 16x16 
    final int escala = 3;
    
    public final int window_size = original_window_size * escala;   //tile_size
    public final int columnas_maximas = 17;
    public final int filas_maximas = 13;
    public final int ancho_pantalla = window_size * columnas_maximas;
    public final int alto_pantalla = window_size * filas_maximas;
    
    //FPS
    int fps = 60;
    
    //Sistema
    TileManager tileM = new TileManager(this);
    Controles control = new Controles();
    Sonido sonido = new Sonido();
    public PruebaColision cChecker = new PruebaColision(this);
    public AssetSetter aSetter = new AssetSetter(this);
    //public UI ui = new UI(this);
    Thread hilo;
    
    //Entidades y objetos.
    Jugador jugador = new Jugador(this, control);
    public SuperObjeto obj[] = new SuperObjeto[10];
    
    public Panel () {
        this.setPreferredSize(new Dimension(ancho_pantalla, alto_pantalla));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        this.addKeyListener(control);
        this.setFocusable(true);
    }
    
    public void setupGame() {
    	
    	aSetter.setObject();
    	
    	playMusic(2);
    }
    
    public void iniciar_hilo(){
        hilo = new Thread(this);
        hilo.start();
    }
    
    @Override  
    public void run() {
        double ciclo_dibujo = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while (hilo != null){  //En este bucle actualizamos informacion sobre la posicion del personaje y dibujar la pantalla.
            currentTime = System.nanoTime();
            delta = delta + ((currentTime - lastTime) / ciclo_dibujo);
            timer = timer + (currentTime- lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                actualizar();
                repaint();
                delta--;
                drawCount++;
            }
        
            if(timer >=1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
        
        
    }
    
    public void actualizar() {
        jugador.actualizar();
    }
    
    @Override
    public void paintComponent(Graphics g){  //Metodo estandar de java para dibujar en panel.
        
        super.paintComponent(g);
    
        Graphics2D g2 = (Graphics2D)g;
        
        //Tile
        tileM.draw(g2);
        
        //Objeto
        for (int i=0; i<obj.length; i++) {
        	if(obj[i] != null) {
        		obj[i].draw(g2, this);
        	}
        }
        
        //Jugador
        jugador.dibujar(g2);
        
        //UI
        //ui.draw(g2);
        
        g2.dispose();
    }
    
    public void playMusic(int i) {
    	sonido.setFile(i);
    	sonido.play();
    	sonido.loop();
    }
    public void stopMusic() {
    	sonido.stop();
    }
    public void playSE(int i) {
    	sonido.setFile(i);
    	sonido.play(); 
    }
    
}
