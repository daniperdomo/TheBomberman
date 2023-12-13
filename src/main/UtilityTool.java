package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {

	public BufferedImage scaleImage(BufferedImage original, int ancho, int alto) {
		
		BufferedImage scaledImage = new BufferedImage(ancho, alto, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, ancho, alto, null);
		g2.dispose();
		
		return scaledImage;
	}
}
