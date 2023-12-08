package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.Panel;
import javax.imageio.ImageIO;

public class TileManager {
	int i;
	Panel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(Panel gp){
		this.gp = gp;
		
		tile = new Tile[10];  //Cantidad de muebles a añadir.
		mapTileNum = new int[gp.columnas_maximas][gp.filas_maximas];		
		
		getTileImage();
		cargarMapa("/mapas/mapa.txt");
	}
	
	public void getTileImage () {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/muro.png"));
			tile[0].colision = true;
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/black.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass1.png")); 
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarMapa(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int fil = 0;
			
			while(col < gp.columnas_maximas && fil < gp.filas_maximas) {
				
				String linea = br.readLine();
				
				while(col < gp.columnas_maximas && fil < gp.filas_maximas) {
					String numeros[] = linea.split(" ");
					
					int num = Integer.parseInt(numeros[col]);
					
					mapTileNum[col][fil] = num;
					col++;
				}
					if (col == gp.columnas_maximas) {
						col = 0;
						fil++;
					}
			}
			br.close();
			
		} catch(Exception e) {
			
		}
		
		
	}
	
	
	public void draw(Graphics2D g2) {
		
		int col = 0; int fil = 0; int x = 0; int y = 0;
		
		while(col < gp.columnas_maximas && fil < gp.filas_maximas) {
			
			int tileNum = mapTileNum[col][fil];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.window_size, gp.window_size, null);
			col++;
			x = x +gp.window_size;
			
			if(col == gp.columnas_maximas) {
				col = 0;
				x = 0;
				fil++;
				y = y + gp.window_size;
			}
			
		}
		
	}
}
