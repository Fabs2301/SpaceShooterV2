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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Starter extends Application implements EventHandler<KeyEvent> {

	int width = 1920;
	int heigth = 1080;
	
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	boolean shift = false;
	boolean space = false;
	final static int FPS = 60;
	public static int SPRITE_MOVE_INTERVALL = (int)((1.0 / FPS) * 1000.0);
	
	SpaceShip s = new SpaceShip(500, 500);
	Shop shop = new Shop(0,0,0);
	Powerups powerups = new Powerups();
	LoadResources lr = new LoadResources();
	
	List<Asteroid> asteroiden = new ArrayList<Asteroid>();
	List<Rocket> rocket = new ArrayList<Rocket>();
	
	boolean toogleMusic = true;
	public int intscore = 0;
	String score = "Points:"+intscore;
	String music = "Music: off (M)";
	int setScene = 0;	//sets the scene in the game 0 = title screen, 1 = game screen, 2 = game over screen, 3 = shop screen, 4 = storyscreen, 5 = PauseScreen, 6 = EasterEgg Screen
	boolean switchSceneToGameOver = false;
	long count = 0;
	long deathCount;
	int cursorCorY = 670;
	int cursorCorX = 620;
	double moveText = 50;
	int asteroidCount = 16;
	int asteroidMaxSpeed = 4;
	int asteroidMinSpeed = 1;
	long survivalTime = 0;
	boolean powerupMoved = false;
	
	final URL sound27 = getClass().getResource("\\sound\\explosion.wav");
	Media sound6 = new Media(sound27.toString());
	final MediaPlayer mediaPlayerExplosion = new MediaPlayer(sound6);
	

	public static void main (String args[]) {
		Application.launch();
	}
	
	public void start(final Stage primaryStage) throws Exception {

		primaryStage.setTitle("SpaceShooter");
		primaryStage.getIcons().add(lr.getI_title());
		final Image backgroundimageBlack = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\black.png"));
		Group root = new Group();
		final Canvas canvas = new Canvas(1920, 1080);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);
		Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.setFullScreen(true);

		
		// Create Asteroiden
		for (int i = 0; i < heigth * width / 96000; i++) {

			Asteroid a = new Asteroid(0, 0, 0);
			a.reposition(width / 2, heigth, asteroidMaxSpeed, asteroidMinSpeed);
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
				
				 survivalTime++;
				 
				 if(survivalTime%2400 == 0)
				 {
					 asteroidMinSpeed++;
					 asteroidMaxSpeed++;
					 asteroidCount += 4;
				 }
				 
				//Powerups
				 if(powerupMoved == false)
				 {
					powerupMoved = powerups.spawnPowerup();
					powerups.paint(canvas.getGraphicsContext2D());
				 }
				 
				if(setScene == 1) {	
				mediaPlayerGameOver.stop();
				titleTheme.stop();
				s.currentHealth = s.getMaxHealth();
 				// Key handler bools:
				
				int movement = s.getMovement(); 
				
				if(shift) {
					movement=movement*2;
				}
				if(right)
				{
					if(s.getX()<1770)
					{
						s.move(Direction.right, movement, SPRITE_MOVE_INTERVALL);
					}
				}
				if(left)
				{
					if(s.getX()>0)
					{
						s.move(Direction.left, movement, SPRITE_MOVE_INTERVALL);
					}
				}
				if(up)
				{
					if(s.getY()<89){}else {s.move(Direction.up, movement, SPRITE_MOVE_INTERVALL);}
					
				}
				if(down)
				{
					if(s.getY()>heigth -160) {}else {s.move(Direction.down, movement, SPRITE_MOVE_INTERVALL);}
						
				}if(space) {
					if(s.canFire() == true) {
					Rocket r = s.fire();
					/**
					final URL sound29 = getClass().getResource("\\sound\\PewSound.mp3");
					Media sound = new Media(sound29.toString());
					final MediaPlayer mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.play();
					**/
					
					rocket.add(r);
					//System.out.println("Rocket Obejts:" + rocket.size());
					}
				}
				
				
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
				canvas.getGraphicsContext2D().drawImage(lr.getI_giphy(), 0, 0);
				canvas.getGraphicsContext2D().drawImage(lr.getI_GuiBackground(), 0, 0);
				
				//GUI Upadate:
				
				if(s.currentHealth >0) {
					 s.currentHealth = s.getMaxHealth() -s.getDamageCount();
				}
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontM());
				canvas.getGraphicsContext2D().setFill(Color.WHITE);;
				canvas.getGraphicsContext2D().fillText(score, 1600, 45);
				canvas.getGraphicsContext2D().fillText("Health:"+ s.currentHealth+"/"+s.getMaxHealth(), 20, 45);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontS());
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
						a.reposition(width, heigth, asteroidMaxSpeed, asteroidMinSpeed);
						asteroiden.add(a);
						//System.out.println("Asteroiden Objects:" + asteroiden.size());
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
					
					if(s.getBounds().intersects(powerups.getBounds()))
					{
						powerups.takePowerupsOutBounds();
						intscore = powerups.usePowerUp(s, intscore);
						score = "Points:"+intscore;
						powerupMoved = false;
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
					
					
					mediaPlayerExplosion.stop();
					mediaPlayerExplosion.play();
						}
						switchSceneToGameOver = true;
						

						}

					if(switchSceneToGameOver == true  && count >= deathCount+2200) {
						setScene = 2;
					}
					count ++;
				}
				//Powerupspawning
				
				powerups.paint(canvas.getGraphicsContext2D());	
				
				
			}else if(setScene == 2) {
				//Game Over Screen
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack, 0, 0);
				canvas.getGraphicsContext2D().drawImage(lr.getI_gameOver(), 625, 100);
				inGameMusic.stop();
				easteregg.stop();
				mediaPlayerGameOver.play();
				
				 
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().setFill(Color.WHITE);;
				canvas.getGraphicsContext2D().fillText("Your Points: "+intscore, 625, 585);
			
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontM());
				canvas.getGraphicsContext2D().fillText("Upgrade Space Ship", 700, 700);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Arrow(), cursorCorX, cursorCorY);
				canvas.getGraphicsContext2D().fillText("Continue", 700, 750);
				canvas.getGraphicsContext2D().fillText("Exit to Titlescreen", 700, 1000);
				
				switchSceneToGameOver = false;
				s.setDead(false);
				s.currentHealth = s.getMaxHealth();
			}else if (setScene == 0) {
				//Title screen:
				titleTheme.play();
				canvas.getGraphicsContext2D().drawImage(lr.getI_giphy(), 0, 0);
				canvas.getGraphicsContext2D().drawImage(lr.getI_title(), 460, 150);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("Press Enter", 750, 800);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontS());
				canvas.getGraphicsContext2D().fillText("© 2019 Fabian Gruber & Marcel Winkler		    	ver 2.0", 600, 1020);
				count ++;
				//2130
				if(count >= 2130) {
					setScene = 4;
				}
				//System.out.println(count+" frames / 2130 frames");
				
				//Ingame music loop (2:48 min) 
				Double musicTimer = titleTheme.getCurrentTime().toSeconds();
				//System.out.println(musicTimer);
				if(musicTimer > 140.0) {
					titleTheme.stop();
					titleTheme.play();
					setScene = 0;
					count = 0;
				}
				
			}else if(setScene == 3) {
				
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack, 0, 0);
				canvas.getGraphicsContext2D().drawImage(lr.getI_GuiBackground(), 0, 0);
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("SHOP", 885, 60);
				
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
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontM());
				canvas.getGraphicsContext2D().fillText("Points: "+intscore, 5, 120);
				canvas.getGraphicsContext2D().fillText("Back", 1800, 120);
				canvas.getGraphicsContext2D().fillText("Health", 200, 200);
				canvas.getGraphicsContext2D().fillText("Shooting Speed", 200, 500);
				canvas.getGraphicsContext2D().fillText("Movement Speed", 200, 800);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().fillText(healthPrice,1680, 310);
				canvas.getGraphicsContext2D().fillText(shootingPrice,1680, 610);
				canvas.getGraphicsContext2D().fillText(speedPrice,1680, 910);
				
				

			

				
				if (shop.getHealthUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 236, 226);
				} if (shop.getHealthUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 585, 226);
				} if (shop.getHealthUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 940, 226);
				} if (shop.getHealthUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 1288, 226);
				}
				
				if (shop.getShootingUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 236, 526);
				} if (shop.getShootingUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 585, 526);
				} if (shop.getShootingUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 940, 526);
				} if (shop.getShootingUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 1288, 526);
				}
				
				if (shop.getSpeedUpgradeLevel() >= 1) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 236, 826);
				} if (shop.getSpeedUpgradeLevel() >= 2) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 585, 826);
				} if (shop.getSpeedUpgradeLevel() >= 3) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 940, 826);
				} if (shop.getSpeedUpgradeLevel() >= 4) {
					canvas.getGraphicsContext2D().drawImage(lr.getI_upgradeBlock(), 1288, 826);
				}
				
				canvas.getGraphicsContext2D().drawImage(lr.getI_updateBox(), 200, 210);
				canvas.getGraphicsContext2D().drawImage(lr.getI_updateBox(), 200, 510);
				canvas.getGraphicsContext2D().drawImage(lr.getI_updateBox(), 200, 810);
				
				canvas.getGraphicsContext2D().drawImage(lr.getI_Arrow(), cursorCorX, cursorCorY);
				
			}else if(setScene == 4) {
				moveText = moveText-0.40; // 0,40
				canvas.getGraphicsContext2D().drawImage(lr.getI_giphy(), 0, 0);
				canvas.getGraphicsContext2D().drawImage(lr.getI_title(), 460, moveText+99.75);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontS());
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
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().fillText("Controls:",500, moveText+1250);
				
				canvas.getGraphicsContext2D().drawImage(lr.getI_controlsArrows(), 500, moveText+1400);
				canvas.getGraphicsContext2D().drawImage(lr.getI_wasdControll(), 1000, moveText+1360);
				canvas.getGraphicsContext2D().drawImage(lr.getI_controlsSpace(), 500, moveText+1740);
				canvas.getGraphicsContext2D().drawImage(lr.getI_controlsShift(), 378, moveText+1940);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontM());
				canvas.getGraphicsContext2D().fillText("Good luck and survive!",700, moveText+2400);
				
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().fillText("Press Enter",740, moveText+2500);
				
				if(moveText < -2290.0) {
					setScene = 0;
					count = 0;
					moveText = 50;
				}
				//System.out.println(moveText);
			}else if(setScene == 5) {
				// Pausscreen
				
				canvas.getGraphicsContext2D().drawImage(backgroundimageBlack,0,0);
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().setFill(Color.WHITE);
				canvas.getGraphicsContext2D().fillText("Pause", 635, 180);
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontS());
				canvas.getGraphicsContext2D().fillText("Continue", 635, 300);
				canvas.getGraphicsContext2D().fillText("Exit to Titlescreen", 635, 350);
				
			}else if(setScene == 6) {
				primaryStage.setTitle("SpaceHutter");
				easteregg.play();
				
				moveText = moveText-0.8;   //-0.38
				canvas.getGraphicsContext2D().drawImage(lr.getI_White(), 0, 0);
				canvas.getGraphicsContext2D().setFont(lr.getF_BitFontB());
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().fillText("Welcome", 840, moveText+170);
				canvas.getGraphicsContext2D().fillText("to", 930, moveText+220);
				canvas.getGraphicsContext2D().fillText("Uwes Easteregg room", 600, moveText+270);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Image2(), 700, moveText+450);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Image3(), 500, moveText+850);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Image4(), 700, moveText+2900);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Image5(), 350, moveText+3500);
				
				canvas.getGraphicsContext2D().fillText("This game was presented by", 450, moveText+4500);
				canvas.getGraphicsContext2D().drawImage(lr.getI_Image6(), 700, moveText+4500);
				
				//System.out.println(moveText);
				if(moveText < -4456.0) {
					setScene = 2;
					moveText = 50;
					easteregg.stop();
					primaryStage.setTitle("SpaceShooter");
				}
			}

			}

		}.start();

	
	sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
				right = true;
			} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
				left = true;
			} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
				down = true;
			} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
				up = true;
			} else if (event.getCode() == KeyCode.SHIFT) {
				shift = true;
			} else if (event.getCode() == KeyCode.SPACE) {
				space = true;
			}
			
		}
	});

	sc.setOnKeyReleased(new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
				right = false;
			} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
				left = false;
			} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
				down = false;
			} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
				up = false;
			} else if (event.getCode() == KeyCode.SHIFT) {
				shift = false;
			} else if (event.getCode() == KeyCode.SPACE) {
				space = false;
			}
		}
	});
	
}

	public void handle(KeyEvent event) {
		
		
		final URL sound28 = getClass().getResource("\\sound\\cursorSound.mp3");
		Media sound8 = new Media(sound28.toString());
		final MediaPlayer cursorSound = new MediaPlayer(sound8);
		
		// Debug:
		
		System.out.println(event.getCode().getName());


		//System.out.println(s.toString());
		// Controls:
		switch (event.getCode().getName()) {
		case "Up":
		if(setScene == 1) {	
			/**if(s.getY()<89) {
				break;
			}else {
			s.moveUp(movement);}**/
			
			}else if(setScene == 2) {
				if(cursorCorY == 970) {
					cursorCorY = 715;
					cursorSound.play();
				}else if(cursorCorY == 715) {
					cursorCorY = 670;
					cursorSound.play();
				}
			}else if(setScene == 3) {
			if(cursorCorY == 170) {
				cursorCorY = 90;
				cursorCorX = 1730;
				cursorSound.play();
			}else if(cursorCorY == 470) {
				cursorCorY = 170;
				cursorCorX = 125;
				cursorSound.play();
			}else if(cursorCorY == 770) {
				cursorCorY = 470;
				cursorSound.play();
			}

				
			}
		break;
		case "Down":
			if(setScene == 1) {}
			else if(setScene == 2) {
				if(cursorCorY == 670) {
					cursorCorY = 715;
					cursorSound.play();
				}else if(cursorCorY == 715) {
					cursorCorY = 970;
					cursorSound.play();
				}
			}else if(setScene == 3) {
				if(cursorCorY == 90) {
					cursorCorY = 170;
					cursorCorX = 125;
					cursorSound.play();
				}else if(cursorCorY == 170) {
					cursorCorY = 470;
					cursorCorX = 125;
					cursorSound.play();
				}else if(cursorCorY == 470) {
					cursorCorY = 770;
					cursorSound.play();
				}
			}
			break; 
			

		/**case "Left":
			s.moveLeft(movement);
			break;

		case "Right":
			s.moveRight(movement);
			break;

		case "Space":
		if(setScene == 1) {	
			if(s.canFire() == true) {}
			}
			break;
			**/
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
					asteroidCount = 16;
					asteroidMaxSpeed = 4;
					asteroidMinSpeed = 1;
					survivalTime = 0;
					
					
					final URL sound30 = getClass().getResource("\\sound\\coinSound.mp3");
					Media sound3 = new Media(sound30.toString());
					final MediaPlayer mediaPlayerCoin = new MediaPlayer(sound3);
					
					mediaPlayerCoin.play();
					}else if(cursorCorY == 670) {
						setScene = 3;
						cursorCorY = 170;
						cursorCorX = 134;
					}else if(cursorCorY == 970){
						setScene = 0;
						count = 0;
						s.respawn();
					}
				}else if(setScene == 0 || setScene == 4){
					
					final URL sound30 = getClass().getResource("\\sound\\coinSound.mp3");
					Media sound3 = new Media(sound30.toString());
					final MediaPlayer mediaPlayerCoin = new MediaPlayer(sound3);
					
					mediaPlayerCoin.play();
					setScene = 1;
					count = 0;
					
				}else if(setScene == 3) {
					if(cursorCorY == 90) {
						setScene = 2;
						cursorCorY = 670;
						cursorCorX = 620;
					}else if(cursorCorY == 170 && shop.getHealthPrice() <= intscore)
					{
						intscore = intscore - shop.getHealthPrice();
						score="Points: "+intscore;
						shop.upgradeHealth(s);
					}else if(cursorCorY == 470 && shop.getShootingPrice() <= intscore) 
					{	intscore = intscore - shop.getShootingPrice();
						score="Points: "+intscore;
						shop.upgradeShooting(s);
						
					}else if(cursorCorY == 770 && shop.getSpeedPrice() <= intscore)
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
		case "Backspace":
			
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
		case "Home":
			if (setScene == 2) {
				/**setScene = 6;
				moveText = 50;**/
			}
		}
	}
}
