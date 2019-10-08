import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Asteroid {

	private int x;
	private int y;
	private int speed = 1;
	Image asteroidImage = new Image(Starter.class.getClassLoader().getResourceAsStream("asteroid.png"));
	Image damagedAsteroidImage = new Image(Starter.class.getClassLoader().getResourceAsStream("asteroiddamaged.png"));
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
		ge.drawImage(this.asteroidImage, this.x, this.y);
	}

	public void reposition(int width, int height) {
		
		Random rnd = new Random();
		
		this.x = width + rnd.nextInt(width);
		this.y = rnd.nextInt(height)+50;
		this.speed = rnd.nextInt(6)+1;
	}
	
	public int getX() {
		return x;
	}
	
	@Override
	public String toString() {
		return "Asteroid [x=" + x + ", y=" + y + ", speed=" + speed + "]";
	}
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y-25, 25, 25);
		return r.getBoundsInLocal();
	}
	 
	public void explosion() {
		     asteroidImage = damagedAsteroidImage; 
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
