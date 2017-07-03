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

public class Lillipad extends Obstacle
{
	private BufferedImage lillipadImage;
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    private boolean filled;
    public Lillipad(int x, int y, int v)
    {
    	InputStream input = getClass().getResourceAsStream("lillipad.png");
    	try
    	{
    		this.lillipadImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	
    	this.x = x;
    	this.y = y;
    	this.width = lillipadImage.getWidth();
    	this.height = lillipadImage.getHeight();
    	this.velocity = v;
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
    	return lillipadImage;
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
    
    public void setX(int x)
    {
    	this.x = x;
    }
    
    public void setY(int y)
    {
    	this.y = y;
    }
    public void changeToHaveFrog()
    {
    	filled = true;
    	
    	InputStream input = getClass().getResourceAsStream("lillipadwithfrog.png");
    	
    	try
    	{
    		this.lillipadImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    public void changeToHaveFrogAlt()
    {
    	filled = true;
    	
    	InputStream input = getClass().getResourceAsStream("lillipadwithfrogAlt.png");
    	
    	try
    	{
    		this.lillipadImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    public void changeToBeEmpty()
    {
    	InputStream input = getClass().getResourceAsStream("lillipad.png");
    	
    	try
    	{
    		this.lillipadImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	
    	filled = false;
    }
    
    public boolean checkIfFull()
    {
    	return filled;
    }
}
    