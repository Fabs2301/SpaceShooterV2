import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Powerups {

	private int x;
	private int y;
	private boolean isCollected;
	private int poweruptype;
	
	Image powerup01 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup01.png"));
	Image powerup02 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup02.png"));
	Image powerup03 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup03.png"));
	Image powerup04 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup04.png"));
	
	Image powerupToDraw;
	
	
	public void spawnPowerup() {
		Random rnd = new Random();
		// Randomly spawns a powerup.
		poweruptype = rnd.nextInt(4);
		this.x = rnd.nextInt(1720) + 100;
		this.y = rnd.nextInt(880) + 100;
		//Debug:
		System.out.println("Powerup:"+ poweruptype+"X:" +x +"Y:"+y);
		if(poweruptype == 0) {
			powerupToDraw = powerup01;
		}else if (poweruptype == 1) {
			powerupToDraw = powerup02;
		}else if (poweruptype == 2) {
			powerupToDraw = powerup03;
		}else if (poweruptype == 3) {
			powerupToDraw = powerup04;
		}
		
	}
	
	public void paint(GraphicsContext ge) {
		ge.drawImage(powerupToDraw, this.x, this.y);
	}

	public boolean isCollected() {
		return isCollected;
	}

	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y, 60, 60);
		return r.getBoundsInLocal();
	}
	
	
	
}
