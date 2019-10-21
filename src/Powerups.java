import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Powerups {

	private int x;
	private int y;
	private boolean isCollected;
	
	Image powerup01 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup01.png"));
	Image powerup02 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup02.png"));
	Image powerup03 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup03.png"));
	Image powerup04 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup04.png"));
	
	Image powerupToDraw;
	
	
	public void spawnPowerup() {
		Random rnd = new Random();
		// Randomly spawns a powerup.
		int powerup = rnd.nextInt(4);
		this.x = rnd.nextInt(1720) + 100;
		this.y = rnd.nextInt(880) + 100;
		//Debug:
		System.out.println("Powerup:"+ powerup+"X:" +x +"Y:"+y);
		switch (powerup) {
		case 0: powerupToDraw = powerup01;
		case 1: powerupToDraw = powerup02;
		case 2: powerupToDraw = powerup03;
		case 3: powerupToDraw = powerup04;
		isCollected = false;
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
	
	
	
}
