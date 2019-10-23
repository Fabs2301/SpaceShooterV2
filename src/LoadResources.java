import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class LoadResources 
{
	//Image
	Image i_wasdControll = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\wasdControll.png"));
	Image i_Arrow = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Arrow.png"));
	Image i_asteroid = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroid.png"));
	Image i_asteroiddamaged = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\asteroiddamaged.png"));
	//Image i_background_test = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\background_test.jpg"));
	Image i_black = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\black.png"));
	Image i_controlsArrows = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsArrows.png"));
	Image i_controlsShift = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsShift.png"));
	Image i_controlsSpace = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\controlsSpace.png"));
	//Image i_translucentBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\translucentBackground.png"));
	Image i_White = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\White.png"));
	Image i_gameOver = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\gameOver.gif"));
	Image i_giphy = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\giphy.gif"));
	Image i_GuiBackground = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\GUIBackground.png"));
	Image i_rocket = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\rocket.png"));
	Image i_title = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\title.png"));
	Image i_updateBox = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\updateBox.png"));
	Image i_upgradeBlock = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\upgradeBlock.png"));
	Image i_Image1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image1.png"));
	Image i_Image2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image2.png"));
	Image i_Image3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image3.png"));
	Image i_Image4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image4.jpg"));
	Image i_Image5 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image5.png"));
	Image i_Image6 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\Image6.png"));
	Image i_spaceship = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\spaceship.png"));
	Image i_damagedSpaceship1 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship1.png"));
	Image i_damagedSpaceship2 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship2.png"));
	Image i_damagedSpaceship3 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedSpaceship3.png"));
	Image i_damagedSpaceship4 = new Image(Starter.class.getClassLoader().getResourceAsStream("\\image\\damagedShip4.gif"));
		//font
	Font f_bitFontB = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 40);
	Font f_bitFontM = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 25);
	Font f_bitFontS = Font.loadFont(getClass().getResourceAsStream("\\font\\bitFond.ttf"), 20);
	
	//sound
	final URL sound1 = getClass().getResource("\\sound\\coinSound.mp3");
	Media soundl1 = new Media(sound1.toString());
	public final MediaPlayer s_coinSound = new MediaPlayer(soundl1);
	
	final URL sound2 = getClass().getResource("\\sound\\cursorSound.mp3");
	Media soundl2 = new Media(sound1.toString());
	public final MediaPlayer s_cursorSound = new MediaPlayer(soundl2);
	
	final URL sound3 = getClass().getResource("\\sound\\easteregg.mp3");
	Media soundl3 = new Media(sound1.toString());
	public final MediaPlayer s_easteregg = new MediaPlayer(soundl3);
	
	final URL sound4 = getClass().getResource("\\sound\\explosion.wav");
	Media soundl4 = new Media(sound1.toString());
	public final MediaPlayer s_explosion = new MediaPlayer(soundl4);
	
	final URL sound5 = getClass().getResource("\\sound\\GameOver.mp3");
	Media soundl5 = new Media(sound1.toString());
	public final MediaPlayer s_GameOver = new MediaPlayer(soundl5);
	
	final URL sound6 = getClass().getResource("\\sound\\inGameMusic.mp3");
	Media soundl6 = new Media(sound1.toString());
	public final MediaPlayer s_inGameMusic = new MediaPlayer(soundl6);
	
	final URL sound7 = getClass().getResource("\\sound\\NoSound.mp3");
	Media soundl7 = new Media(sound1.toString());
	public final MediaPlayer s_NoSound = new MediaPlayer(soundl7);
	
	final URL sound8 = getClass().getResource("\\sound\\PewSound.mp3");
	Media soundl8 = new Media(sound1.toString());
	public final MediaPlayer s_PewSound = new MediaPlayer(soundl8);
	
	final URL sound9 = getClass().getResource("\\sound\\titleTheme.mp3");
	Media soundl9 = new Media(sound1.toString());
	public final MediaPlayer s_titleTheme = new MediaPlayer(soundl9);
	
	final URL sound10 = getClass().getResource("\\sound\\upgradeSound.mp3");
	Media soundl10 = new Media(sound1.toString());
	public final MediaPlayer s_upgradeSound = new MediaPlayer(soundl10);
	public Image getI_Arrow() {
		return i_Arrow;
	}
	public Image getI_asteroid() {
		return i_asteroid;
	}
	public Image getI_asteroiddamaged() {
		return i_asteroiddamaged;
	}
	/**
	public Image getI_background_test() {
		return i_background_test;
	}
	**/
	public Image getI_black() {
		return i_black;
	}
	public Image getI_controlsArrows() {
		return i_controlsArrows;
	}
	public Image getI_controlsShift() {
		return i_controlsShift;
	}
	public Image getI_controlsSpace() {
		return i_controlsSpace;
	}
	/**
	public Image getI_translucentBackground() {
		return i_translucentBackground;
	}
	**/
	public Image getI_White() {
		return i_White;
	}
	public Image getI_gameOver() {
		return i_gameOver;
	}
	public Image getI_giphy() {
		return i_giphy;
	}
	public Image getI_GuiBackground() {
		return i_GuiBackground;
	}
	public Image getI_rocket() {
		return i_rocket;
	}
	public Image getI_title() {
		return i_title;
	}
	public Image getI_updateBox() {
		return i_updateBox;
	}
	public Image getI_upgradeBlock() {
		return i_upgradeBlock;
	}
	public Image getI_Image1() {
		return i_Image1;
	}
	public Image getI_Image2() {
		return i_Image2;
	}
	public Image getI_Image3() {
		return i_Image3;
	}
	public Image getI_Image4() {
		return i_Image4;
	}
	public Image getI_Image5() {
		return i_Image5;
	}
	public Image getI_Image6() {
		return i_Image6;
	}
	public Image getI_spaceship() {
		return i_spaceship;
	}
	public Image getI_damagedSpaceship1() {
		return i_damagedSpaceship1;
	}
	public Image getI_damagedSpaceship2() {
		return i_damagedSpaceship2;
	}
	public Image getI_damagedSpaceship3() {
		return i_damagedSpaceship3;
	}
	public Image getI_damagedSpaceship4() {
		return i_damagedSpaceship4;
	}
	
	public Image getI_wasdControll() {
		return i_wasdControll;
	}
	public Font getF_BitFontB() {
		return f_bitFontB;
	}
	public Font getF_BitFontM() {
		return f_bitFontM;
	}
	public Font getF_BitFontS() {
		return f_bitFontS;
	}
	public MediaPlayer getS_coinSound() {
		return s_coinSound;
	}
	public MediaPlayer getS_cursorSound() {
		return s_cursorSound;
	}
	public MediaPlayer getS_easteregg() {
		return s_easteregg;
	}
	public MediaPlayer getS_explosion() {
		return s_explosion;
	}
	public MediaPlayer getS_GameOver() {
		return s_GameOver;
	}
	public MediaPlayer getS_inGameMusic() {
		return s_inGameMusic;
	}
	public MediaPlayer getS_NoSound() {
		return s_NoSound;
	}
	public MediaPlayer getS_PewSound() {
		return s_PewSound;
	}
	public MediaPlayer getS_titleTheme() {
		return s_titleTheme;
	}
	public MediaPlayer getS_upgradeSound() {
		return s_upgradeSound;
	}
}
