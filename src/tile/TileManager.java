package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.Panel;
import main.UtilityTool;

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
		
			setup(0, "muro", true);
			setup(1, "black", true);
			setup(2, "grass1", false);
			setup(3, "grass2", false);
			
			
	}
	
	public void setup(int index, String imageName, boolean colision) {
		
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.window_size, gp.window_size);
			tile[index].colision = colision;		
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
			
			g2.drawImage(tile[tileNum].image, x, y, null);
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
