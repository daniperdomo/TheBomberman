package monstruos;

import java.util.Random;

import entidad.Entidad;
import main.Panel;

public class Mon_stone extends Entidad{

	public Mon_stone(Panel gp) {
		super(gp);
		
		tipo = 1;
		
		nombre = "mon_stone";
		velocidad = 1;
		vidamax = 1;
		vida = vidamax;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		arriba1 = setup("/bad_guys/stonearriba1");
		arriba2 = setup("/bad_guys/stonearriba2");
		abajo1 = setup("/bad_guys/stoneabajo1");
		abajo2 = setup("/bad_guys/stoneabajo2");
		izq1 = setup("/bad_guys/stoneizquierda1");
		izq2 = setup("/bad_guys/stoneizquierda2");
		der1 = setup("/bad_guys/stonederecha1");
		der2 = setup("/bad_guys/stonederecha2");
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;
			
			if(i<=25) {
				direccion = "arriba";
			}
			if(i>25 && i <=50) {
				direccion = "abajo";
			}
			if(i>50 && i <=75) {
				direccion = "izquierda";
			}
			if(i>75 && i <=100) {
				direccion = "derecha";
			}
			actionLockCounter = 0;
			
		}
		
	}

}
