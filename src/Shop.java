import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Shop {

	private int healthUpgradeLevel;
	private int speedUpgradeLevel;
	private int shootingUpgradeLevel;
	
	private int healthPrice = 100;
	private int speedPrice = 100;
	private int shootingPrice = 100;

	
	
	public Shop(int healthUpgradeLevel, int speedUpgradeLevel, int shootingUpgradeLevel) {
		super();
		this.healthUpgradeLevel = healthUpgradeLevel;
		this.speedUpgradeLevel = speedUpgradeLevel;
		this.shootingUpgradeLevel = shootingUpgradeLevel;
	}
	
	public void upgradeHealth(SpaceShip s) {
		if(healthUpgradeLevel == 0) {
			healthUpgradeLevel = 1;
			healthPrice = 200;
			s.setMaxHealth(15);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(healthUpgradeLevel == 1) {
			healthUpgradeLevel = 2;
			healthPrice = 300;
			s.setMaxHealth(20);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(healthUpgradeLevel == 2) {
			healthUpgradeLevel = 3;
			s.setMaxHealth(30);
			healthPrice = 400;
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(healthUpgradeLevel == 3) {
			healthUpgradeLevel = 4;
			// 0 bedeutet ausverkauft
			healthPrice = 0;
			s.setMaxHealth(40);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else {
			final URL sound34 = getClass().getResource("\\sound\\NoSound.mp3");
			Media sound3 = new Media(sound34.toString());
			final MediaPlayer NoSound = new MediaPlayer(sound3);
			NoSound.play();
		}
	}
	
	public void upgradeSpeed(SpaceShip s) {
		if(speedUpgradeLevel == 0) {
			speedUpgradeLevel = 1;
			speedPrice = 200;
			s.setMovement(5);

		}else if(speedUpgradeLevel == 1) {
			speedUpgradeLevel = 2;
			speedPrice = 300;
			s.setMovement(6);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(speedUpgradeLevel == 2) {
			speedUpgradeLevel = 3;
			speedPrice = 400;
			s.setMovement(8);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(speedUpgradeLevel == 3) {
			speedUpgradeLevel = 4;
			// 0 bedeutet ausverkauft
			speedPrice = 0;
			s.setMovement(10);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else {
			final URL sound34 = getClass().getResource("\\sound\\NoSound.mp3");
			Media sound3 = new Media(sound34.toString());
			final MediaPlayer NoSound = new MediaPlayer(sound3);
			NoSound.play();
		}
	}
	
	public void upgradeShooting(SpaceShip s) {
		if(shootingUpgradeLevel == 0) {
			shootingUpgradeLevel = 1;
			shootingPrice = 200;
			s.setShootTime(750);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(shootingUpgradeLevel == 1) {
			shootingUpgradeLevel = 2;
			shootingPrice = 300;
			s.setShootTime(500);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(shootingUpgradeLevel == 2) {
			shootingUpgradeLevel = 3;
			shootingPrice = 400;
			s.setShootTime(250);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else if(shootingUpgradeLevel == 3) {
			shootingUpgradeLevel = 4;
			// 0 bedeutet ausverkauft
			shootingPrice = 0;
			s.setShootTime(200);
			final URL sound33 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound10 = new Media(sound33.toString());
			final MediaPlayer upgradeSound = new MediaPlayer(sound10);
			upgradeSound.play();
		}else {
			final URL sound34 = getClass().getResource("\\sound\\NoSound.mp3");
			Media sound3 = new Media(sound34.toString());
			final MediaPlayer NoSound = new MediaPlayer(sound3);
			NoSound.play();
		}
	}

	public int getHealthUpgradeLevel() {
		return healthUpgradeLevel;
	}

	public int getSpeedUpgradeLevel() {
		return speedUpgradeLevel;
	}

	public int getShootingUpgradeLevel() {
		return shootingUpgradeLevel;
	}

	public int getHealthPrice() {
		return healthPrice;
	}

	public int getSpeedPrice() {
		return speedPrice;
	}

	public int getShootingPrice() {
		return shootingPrice;
	}
	
	
	
}
