import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
	 *  0 rocket
	 *  1 health
	 *  2 coins
	 *  3 shield
	 */
	
	public boolean spawnPowerup() {
		this.randomSpawnNumber = rnd.nextInt(1000);
		//System.out.println(randomSpawnNumber);
		//System.out.println("test");
		
		if(randomSpawnNumber == 500) 
		{
		// Randomly spawns a powerup.
			poweruptype = rnd.nextInt(4);
			this.x = rnd.nextInt(1720) + 100;
			this.y = rnd.nextInt(880) + 100;
			//Debug:
			System.out.println("Powerup:"+ poweruptype+" X:" +x +"Y:"+y);
			if(poweruptype == 0) 
			{
				powerupToDraw = powerup01;
			}
			else if (poweruptype == 1) 
			{
				powerupToDraw = powerup02;
			}
			else if (poweruptype == 2) 
			{
				powerupToDraw = powerup03;
			}
			else if (poweruptype == 3) 
			{
				powerupToDraw = powerup04;
				
			}
			return true;
		}
		return false;
	}
	
	public void paint(GraphicsContext ge) {
		ge.drawImage(powerupToDraw, this.x, this.y);
	}

	
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y, 60, 60);
		return r.getBoundsInLocal();
	}
	
	public void takePowerupsOutBounds() 
	{
		this.x = 2000;
		this.y = 2000;
		
		
	}
	
	public int usePowerUp(SpaceShip s, int score)
	{
		int r = score;
		switch(poweruptype)
		{
		case 0: s.fastShoot(); break;
		case 1: 
			if(s.currentHealth+2<s.getMaxHealth())
			{
				s.setDamageCount(s.getDamageCount()-2);
			}
			else
			{
				s.setDamageCount(0);
			}
		break;
		case 2: r+=50; break;
		case 3: s.activateShield(); break;
		default: System.out.println("error");
		}
		return r;
		
	}
	
	
	
}
