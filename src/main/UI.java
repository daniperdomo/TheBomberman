package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

public class UI {
	
	Panel gp;
	Graphics2D g2;
	Font menuFont, opcionesFont;
	Font italic_40;
	public int comando = 0;
	
	public UI (Panel gp) {
		this.gp = gp;
		
		try {
		InputStream is = getClass().getResourceAsStream("/fonts/menufont.ttf");
		menuFont = Font.createFont(Font.TRUETYPE_FONT, is);
		is = getClass().getResourceAsStream("/fonts/opcionesmenu.ttf");
		opcionesFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(italic_40);
		g2.setColor(Color.white);
		
		//Menu de Inicio
		if(gp.estadoJuego == gp.menuInicio) {
			drawmenuInicio();
		}
		
		//En juego
		if(gp.estadoJuego == gp.enJuego) {
			//Luego
		}
		//En pausa
		if(gp.estadoJuego == gp.enPausa) {
			PantallaPausa();
		}
		
			
	}
	
	public void drawmenuInicio() {
	    Font font = menuFont.deriveFont(70F); // Cambiar el tamaño de la fuente
	    Font font2 = opcionesFont.deriveFont(35F); 
	    g2.setFont(font);
	    
	    //Titulo del menu
	    String texto = "The Bomberman";
	    int x = getXforCenteredText(texto);
	    int y = gp.window_size*3;
	    
	    //Sombreado de titulo
	    g2.setColor(Color.red);
	    g2.drawString(texto, x+3, y+3);
	    
	    //Color principal y dibujo del menu
	    g2.setColor(Color.yellow);
	    g2.drawString(texto, x, y);
	    
	    //Opciones del menu
	    g2.setFont(font2);
	    
	    texto = "New Game";
	    x = getXforCenteredText(texto);
	    y = y + gp.window_size*4;
	    g2.setColor(Color.white);
	    g2.drawString(texto, x, y);
	    if(comando == 0) {
	    	g2.drawString(">", x-gp.window_size, y);
	    }
	    
	    texto = "Stats";
	    x = getXforCenteredText(texto);
	    y = y + gp.window_size;
	    g2.setColor(Color.white);
	    g2.drawString(texto, x, y);
	    if(comando == 1) {
	    	g2.drawString(">", x-gp.window_size, y);
	    }
	    
	    texto = "Help";
	    x = getXforCenteredText(texto);
	    y = y + gp.window_size;
	    g2.setColor(Color.white);
	    g2.drawString(texto, x, y);
	    if(comando == 2) {
	    	g2.drawString(">", x-gp.window_size, y);
	    }
	    
	}
	
	public void PantallaPausa() {
		g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 40F));
		
		String texto = "EN PAUSA";
		int x = getXforCenteredText(texto);
		int y = gp.alto_pantalla/4;
		
		g2.drawString(texto, x, y);
		
	}
	public int getXforCenteredText(String texto) {
		int length = (int)g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
		int x = (gp.ancho_pantalla/2) - (length/2);
		
		return x;
	}
	
	
}