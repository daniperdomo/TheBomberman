package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Bomb extends SuperObjeto {
	
	public Obj_Bomb() {
		
		nombre = "bomba";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/bomba1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
