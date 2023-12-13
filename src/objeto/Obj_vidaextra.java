package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class Obj_vidaextra extends SuperObjeto{

	Panel gp;
	public Obj_vidaextra(Panel gp) {
		this.gp = gp;
		
		nombre = "vidaextra";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/vidaextra.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
