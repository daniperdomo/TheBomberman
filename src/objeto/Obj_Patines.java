package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class Obj_Patines extends SuperObjeto{
	
	Panel gp;
	
	public Obj_Patines(Panel gp) {
			this.gp = gp;
			nombre = "patines";
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/objetos/patines.png"));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
}
