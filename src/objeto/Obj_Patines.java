package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Patines extends SuperObjeto{

	public Obj_Patines() {
			
			nombre = "patines";
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/objetos/patines.png"));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
}
