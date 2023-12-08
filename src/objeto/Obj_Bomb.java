package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class Obj_Bomb extends SuperObjeto {
	
	Panel gp;
	
	public Obj_Bomb(Panel gp) {
		this.gp = gp;
		
		nombre = "bomba";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/bomba1.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
