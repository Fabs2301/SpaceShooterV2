import java.util.Random;
import javafx.scene.image.Image;

public class Powerups {

	private int x;
	private int y;
	
	Image powerup01 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup01.png"));
	Image powerup02 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup02.png"));
	Image powerup03 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup03.png"));
	Image powerup04 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\powerup04.png"));
	
	
	public void spawnPowerup(int width, int heigth) {
		Random rnd = new Random();
		
	}
}
