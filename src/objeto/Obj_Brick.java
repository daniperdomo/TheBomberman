package objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Brick extends SuperObjeto{
	
	public Obj_Brick() {
		
		nombre = "bricks";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objetos/brick.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
}

}
