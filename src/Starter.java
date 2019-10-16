import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Starter extends Application implements EventHandler<KeyEvent> {

	int width = 1920;
	int heigth = 1080;
	
	SpaceShip s = new SpaceShip(500, 500);
	Shop shop = new Shop(0,0,0);
	
	List<Asteroid> asteroiden = new ArrayList<Asteroid>();
	List<Rocket> rocket = new ArrayList<Rocket>();
	Image background = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\giphy.gif"));
	Image gameOverImg = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\gameOver.gif"));
	Image titleImg = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\title.png"));
	Image guiBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\GUIBackground.png"));
	Image cursor = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Arrow.png"));
	Image upgradeBox = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\updateBox.png"));
	Image upgradeBlock = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\upgradeBlock.png"));
	Image controlsArrows = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsArrows.png"));
	Image controlsShift = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsShift.png"));
	Image controlsSpace = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsSpace.png"));
	Image whiteBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\White.png"));
	
	Image Image1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image1.png"));
	Image Image2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image2.png"));
	Image Image3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image3.png"));
	Image Image4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image4.jpg"));
	Image Image5 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image5.png"));
	Image Image6 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image6.png"));
	
	boolean toogleMusic = true;
	public int intscore = 1000;
	String score = "Points:"+intscore;
	String music = "Music: off (M)";
	int setScene = 0;	//sets the scene in the game 0 = title screen, 1 = game screen, 2 = game over screen, 3 = shop screen, 4 = storyscreen, 5 = PauseScreen, 6 = EasterEgg Screen
	boolean switchSceneToGameOver = false;
	long count = 0;
	int currentHealth = s.getMaxHealth();
	long deathCount;
	int cursorCorY = 670;
	int cursorCorX = 620;
	double moveText = 50;
	
	Font bitFontB = 
            Font.loadFont(getClass()
                .getResourceAsStream("\\font\\bitFond.ttf"), 40);
	
	Font bitFontM = 
            Font.loadFont(getClass()
                .getResourceAsStream("\\font\\bitFond.ttf"), 25);
	
	Font bitFontS = 
            Font.loadFont(getClass()
                .getResourceAsStream("\\font\\bitFond.ttf"), 20);
	

	public static void main (String args[]) {
		Application.launch();
	}
	
	public void start(final Stage primaryStage) throws Exception {

		primaryStage.setTitle("SpaceShooter");
		primaryStage.getIcons().add(titleImg);
		final Image backgroundimageBlack = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\black.png"));
		Group root = new Group();
		final Canvas canvas = new Canvas(1920, 1080);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.setFullScreen(true);

						
		// Create Asteroiden
		for (int i = 0; i < heigth * width / 96000; i++) {

			Asteroid a = new Asteroid(0, 0, 0);
			a.reposition(width / 2, heigth);
			asteroiden.add(a);
		}
		
		primaryStage.show();
		
		
		final URL sound23 = getClass().getResource("\\sound\\inGameMusic.mp3");
		Media sound = new Media(sound23.toString());
		final MediaPlayer inGameMusic = new MediaPlayer(sound);
		
		
		final URL sound24 = getClass().getResource("\\sound\\GameOver.mp3");
		Media sound1 = new Media(sound24.toString());
		final MediaPlayer mediaPlayerGameOver = new MediaPlayer(sound1);
		
		final URL sound25 = getClass().getResource("\\sound\\titleTheme.mp3");
		Media sound4 = new Media(sound25.toString());
		final MediaPlayer titleTheme = new MediaPlayer(sound4);
		
		final URL sound26 = getClass().getResource("\\sound\\easteregg.mp3");
		Media sound12 = new Media(sound26.toString());
		final MediaPlayer easteregg = new MediaPlayer(sound12);

		new AnimationTimer() {
			
			long prevTime;
			
			private boolean needsHandling_FPS(int desiredFrameRatePerSecond)
			{
				long currentNanoTime = System.nanoTime();

				// Framerate = x Frames / second.
				double timePerFrame_s = 1.0 / desiredFrameRatePerSecond;
				long timePerFrame_ns = (long) (timePerFrame_s * 1e9);
				
				if(prevTime + timePerFrame_ns < currentNanoTime)
				{
					prevTime = currentNanoTime;
					return true;
				}
				else
				{
					return false;
				}
			}
			
			@Override
			public void handle(long currentNanoTime) {	
			
				 if (needsHandling_FPS(120) == false) 
			        {
			            return;
			        }
				
				if(setScene == 1) {	
				mediaPlayerGameOver.stop();
				titleTheme.stop();
 				
				//toogle music
				if(toogleMusic == false) {
					inGameMusic.stop();
					music = "Music: off (M)";

				}else if(toogleMusic == true) {
					inGameMusic.play();
					music = "Music: on (M)";

				}	
				
				//Ingame music loop (2:48 min) 
				Double musicTimer = inGameMusic.getCurrentTime().toSeconds();
				if(musicTimer > 168.0) {
					inGameMusic.stop();
					inGameMusic.play();
				}
				// Screen blanking and background:
				canvas.getGraphicsContext2D().clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
				canvas.getGraphicsContext2D().drawImage(background, 0, 0);
				canvas.getGraphicsContext2D().drawImage(guiBackground, 0, 0);
				
				//GUI Upadate:
				
				if(currentHealth >0) {
					 currentHealth = s.getMaxHealth() -s.getDamageCount();
				}
				
				canvas.getGraphicsContext2D().setFont(bitFontM);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);;
				canvas.getGraphicsContext2D().fillText(score, 1600, 45);
				canvas.getGraphicsContext2D().fillText("Health:"+ currentHealth+"/"+s.getMaxHealth(), 20, 45);
				
				canvas.getGraphicsContext2D().setFont(bitFontS);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);;
				canvas.getGraphicsContext2D().fillText(music, 0, 1080);
				// paint cycle(paints ship)
				s.paint(canvas.getGraphicsContext2D());				
				
				// asteroiden
				// recycling----------------------------------------------------------------------
				for (Iterator<Asteroid> iterator = asteroiden.iterator(); iterator.hasNext();) {
					Asteroid ast = iterator.next();
					if (ast.getX() > 0) {
						ast.paint(canvas.getGraphicsContext2D());
						ast.move();
					} else {
						iterator.remove();
					}

				}
				if (asteroiden.size() < heigth * width / 96000) {
					for (int i = 0; i < heigth * width / 96000 - asteroiden.size(); i++) {
						Asteroid a = new Asteroid(0, 0, 0);
						a.reposition(width, heigth);
						asteroiden.add(a);
						System.out.println("Asteroiden Objects:" + asteroiden.size());
					}
				}
				// -------------------------------------------------------------------------------------------
				// Rocket recycling:
				for (Iterator<Rocket> iterator = rocket.iterator(); iterator.hasNext();) {
					Rocket rck = iterator.next();
					if (rck.getX() < primaryStage.getWidth()) {
						rck.paint(canvas.getGraphicsContext2D());
						rck.move();
					} else {
						iterator.remove();
					}

				}
				// -------------------------------------------------------------------------------------------
				// Change Resolution:(Experimentel)
				canvas.setHeight(primaryStage.getHeight());
				canvas.setWidth(primaryStage.getWidth());
				heigth = (int) primaryStage.getHeight();
				width = (int) primaryStage.getWidth();
				// ------------------------------------------------------------------------------------------
				// Colision:
				for (Iterator<Asteroid> iterator = asteroiden.iterator(); iterator.hasNext();) {
					Asteroid ast = iterator.next();
					if (ast.getBounds().intersects(s.getBounds())) {

						if (ast.isDamaged == false) {
							s.damage();
							
							if (intscore >=  10) {
								intscore = intscore-10;
							}else {
								intscore = 0;
							}
							score = "Points:"+intscore;
							iterator.remove();
						} 
 
					}
 					for (Iterator<Rocket> iterator1 = rocket.iterator(); iterator1.hasNext();) {
						Rocket rck = iterator1.next();
						if (rck.getBounds().intersects(ast.getBounds()) && ast.isDamaged == false) {

							ast.explosion();
							iterator1.remove();
							intscore = intscore+10;
							score = "Points:"+intscore;
						}

					}
					if (ast.isShouldBeRemoved() == true) {
						iterator.remove();
					}
					if(s.getDamageCount() >= s.getMaxHealth()) {
						
						s.setDead(true);
						if(switchSceneToGameOver == false) {
						deathCount = count;	
						
					final URL sound27 = getClass().getResource("\\sound\\explosion.wav");
					Media sound6 = new Media(sound27.toString());
					final MediaPlayer mediaPlayerExplosion = new MediaPlayer(sound6);
					mediaPlayerExplosion.play();
						}
						switchSceneToGameOver = true;
						

						}
					

					
					if(switchSceneToGameOver == true  && count >= deathCount+2200) {
						setScene = 2;
					}
					count ++;
				}
			}else if(setScene == 2) {
				//Game Over Screen:
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack, 0, 0);
				canvas.getGraphicsContext2D().drawImage(gameOverImg, 625, 100);
				inGameMusic.stop();
				mediaPlayerGameOver.play();
				
				 
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);;
				canvas.getGraphicsContext2D().fillText("Your Points: "+intscore, 625, 585);
			
				canvas.getGraphicsContext2D().setFont(bitFontM);
				canvas.getGraphicsContext2D().fillText("Upgrade Space Ship", 700, 700);
				canvas.getGraphicsContext2D().drawImage(cursor, cursorCorX, cursorCorY);
				canvas.getGraphicsContext2D().fillText("Continue", 700, 750);
				canvas.getGraphicsContext2D().fillText("Exit to Titlescreen", 700, 1000);
				
				switchSceneToGameOver = false;
				s.setDead(false);
				currentHealth = s.getMaxHealth();
			}else if (setScene == 0) {
				//Title screen:
				titleTheme.play();
				canvas.getGraphicsContext2D().drawImage(background, 0, 0);
				canvas.getGraphicsContext2D().drawImage(titleImg, 460, 150);
				
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("Press Enter", 750, 800);
				
				canvas.getGraphicsContext2D().setFont(bitFontS);
				canvas.getGraphicsContext2D().fillText("© 2019 Fabian Gruber & Marcel Winkler		    	ver 2.0", 600, 1020);
				count ++;
				//2130
				if(count >= 2130) {
					setScene = 4;
				}
				System.out.println(count+" frames / 2130 frames");
				
			}else if(setScene == 3) {
				
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack, 0, 0);
				canvas.getGraphicsContext2D().drawImage(guiBackground, 0, 0);
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("SHOP", 240, 35);
				
				String healthPrice;
				String shootingPrice;
				String speedPrice;
				if(shop.getHealthPrice() == 0) {
					healthPrice = "MAX";
				}else {
					healthPrice = shop.getHealthPrice()+" P.";
				}
				if(shop.getShootingPrice() == 0) {
					shootingPrice = "MAX";
				}else {
					shootingPrice = shop.getShootingPrice()+" P.";
				}
				if(shop.getSpeedPrice() == 0) {
					speedPrice = "MAX";
				}else {
					speedPrice = shop.getSpeedPrice()+" P.";
				}
				
				canvas.getGraphicsContext2D().setFont(bitFontM);
				canvas.getGraphicsContext2D().fillText("Points: "+intscore, 5, 75);
				canvas.getGraphicsContext2D().fillText("Back", 490, 75);
				canvas.getGraphicsContext2D().fillText(healthPrice,475, 135);
				canvas.getGraphicsContext2D().fillText(shootingPrice,475, 235);
				canvas.getGraphicsContext2D().fillText(speedPrice,475, 335);
								
				canvas.getGraphicsContext2D().setFont(bitFontS);
				canvas.getGraphicsContext2D().fillText("Health", 100, 105);
				canvas.getGraphicsContext2D().fillText("Shooting Speed", 100, 205);
				canvas.getGraphicsContext2D().fillText("Movement Speed", 100, 305);
			

				
				if (shop.getHealthUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 107, 111);
				} if (shop.getHealthUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 197, 111);
				} if (shop.getHealthUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 282, 111);
				} if (shop.getHealthUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 372, 111);
				}
				
				if (shop.getShootingUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 107, 211);
				} if (shop.getShootingUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 197, 211);
				} if (shop.getShootingUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 282, 211);
				} if (shop.getShootingUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 372, 211);
				}
				
				if (shop.getSpeedUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 107, 311);
				} if (shop.getSpeedUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 197, 311);
				} if (shop.getSpeedUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 282, 311);
				} if (shop.getSpeedUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(upgradeBlock, 372, 311);
				}
				
				canvas.getGraphicsContext2D().drawImage(upgradeBox, 100, 110);
				canvas.getGraphicsContext2D().drawImage(upgradeBox, 100, 210);
				canvas.getGraphicsContext2D().drawImage(upgradeBox, 100, 310);
				
				canvas.getGraphicsContext2D().drawImage(cursor, cursorCorX, cursorCorY);
				
			}else if(setScene == 4) {
				moveText = moveText-0.25; // 0,25
				canvas.getGraphicsContext2D().drawImage(background, 0, 0);
				canvas.getGraphicsContext2D().drawImage(titleImg, 460, moveText);
				
				canvas.getGraphicsContext2D().setFont(bitFontS);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("A long time ago in a galaxy far, far away....\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"It is a period of civil war.\r\n" + 
						"Rebel spaceships, striking\r\n" + 
						"from a hidden base, have won\r\n" + 
						"their first victory against\r\n" + 
						"the evil Galactic Empire.\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"During the battle, Rebel\r\n" + 
						"spies managed to steal secret\r\n" + 
						"plans to the Empire's\r\n" +
						"ultimate weapon, the DEATH\r\n" +
						"STAR, an armored space\r\n" +
						"station with enough power to\r\n" +
						"destroy an entire planet.\r\n" +
						"\r\n" +
						"\r\n" +
						"But on their way home they came\r\n" +
						"into a dangerous aseroid belt\r\n" +
						"that can destroy an entire spaceship\r\n" +
						"It's now up to commander Ewu Trednok \r\n" +
						"and his mate Rettuh to bring the ship \r\n" +
						"save out of the belt.\r\n" +
						"\r\n" +
						"\r\n" +
						"The whole galaxy is counting on you !\r\n" +
						"\r\n" +
						"\r\n" +
						"\r\n" +
						"", 500, moveText+500);
				
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().fillText("Controls:",500, moveText+1500);
				
				canvas.getGraphicsContext2D().drawImage(controlsArrows, 500, moveText+1560);
				canvas.getGraphicsContext2D().drawImage(controlsSpace, 500, moveText+1740);
				canvas.getGraphicsContext2D().drawImage(controlsShift, 30, moveText+1840);
				
				canvas.getGraphicsContext2D().setFont(bitFontM);
				canvas.getGraphicsContext2D().fillText("Good luck and survive!",50, moveText+2100);
				
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().fillText("Press Enter",150, moveText+2240);
				
				if(moveText == -1061.75) {
					setScene = 0;
					count = 0;
					moveText = 50;
				}
				System.out.println(moveText);
			}else if(setScene == 5) {
				// Pausscreen
				
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack,0,0);
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("Pause", 635, 180);
				canvas.getGraphicsContext2D().setFont(bitFontS);
				canvas.getGraphicsContext2D().fillText("Continue", 635, 300);
				canvas.getGraphicsContext2D().fillText("Exit to Titlescreen", 635, 350);
				
			}else if(setScene == 6) {
				primaryStage.setTitle("SpaceHutter");
				mediaPlayerGameOver.stop();
				easteregg.play();
				
				moveText = moveText-0.38;
				canvas.getGraphicsContext2D().drawImage(whiteBackground, 0, 0);
				canvas.getGraphicsContext2D().setFont(bitFontB);
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().fillText("Welcome", 200, moveText+100);
				canvas.getGraphicsContext2D().fillText("to", 250, moveText+150);
				canvas.getGraphicsContext2D().fillText("Uwes Easteregg room", 100, moveText+200);
				canvas.getGraphicsContext2D().drawImage(Image2, 50, moveText+350);
				canvas.getGraphicsContext2D().drawImage(Image3, 50, moveText+550);
				canvas.getGraphicsContext2D().drawImage(Image4, 50, moveText+1400);
				canvas.getGraphicsContext2D().drawImage(Image5, -50, moveText+1600);
				
				canvas.getGraphicsContext2D().fillText("This game was presented by", 10, moveText+2000);
				canvas.getGraphicsContext2D().drawImage(Image6, 150, moveText+2000);
				
				System.out.println(moveText);
				if(moveText == -2134.2400000003076) {
					setScene = 2;
					moveText = 50;
					easteregg.stop();
					primaryStage.setTitle("SpaceShooter");
				}
			}

			}

		}.start();

	}

	public void handle(KeyEvent event) {
		int movement = s.getMovement();
		
		final URL sound28 = getClass().getResource("\\sound\\cursorSound.mp3");
		Media sound8 = new Media(sound28.toString());
		final MediaPlayer cursorSound = new MediaPlayer(sound8);
		
		// Debug:
		
		System.out.println(event.getCode().getName());

		if (event.isShiftDown()) {
			movement = movement * 2;
		}

		System.out.println(s.toString());
		// Controls:
		switch (event.getCode().getName()) {
		case "Up":
		if(setScene == 1) {	
			if(s.getY()<89) {
				break;
			}else {
			s.moveUp(movement);}
			
			}else if(setScene == 2) {
				if(cursorCorY == 970) {
					cursorCorY = 715;
					cursorSound.play();
				}else if(cursorCorY == 715) {
					cursorCorY = 670;
					cursorSound.play();
				}
			}else if(setScene == 3) {
			if(cursorCorY == 100) {
				cursorCorY = 50;
				cursorCorX = 430;
				cursorSound.play();
			}else if(cursorCorY == 200) {
				cursorCorY = 100;
				cursorCorX = 34;
				cursorSound.play();
			}else if(cursorCorY == 300) {
				cursorCorY = 200;
				cursorSound.play();
			}

				
			}
		break;
		case "Down":
			if(setScene == 1) {
			if(s.getY()>heigth -180) {
	  	 		 break;
			}else {
			s.moveDown (movement);}}
			else if(setScene == 2) {
				if(cursorCorY == 670) {
					cursorCorY = 715;
					cursorSound.play();
				}else if(cursorCorY == 715) {
					cursorCorY = 970;
					cursorSound.play();
				}
			}else if(setScene == 3) {
				if(cursorCorY == 50) {
					cursorCorY = 100;
					cursorCorX = 34;
					cursorSound.play();
				}else if(cursorCorY == 100) {
					cursorCorY = 200;
					cursorCorX = 34;
					cursorSound.play();
				}else if(cursorCorY == 200) {
					cursorCorY = 300;
					cursorSound.play();
				}
			}
			break; 
			

		case "Left":
			s.moveLeft(movement);
			break;

		case "Right":
			s.moveRight(movement);
			break;

		case "Space":
		if(setScene == 1) {	
			if(s.canFire() == true) {
			Rocket r = s.fire();
			rocket.add(r);
			System.out.println("Rocket Obejts:" + rocket.size());
			
			final URL sound29 = getClass().getResource("\\sound\\PewSound.mp3");
			Media sound = new Media(sound29.toString());
			final MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
			}
			}
			break;
			
		case "M":
			if(toogleMusic == false) {
				toogleMusic = true;
			}else {
				toogleMusic = false;
				
			}
			break;
			
		case "Enter":
				if(setScene == 2) {

					if (cursorCorY == 715) {
					setScene = 1;
					s.respawn();
					final URL sound30 = getClass().getResource("\\sound\\coinSound.mp3");
					Media sound3 = new Media(sound30.toString());
					final MediaPlayer mediaPlayerCoin = new MediaPlayer(sound3);
					mediaPlayerCoin.play();
					}else if(cursorCorY == 670) {
						setScene = 3;
						cursorCorY = 100;
						cursorCorX = 34;
					}else if(cursorCorY == 970){
						setScene = 0;
						count = 0;
					}
				}else if(setScene == 0 || setScene == 4){
					
					final URL sound30 = getClass().getResource("\\sound\\coinSound.mp3");
					Media sound3 = new Media(sound30.toString());
					final MediaPlayer mediaPlayerCoin = new MediaPlayer(sound3);
					mediaPlayerCoin.play();
					setScene = 1;
					count = 0;
				}else if(setScene == 3) {
					if(cursorCorY == 50) {
						setScene = 2;
						cursorCorY = 670;
						cursorCorX = 620;
					}else if(cursorCorY == 100 && shop.getHealthPrice() <= intscore)
					{
						intscore = intscore - shop.getHealthPrice();
						score="Points: "+intscore;
						shop.upgradeHealth(s);
					}else if(cursorCorY == 200 && shop.getShootingPrice() <= intscore) 
					{	intscore = intscore - shop.getShootingPrice();
						score="Points: "+intscore;
						shop.upgradeShooting(s);
						
					}else if(cursorCorY == 300 && shop.getSpeedPrice() <= intscore)
					{
						intscore = intscore - shop.getSpeedPrice();
						score="Points: "+intscore;
						shop.upgradeSpeed(s);
					}else{
						final URL sound31 = getClass().getResource("\\sound\\NoSound.mp3");
						Media sound3 = new Media(sound31.toString());
						final MediaPlayer NoSound = new MediaPlayer(sound3);
						NoSound.play();
					}
				}
			break;
		case "Esc":
			final URL sound32 = getClass().getResource("\\sound\\coinSound.mp3");
			Media sound3 = new Media(sound32.toString());
			final MediaPlayer mediaPlayerCoin = new MediaPlayer(sound3);
			
			if (setScene == 1) {
				setScene = 5;
				mediaPlayerCoin.play();
			}else if(setScene == 5) {
				setScene = 1;
				mediaPlayerCoin.play();
			}else if (setScene == 6) {
				setScene = 2;
			}
			break;
		case "F12":
			if (setScene == 2) {
				setScene = 6;
				moveText = 50;
			}
		}
	}

}
