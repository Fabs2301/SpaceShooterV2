import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Powerups {

	private int x;
	private int y;
	private int poweruptype;
	private int randomSpawnNumber;
	Random rnd = new Random();
	
	Image powerup01 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup01.png"));
	Image powerup02 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup02.png"));
	Image powerup03 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup03.png"));
	Image powerup04 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup04.png"));
	
	Image powerupToDraw;
	/**
	 * 
	 * @return
	 * -1 false
	 *  0
	 *  1
	 *  2
	 *  3 
	 */
	
	public int spawnPowerup() {
		this.randomSpawnNumber = rnd.nextInt(1000);
		System.out.println(randomSpawnNumber);
		
		if(randomSpawnNumber == 500) {
		// Randomly spawns a powerup.
		poweruptype = rnd.nextInt(4);
		this.x = rnd.nextInt(1720) + 100;
		this.y = rnd.nextInt(880) + 100;
			//Debug:
			System.out.println("Powerup:"+ poweruptype+"X:" +x +"Y:"+y);
			if(poweruptype == 0) {
				powerupToDraw = powerup01;
				return 0;
			}else if (poweruptype == 1) {
				powerupToDraw = powerup02;
				return 1;
			}else if (poweruptype == 2) {
				powerupToDraw = powerup03;
				return 2;
			}else if (poweruptype == 3) {
				powerupToDraw = powerup04;
				return 3;
			}
			
		}else {
			return -1;
		}
		//Damit Compiler sich nicht aufregt.
		return -1;
	}
	
	public void paint(GraphicsContext ge) {
		ge.drawImage(powerupToDraw, this.x, this.y);
	}

	
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y, 60, 60);
		return r.getBoundsInLocal();
	}
	
	public void takePowerupsOutBounds(SpaceShip s) {
		this.x = 2000;
		this.y = 2000;
	if(poweruptype == 1) {
		s.setCurrentHealth(s.getMaxHealth());
	}
		
	}
	
	
	
}
