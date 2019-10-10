
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SpaceShip {
//
	Image image = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
	Image imagedamaged1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship1.png"));
	Image imagedamaged2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship2.png"));
	Image imagedamaged3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship3.png"));
	Image imagedamaged4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedShip4.gif"));
	private int x = 0;
	private int y = 0;
	private int damageCount = 0;
	private int maxHealth = 10;
	private boolean isDead = false;
	private int movement = 10;
	
	long cooldown = 0; 
	int shootTime = 500;
	
	public SpaceShip(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp(int delta) {
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
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void moveRight(int delta) {
		if(isDead == false) {
			x=x+delta;
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
	}


	}
	

	
	public Rocket fire() {
		
		Rocket r = new Rocket(this.x+125, this.y+55, -5);
		return r;
	}
	
	public Bounds getBounds() {
		
		Rectangle r = new Rectangle(this.x, this.y-25, 160, 154);
		return r.getBoundsInLocal();
	}
	
	public void damage() {
		
		if(damageCount == maxHealth/4) {
			image = imagedamaged1;
			damageCount ++;
		}else if(damageCount == maxHealth/4*2) {
			image = imagedamaged2;
			damageCount++;
		}else if(damageCount == maxHealth/4 *3) {
			image = imagedamaged3;
			damageCount ++;
		}else {
			damageCount ++;
		}
		
		System.out.println("AUUUUUUUUUTSCH!");
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
		x= 50;
		y= 50  ;
		damageCount = 0;
		image = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
	}
	
	public boolean canFire()
    {
        long currentTime = System.currentTimeMillis();
        
		if(currentTime - cooldown >= shootTime) 
        {
             cooldown = currentTime;
             return true;
        }
        else 
        {
            return false;
        }
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
	
}
