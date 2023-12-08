package main;

import objeto.Obj_Bomb;
import objeto.Obj_Brick;
import objeto.Obj_Patines;

public class AssetSetter {

	Panel gp;
	
	public AssetSetter (Panel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		//gp.obj[0] = new Obj_Bomb();
		//gp.obj[0].x = 7 * gp.window_size;
		//gp.obj[0].y = 3 * gp.window_size;
		
		gp.obj[1] = new Obj_Patines(gp);
		gp.obj[1].x = 5 * gp.window_size;
		gp.obj[1].y = 8 * gp.window_size;
		
		gp.obj[2] = new Obj_Brick(gp);
		gp.obj[2].x = 7 * gp.window_size;
		gp.obj[2].y = 9 * gp.window_size;
		
	}
}
