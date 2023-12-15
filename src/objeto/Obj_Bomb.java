package objeto;

import entidad.Entidad;
import main.Panel;
import main.UtilityTool;

public class Obj_Bomb extends Entidad {

	UtilityTool uTool = new UtilityTool();
	
	public Obj_Bomb(Panel gp) {
		super(gp);
		
		nombre = "bomba";
		//abajo1 = setup("/objetos/bomba1");
	}

}
