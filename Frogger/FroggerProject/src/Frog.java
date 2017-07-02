import java.awt.event.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;


public class Frog 
{
	private BufferedImage frogImage;
    private int x;
    private int y;
    private Integer dx; //delta x (the change in x)
    private Integer dy; //delta y (the change in y)
    private int width;
    private int height;
    private int velocity; //velocity is the amount by which x and y will change
    private boolean onObstacle;
    //private AudioStream audioStream;
    public Frog(int x, int y, int v)
    {
    	InputStream input = getClass().getResourceAsStream("froggy.png");
    	
    	try
    	{
    		this.frogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	
    	this.x = x;
    	this.y = y;
    	this.width = frogImage.getWidth();
    	this.height = frogImage.getHeight();
    	this.velocity = v;
    	this.dx = 0;
    	this.dy = 0;
    }
    
    public void move(int obstacleVelocity) //increments x and y by the velocity is a key is pressed
    {
    	 // open the sound file as a Java input stream
      /*  String gongFile = "/Users/al/DevDaily/Projects/MeditationApp/resources/gong.au";
        InputStream in;
		try {
			in = new FileInputStream(gongFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // create an audiostream from the inputstream

		try {
			audioStream = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
*/
    	if(onObstacle)
    		x += obstacleVelocity;//if on a log or turtle, follow it
    	if(dx != 0)
    		x += dx;
    	else if(dy != 0)
    		y += dy;
    	
    	//checking collisions with the edges of the screen
    	//adds 4 to width and 32 to height to account for discrepancies in GUI
    	if(x < 0)
    		x = 0;
    	if(y < 0)
    		y = 0;
    	if(x + width + 4 > FroggerRunner.BOARD_WIDTH) 
    		x = FroggerRunner.BOARD_WIDTH - this.width - 4;
    	if(y + height + 32 > FroggerRunner.BOARD_HEIGHT)
    		y = FroggerRunner.BOARD_HEIGHT - this.height - 32;	
    }
    
    public Rectangle getBounds() 
    {
		return new Rectangle(x, y, width, height);
	}

    public void keyPressed(KeyEvent e)
    {
    	int key = e.getKeyCode();
    	
    	if(key == KeyEvent.VK_LEFT)
    		dx = -1 * velocity/2;
    	if(key == KeyEvent.VK_RIGHT)
    		dx = velocity/2;
    	if(key == KeyEvent.VK_UP)
    	{
    		dy = -1 * velocity/2;
    		FroggerGame.setScore(FroggerGame.getScore()+10);//increases score when moving up
    	}
    	if(key == KeyEvent.VK_DOWN)
    		dy = velocity/2;
    }
    
    public void keyReleased(KeyEvent e) 
    {
    	int key = e.getKeyCode();
    	
    	if(key == KeyEvent.VK_LEFT)
    		dx = 0;
    	if(key == KeyEvent.VK_RIGHT)
    		dx = 0;
    	if(key == KeyEvent.VK_UP)
    		dy = 0;
    	if(key == KeyEvent.VK_DOWN)
    		dy = 0;
    }
    
    public BufferedImage getImage()//returns image for drawing
    {
    	InputStream input = getClass().getResourceAsStream("froggy.png");
    	
    	try
    	{
    		this.frogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	return frogImage;    }
    public BufferedImage getAltImage()//returns image for drawing
    {
    	InputStream input = getClass().getResourceAsStream("froggyAlt.png");
    	
    	try
    	{
    		this.frogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	return frogImage;
    }
    
    public int getX()//returns x value
    {
    	return x;
    }
    
    public int getY()//returns y value
    {
    	return y;
    }
    
    public int getVelocity()//returns velocity
    {
    	return velocity;
    }
    
    public int getWidth()//returns width
    {
    	return width;
    }
    
    public void setImage(BufferedImage fi)//sets image
    {
    	this.frogImage = fi;
    }
    
    public void setX(int x)//sets x position
    {
    	this.x = x;
    }
    
    public void setY(int y)//sets y position
    {
    	this.y = y;
    }
    
    public void setVelocity(int v)//sets velocity
    {
    	this.velocity = v;
    }
    
    public void setObstacleStatus(boolean s)//is it colliding with something?
    {
    	onObstacle = s;
    }
    public void change(int level)
    {
    	if(level%2==0)
    		changeToAlt();
    	if(level%2==1)
    		changeBack();
    }
    public void changeToAlt()
    {
    	InputStream input = getClass().getResourceAsStream("froggyAlt.png");
    	
    	try
    	{
    		this.frogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    
    public void changeBack()
    {
    	InputStream input = getClass().getResourceAsStream("froggy.png");
    	
    	try
    	{
    		this.frogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    }
}

    
//FroggerGame.setScore(FroggerGame.getScore()+10);
