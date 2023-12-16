package objeto;

import entidad.Entidad;
import main.Panel;
import main.UtilityTool;

public class Obj_Patines extends Entidad{
	
	UtilityTool uTool = new UtilityTool();
	
	public Obj_Patines(Panel gp) {
			super(gp);
			nombre = "patines";
			abajo1 = setup("/objetos/patines", gp.window_size, gp.window_size);
	}
}
