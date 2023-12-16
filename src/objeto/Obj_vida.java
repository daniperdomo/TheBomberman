package objeto;

import entidad.Entidad;
import main.Panel;
import main.UtilityTool;

public class Obj_vida extends Entidad{
	
	UtilityTool uTool = new UtilityTool();
	
	public Obj_vida(Panel gp) {
		super(gp);
		
		nombre = "corazon";
		image = setup("/objetos/heart", gp.window_size, gp.window_size);
		image2 = setup("/objetos/emptyheart", gp.window_size, gp.window_size);
		
	}
}
