
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Rocket {

	private int x;
	private int y;
	private int speed = 1;
	Image image = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\rocket.png"));
	
	
	public Rocket(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void move() {
		this.x = this.x-speed;
	}
	
	public void paint(GraphicsContext ge) {
		ge.drawImage(this.image, this.x, this.y+22);
	}    
  
	public int getX() {
	                 	return x;
	}
	
	public boolean isVisible() {
		return false;
	}
	
	
	
	@Override
	public String toString() {
		return "Rocket [x=" + x + ", y=" + y + ", speed=" + speed + "]";
	}
	
	public Bounds getBounds() {
		Rectangle r = new Rectangle(this.x, this.y, 50, 20);
		return r.getBoundsInLocal();
	}
	
}
