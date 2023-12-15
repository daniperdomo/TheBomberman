package main;

import monstruos.Mon_stone;
import objeto.Obj_Bomb;
import objeto.Obj_Brick;
import objeto.Obj_Patines;
import objeto.Obj_vidaextra;

public class AssetSetter {

	Panel gp;
	
	public AssetSetter (Panel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		//gp.obj[0] = new Obj_Bomb(gp);
		//gp.obj[0].x = 7 * gp.window_size;
		//gp.obj[0].y = 3 * gp.window_size;
		
		gp.obj[1] = new Obj_Patines(gp);
		gp.obj[1].x = 5 * gp.window_size;
		gp.obj[1].y = 8 * gp.window_size;
		
		gp.obj[2] = new Obj_Brick(gp);
		gp.obj[2].x = 7 * gp.window_size;
		gp.obj[2].y = 9 * gp.window_size;
		
		gp.obj[3] = new Obj_vidaextra(gp);
		gp.obj[3].x = 9 * gp.window_size;
		gp.obj[3].y = 9 * gp.window_size;
		
		
	}
	
	public void setMonster() {
		gp.monstruo[0] = new Mon_stone(gp);
		gp.monstruo[0].x = 11 * gp.window_size;
		gp.monstruo[0].y = 11 * gp.window_size;	
		
	}
	
}
