package objeto;

import entidad.Entidad;
import main.Panel;
import main.UtilityTool;

public class Obj_vidaextra extends Entidad{

	UtilityTool uTool = new UtilityTool();
	
	public Obj_vidaextra(Panel gp) {
		super(gp);
		
		nombre = "vidaextra";
		abajo1 = setup("/objetos/vidaextra");
	}
}
