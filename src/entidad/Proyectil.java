package entidad;

import main.Panel;

public class Proyectil extends Entidad{

	public Proyectil(Panel gp) {
		super(gp);
		
	}
	
	public void set(int x, int y, String direccion, boolean alive) {
		this.x = x;
		this.y = y;
		this.alive = alive;
		this.vida = vidamax;
	}
	
	public void update() {
		
		switch(direccion) {
		case "arriba": y-= velocidad; break;
		case "abajo": y+= velocidad; break;
		case "izquierda": x-= velocidad; break;
		case "derecha": x+= velocidad; break;
		}
		
		vida--;
		if(vida <= 0) {
			alive = false;
		}
		
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
	}
	
}
