import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public abstract class Obstacle 
{
	public static int x;
	public static int y;
	public abstract Rectangle getBounds();
    
    public void move()
    {
    	x+=2;
    	y+=3;
    }
    
    public abstract BufferedImage getImage();
    
    public abstract int getX();
    
    public abstract int getY();    
    
    public abstract int getWidth();

    public abstract int getHeight();
    
    public abstract int getVelocity();
    
    public void setX(int xPos)
    {
    	x = xPos;
    }
    
    public void setY(int yPos)
    {
    	y = yPos;
    }
}
