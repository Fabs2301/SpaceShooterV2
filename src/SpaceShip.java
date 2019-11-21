
import java.net.URL;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class SpaceShip {
	LoadResources lr = new LoadResources();
	Image image = lr.getI_spaceship();
	Image imagedamaged1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship1.png"));
	Image imagedamaged2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship2.png"));
	Image imagedamaged3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship3.png"));
	Image imagedamaged4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedShip4.gif"));
	Image shield = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceshipShield.png"));
	private int x = 0;
	private int y = 0;
	private int damageCount = 0;
	private int maxHealth = 10;
	int currentHealth;
	private boolean isDead = false;
	private int movement = 3;
	long cooldown = 0; 
	int shootTime = 500;
	private boolean shieldActivated = false;
	private int shieldhealth = 2;
	int counter = 0;
	boolean fastShoot = false;
	
	final URL sound29 = getClass().getResource("\\sound\\PewSound.mp3");
	Media sound = new Media(sound29.toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(sound);
	
	public SpaceShip(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**(public void moveUp(int delta) {
	if(isDead == false) {
		y=y-delta;
	}
	}
	
	public void moveDown(int delta) {
		if(isDead == false) {
			y=y+delta;
		}
	}
	
	public void moveLeft(int delta) {
		if(isDead == false) {
			x=x-delta;
		}
	}**/
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/**public void moveRight(int delta) {
		if(isDead == false) {
			x=x+delta;
		}
	}**/
	
	public void move(Direction d, int delta, int intervall)
	{	
		if(isDead == false)
		{
			switch(d)
			{
			case up: y=y-delta; break;
			case down: y=y+delta; break;
			case left: x=x-delta; break;
			case right: x=x+delta; break;
			}
		}
	}
	
	public String toString() {
		
		return "Spaceship(x:"+x+"|y:"+y+")";
	}
	
	public void paint(GraphicsContext ge) {
		
	if(isDead == true) {
		ge.drawImage(imagedamaged4, this.x, this.y);
	}else {
		ge.drawImage(this.image, this.x, this.y);
		if(fastShoot == true)
		{
			counter ++;
			if(counter>300)
			{
				fastShoot = false;
				counter = 0;
			}
		}
		
	}


	}
	
	public Rocket fire() {
		
		Rocket r = new Rocket(this.x+125, this.y+55, -5);
		
		mediaPlayer.stop();
		mediaPlayer.play();
		
		
		return r;
	}
	
	public Bounds getBounds() {
		
		Rectangle r = new Rectangle(this.x, this.y-25, 110, 154);
		return r.getBoundsInLocal();
	}
	
	public void damage() {
		if (shieldActivated == false) {
			if (damageCount == maxHealth / 4) {
				image = imagedamaged1;
				damageCount++;
			} else if (damageCount == maxHealth / 4 * 2) {
				image = imagedamaged2;
				damageCount++;
			} else if (damageCount == maxHealth / 4 * 3) {
				image = imagedamaged3;
				damageCount++;
			} else {
				damageCount++;
			}

			System.out.println("AUUUUUUUUUTSCH!");
		}
		if(shieldhealth == 0) {
		shieldActivated = false;
		image = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
		}else {
			shieldhealth--;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDamageCount() {
		return damageCount;
	}
	
	public void respawn() {
		x= 100;
		y= 100;
		damageCount = 0;
		image = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
	}
	
	public boolean canFire()
    {
        long currentTime = System.currentTimeMillis();
        if(fastShoot == false)
        {
			if(currentTime - cooldown >= shootTime) 
	        {
	             cooldown = currentTime;
	             return true;
	        }
	        else 
	        {
	            return false;
	        }
        } else if(currentTime - cooldown >= 50) 
        {
            cooldown = currentTime;
            return true;
       }
		return false;
    }

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public void setMovement(int movement) {
		this.movement = movement;
	}
	
	public int getMovement() {
		return movement;
	}
	
	public void setShootTime(int shootTime) {
		this.shootTime = shootTime;
	}
	
	public void setDamageCount(int damageCount) {
		this.damageCount = damageCount;
	}
	
	public void fastShoot()
	{
		fastShoot = true;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public void activateShield() {
		this.shieldActivated = true;
		image = shield;
		shieldhealth = 4;
	}
	
}
