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

public class Truck extends Obstacle implements Vehicle
{
	private BufferedImage truckImage;
    private int x;
    private int y;
    private int k;
    private int width;
    private int height;
    private int velocity;
    public  int top;
    public  int bot;
    public  int left;
    public  int right;
    private int vel;
    public Truck(int x, int y, int v, int k)
    {
    	InputStream input = getClass().getResourceAsStream("Truck.jpg");

    	try
    	{
    		this.truckImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	this.x = x;
    	this.y = y;
    	this.k = k;
    	top = y;
    	bot = y + 20;
    	left = x;
    	right = x + 20;
    	this.width = truckImage.getWidth();
    	this.height = truckImage.getHeight();
    	this.velocity = v;
    	vel=v;
    }
    
    public Rectangle getBounds() 
    {
		return new Rectangle(x, y, width, height);
	}
    
    public void move()
    {
    	
    	x += 0.5*velocity;
    	left = x;
    	right = x + 20;
    	if(x<0)
    	{
    		if(k == 1)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 2)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 3)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 4)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 5)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 6)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 7)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 8)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 9)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 10)
    			x = 900+ (int)(Math.random()*700);
    		if(k == 11)
    			x = 900+ (int)(Math.random()*700);
    	}
    }
    public  boolean collision(int x, int y)
    {
    	return x > left && x < right && y < bot && y > top;//(x > left && x<right &&y<top && y>bot);
    }
    public BufferedImage getImage()
    {
    	return truckImage;
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
    		velocity+=2;
    		vel+=2;
    	}
    	if(velocity<0)
    	{
    		velocity-=2;
    		vel-=2;
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
    	InputStream input = getClass().getResourceAsStream("TruckAlt.png");
    	
    	try
    	{
    		this.truckImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    
    public void changeBack()
    {
    	InputStream input = getClass().getResourceAsStream("Truck.jpg");
    	
    	try
    	{
    		this.truckImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    }
    }