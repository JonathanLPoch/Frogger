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

public class Car extends Obstacle implements Vehicle
{
	private BufferedImage carImage;
    private int x;
    private int y;
    private int k;
    private int width;
    private int height;
    private int velocity;
    private int vel;
    public  int top;
    public  int bot;
    public  int left;
    public  int right;
    public Car(int x, int y, int v, int k)
    {
    	InputStream input = getClass().getResourceAsStream("car.GIF");

    	try
    	{
    		this.carImage = ImageIO.read(input);
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
    	this.width = carImage.getWidth();
    	this.height = carImage.getHeight();
    	this.velocity = v;
    	vel = v;
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
    	if(x>FroggerRunner.BOARD_WIDTH)
    	{
    		//creates a random but constant stream of cars
    		if(k == 1)
    			x =-(int)(Math.random()*700);
    		if(k == 2)
        		x =-(int)(Math.random()*1400);
    		if(k == 3)
        		x =-(int)(Math.random()*1400);
    		if(k == 4)
    			x =-(int)(Math.random()*1400);
    		if(k == 5)
        		x =-(int)(Math.random()*1400);
    		if(k == 6)
        		x =-(int)(Math.random()*1400);
    		if(k == 7)
    			x =-(int)(Math.random()*1400);
    		if(k == 8)
        		x =-(int)(Math.random()*700);
    		if(k == 9)
        		x =-(int)(Math.random()*700);
    		if(k == 10)
    			x =-(int)(Math.random()*700);
    		if(k == 11)
        		x =-(int)(Math.random()*700);
    		if(k == 12)
        		x =-(int)(Math.random()*700);
    	}
    }
    public  boolean collision(int x, int y)
    {
    	return x > left && x < right && y < bot && y > top;//(x > left && x<right &&y<top && y>bot);
    }
    public BufferedImage getImage()
    {
    	return carImage;
    }
    
    public int getX()//returns x position
    {
    	return x;
    }
    
    public int getY()//returns y position
    {
    	return y;
    }    
    
    public int getWidth()//returns width
    {
    	return width;
    }
    
    public int getHeight()//returns height
    {
    	return height;
    }
    
    public int getVelocity()//gets velocity
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
    		velocity--;;
    		vel--;
    	}
    }
    public void addRandomStop()
    {
    	int r = (int)(Math.random()*30);
    	if(r==0)
    	{
    			velocity=0;
    	}
    	if(r>0)
    		velocity = vel;
    }
    public void setX(int x)//sets x position
    {
    	this.x = x;
    }
    
    public void setY(int y)//sets y position
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
    	InputStream input = getClass().getResourceAsStream("carAlt.png");
    	
    	try
    	{
    		this.carImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    } 
    
    public void changeBack()
    {
    	InputStream input = getClass().getResourceAsStream("car.png");
    	
    	try
    	{
    		this.carImage = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    }
}