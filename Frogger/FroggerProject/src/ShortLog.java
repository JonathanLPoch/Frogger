import javax.swing.*;

import java.awt.event.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.InputStream;
import java.io.IOException;

//http://zetcode.com/tutorials/javagamestutorial/movingsprites/

public class ShortLog extends Obstacle
{
	private BufferedImage shortLogImage;
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private int vel;
    public ShortLog(int x, int y, int v)
    {
    	InputStream input = getClass().getResourceAsStream("Log2.JPG");
    	try
    	{
    		this.shortLogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	
    	this.x = x;
    	this.y = y;
    	this.width = shortLogImage.getWidth();
    	this.height = shortLogImage.getHeight();
    	this.velocity = v;
    	vel=v;
    }
    
    public Rectangle getBounds() 
    {
		return new Rectangle(x, y, width, height);
	}
    
    public void move()
    {
    	x += velocity;
    	if(x>900)
    		x = -1*width;
    	if(x<-1*width)
    		x = 900;
    }
    
    public BufferedImage getImage()
    {
    	return shortLogImage;
    }
    
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }    
    
    public int getWidth()
    {
    	return width;
    }
    public int getHeight()
    {
    	return height;
    }
    
    public int getVelocity()
    {
    	return velocity;
    }
    public void changeVelocity()
    {
    	if(velocity>0)
    	{
    		velocity++;
    		vel++;
    	}
    	if(velocity<0)
    	{
    		velocity--;
    		vel--;
    	}
    }
    public void addRandomStop()
    {
    	int r = (int)(Math.random()*5);
    	if(r==0)
    		velocity=0;
    	if(r>0)
    		velocity = vel;
    }
    public void setX(int x)
    {
    	this.x = x;
    }
    
    public void setY(int y)
    {
    	this.y = y;
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
    	InputStream input = getClass().getResourceAsStream("Log2Alt.png");
    	
    	try
    	{
    		this.shortLogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    
    public void changeBack()
    {
    	InputStream input = getClass().getResourceAsStream("Log2.jpg");
    	
    	try
    	{
    		this.shortLogImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    }
}
    