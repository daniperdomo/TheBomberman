package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel;

public class Obj_Brick extends SuperObjeto{
	
	Panel gp;
	
	public Obj_Brick(Panel gp) {
		this.gp = gp;
		nombre = "bricks";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/brick.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
}

}
