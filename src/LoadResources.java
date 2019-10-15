import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class LoadResources 
{
	//Images
	public Image i_Arrow = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Arrow.png"));
	public Image i_asteroid = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroid.png"));
	public Image i_asteroiddamaged = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroiddamaged.png"));
	public Image i_background_test = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\background_test.jpg"));
	public Image i_black = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\black.png"));
	public Image i_controlsArrows = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsArrows.png"));
	public Image i_controlsShift = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsShift.png"));
	public Image i_controlsSpace = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsSpace.png"));
	public Image i_translucentBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\translucentBackground.png"));
	public Image i_White = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\White.png"));
	public Image i_gameOver = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\gameOver.gif"));
	public Image i_giphy = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\giphy.gif"));
	public Image i_GuiBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\GUIBackground.png"));
	public Image i_rocket = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\rocket.png"));
	public Image i_title = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\title.png"));
	public Image i_updateBox = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\updateBox.png"));
	public Image i_upgradeBlock = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\upgradeBlock.png"));
	public Image i_Image1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image1.png"));
	public Image i_Image2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image2.png"));
	public Image i_Image3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image3.png"));
	public Image i_Image4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image4.jpg"));
	public Image i_Image5 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image5.png"));
	public Image i_Image6 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image6.png"));
	public Image i_spaceship = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
	public Image i_damagedSpaceship1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship1.png"));
	public Image i_damagedSpaceship2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship2.png"));
	public Image i_damagedSpaceship3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship3.png"));
	public Image i_damagedSpaceship4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedShip4.gif"));
	
	//font
	public Font bitFontB = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 40);
	public Font bitFontM = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 25);
	public Font bitFontS = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 20);
	
	//sound
	final URL sound1 = getClass().getResource("\\sound\\coinSound.mp3");
	Media soundl1 = new Media(sound1.toString());
	final MediaPlayer s_coinSound = new MediaPlayer(soundl1);
	
	final URL sound2 = getClass().getResource("\\sound\\cursorSound.mp3");
	Media soundl2 = new Media(sound1.toString());
	final MediaPlayer s_cursorSound = new MediaPlayer(soundl2);
	
	final URL sound3 = getClass().getResource("\\sound\\easteregg.mp3");
	Media soundl3 = new Media(sound1.toString());
	final MediaPlayer s_easteregg = new MediaPlayer(soundl3);
	
	final URL sound4 = getClass().getResource("\\sound\\explosion.wav");
	Media soundl4 = new Media(sound1.toString());
	final MediaPlayer s_explosion = new MediaPlayer(soundl4);
	
	final URL sound5 = getClass().getResource("\\sound\\GameOver.mp3");
	Media soundl5 = new Media(sound1.toString());
	final MediaPlayer s_GameOver = new MediaPlayer(soundl5);
	
	final URL sound6 = getClass().getResource("\\sound\\inGameMusic.mp3");
	Media soundl6 = new Media(sound1.toString());
	final MediaPlayer s_inGameMusic = new MediaPlayer(soundl6);
	
	final URL sound7 = getClass().getResource("\\sound\\NoSound.mp3");
	Media soundl7 = new Media(sound1.toString());
	final MediaPlayer s_NoSound = new MediaPlayer(soundl7);
	
	final URL sound8 = getClass().getResource("\\sound\\PewSound.mp3");
	Media soundl8 = new Media(sound1.toString());
	final MediaPlayer s_PewSound = new MediaPlayer(soundl8);
	
	final URL sound9 = getClass().getResource("\\sound\\titleTheme.mp3");
	Media soundl9 = new Media(sound1.toString());
	final MediaPlayer s_titleTheme = new MediaPlayer(soundl9);
	
	final URL sound10 = getClass().getResource("\\sound\\upgradeSound.mp3");
	Media soundl10 = new Media(sound1.toString());
	final MediaPlayer s_upgradeSound = new MediaPlayer(soundl10);
}
