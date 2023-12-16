package objeto;

import entidad.Proyectil;
import main.Panel;

public class Obj_Bomb extends Proyectil {

	Panel gp;
	
	public Obj_Bomb(Panel gp) {
		super(gp);
		this.gp = gp;
		
		nombre = "bomba";
		velocidad = 5;
		vidamax = 80;
		vida = vidamax;
		//ataque = 2;
		useCost = 1;
		alive = false;
		getImage();
		
	}
	
	public void getImage() {
		arriba1 = setup("/proyectil/exp_arriba", gp.window_size, gp.window_size);
		abajo1 = setup("/proyectil/exp_abajo", gp.window_size, gp.window_size);
		izq1 = setup("/proyectil/exp_izq", gp.window_size, gp.window_size);
		der1 = setup("/proyectil/exp_der", gp.window_size, gp.window_size);
	}
	
	public void set() {
		
	}
	
	public void update() {
		
	}

}
