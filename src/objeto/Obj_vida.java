package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;
import objeto.SuperObjeto;
import main.Panel;

public class Obj_vida extends SuperObjeto{
	Panel gp;
	public Obj_vida(Panel gp) {
		this.gp = gp;
		
		nombre = "corazon";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/heart.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objetos/emptyheart.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
