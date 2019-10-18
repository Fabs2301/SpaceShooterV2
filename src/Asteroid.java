import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Asteroid {

	private int x;
	private int y;
	private int speed = 1;
	//Image asteroidImage = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroid.png"));
	Image damagedAsteroidImage = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroiddamaged.png"));
	Image asteroid = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroid.png"));
    boolean isDamaged = false;
	private Integer coordinateWhenRemoved = x ;
	
	public Asteroid(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void move() {
		this.x = this.x-speed;
	}
	
	public void paint(GraphicsContext ge) {
		ge.drawImage(asteroid, this.x, this.y);
	}

	public void reposition(int width, int height, int maxSpeed, int minSpeed) {
		
		Random rnd = new Random();
		
		this.x = width + rnd.nextInt(width);
		this.y = rnd.nextInt(height)+85;
		this.speed = rnd.nextInt(maxSpeed-minSpeed)+minSpeed;
	}
	
	public int getX() {
		return x;
	}
	
	@Override
	public String toString() {
		return "Asteroid [x=" + x + ", y=" + y + ", speed=" + speed + "]";
	}
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y, 60, 60);
		return r.getBoundsInLocal();
	}
	 
	public void explosion() {
		asteroid = damagedAsteroidImage; 
		coordinateWhenRemoved = x-(20*speed);
		isDamaged = true;
		
	}

	public boolean isShouldBeRemoved() {
		
		if(x > coordinateWhenRemoved) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	
	
}
