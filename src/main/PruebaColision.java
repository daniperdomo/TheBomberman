package main;

import entidad.Entidad;

public class PruebaColision {

	Panel gp;
	
	public PruebaColision (Panel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entidad entidad) {
		int entidadLeftWorldX = entidad.x + entidad.solidArea.x;
		int entidadRightWorldX = entidad.x + entidad.solidArea.x + entidad.solidArea.width;
		int entidadTopWorldY = entidad.y + entidad.solidArea.y; 
		int entidadBottomWorldY = entidad.y + entidad.solidArea.y + entidad.solidArea.height;
		
		int entidadLeftCol = entidadLeftWorldX/gp.window_size;
		int entidadRightCol = entidadRightWorldX/gp.window_size;
		int entidadTopFil = entidadTopWorldY/gp.window_size;
		int entidadBottomFil = entidadBottomWorldY/gp.window_size;
		
		int tileNum1, tileNum2;
		
		switch(entidad.direccion) {
		case "arriba":
			entidadTopFil = (entidadTopWorldY - entidad.velocidad)/gp.window_size;
			tileNum1 = gp.tileM.mapTileNum[entidadLeftCol][entidadTopFil];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadTopFil];
			if(gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "abajo":
			entidadBottomFil = (entidadBottomWorldY + entidad.velocidad)/gp.window_size;
			tileNum1 = gp.tileM.mapTileNum[entidadLeftCol][entidadBottomFil];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadBottomFil];
			if(gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "izquierda":
			entidadLeftCol = (entidadLeftWorldX - entidad.velocidad)/gp.window_size;
			tileNum1 = gp.tileM.mapTileNum[entidadLeftCol][entidadTopFil];
			tileNum2 = gp.tileM.mapTileNum[entidadLeftCol][entidadBottomFil];
			if(gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "derecha":
			entidadRightCol = (entidadRightWorldX + entidad.velocidad)/gp.window_size;
			tileNum1 = gp.tileM.mapTileNum[entidadRightCol][entidadTopFil];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadBottomFil];
			if(gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		}
		
	}
	
	public int checkObjeto(Entidad entidad, boolean jugador) { //Chequea si un jugador esta tocando un objeto, si lo hace retorna el index.
		
		int index = 999;
		
		for(int i=0; i< gp.obj.length; i++) {
			if(gp.obj[i] != null) {
				//Obtener posicion de entidad.
				entidad.solidArea.x = entidad.x + entidad.solidArea.x;
				entidad.solidArea.y = entidad.y + entidad.solidArea.y;
				
				//Obtener posicion de objeto.
				gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;
				
				switch(entidad.direccion) {
				case "arriba":
					entidad.solidArea.y = entidad.solidArea.y - entidad.velocidad; 
					if(entidad.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "abajo":
					entidad.solidArea.y = entidad.solidArea.y + entidad.velocidad;
					if(entidad.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "izquierda":
					entidad.solidArea.x = entidad.solidArea.x - entidad.velocidad;
					if(entidad.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "derecha":
					entidad.solidArea.x = entidad.solidArea.x + entidad.velocidad;
					if(entidad.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					break;
					}
				}
				entidad.solidArea.x = entidad.solidAreaDefaultX;
				entidad.solidArea.y = entidad.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
			
		}
		
		return index;
	}
}
