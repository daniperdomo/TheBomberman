package objeto;

import entidad.Entidad;
import main.Panel;
import main.UtilityTool;

public class Obj_Brick extends Entidad{
	
	UtilityTool uTool = new UtilityTool();
	
	public Obj_Brick(Panel gp) {
		super(gp);
		
		nombre = "bricks";
		abajo1 = setup("/objetos/brick", gp.window_size, gp.window_size);
		
	}
}


