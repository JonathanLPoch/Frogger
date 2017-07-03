import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.HashSet;
public class FroggerGame extends JPanel implements ActionListener
{
	private ArrayList<Turtle> turtles;
	private HashSet<Car> cars;
	private Timer timer; //keeps track of when move() and repaint() will be called
	private Frog frog; //the player's frog that he/she will be able to control
	private Log log;
	private Log log2;
	private Log log3;
	private Log log4;
	private ShortLog sl;
	private ShortLog sl2;
	private Car car;
	private Car car2;
	private Car car4;
	private Car car5;
	private Car car6;
	private static int score;
	private int lillipadsFilled;
	private int level;
	private Frog life1;
	private Frog life2;
	private Frog life3;
	private int lives;
	private Lillipad l;
	private Lillipad l2;
	private Lillipad l3;
	private Lillipad l4;
	private Lillipad l5;
	private Lillipad l6;
	private Turtle turtle;
	private Turtle turtle2;
	private Turtle turtle3;
	private Turtle turtle4;
	private Turtle turtle5;
	private Turtle turtle6;
	private Turtle turtle7;
	private Turtle turtle8;
	private Turtle turtle9;
	private Turtle turtle10;
	private Truck truck;
	private Truck truck2;
	private Water w;
	private int v;
	public FroggerGame()
	{
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		score= 0;
		v=0;
		level=1;
		lives = 3;
		turtles = new ArrayList<Turtle>();
		//creates cars
		cars = new HashSet<Car>();
		car = new Car(0, (int)((-15) + 350), 7,1); //log from left side, random x +/- 100, +10v
		car.setX(-1 * car.getWidth()+100);
		//car2 = new Car(0, (int)((20) + 350), 0,2); //log from left side, random x +/- 100, +10v
		//car2.setX(-1 * car2.getWidth());
		//car3 = new Car(0, (int)((40) + 350), 10,3); //log from left side, random x +/- 100, +10v
		//car3.setX(-1 * car3.getWidth());
		car4 = new Car(0, (int)((60) + 350), 7,4); //log from left side, random x +/- 100, +10v
		car4.setX(-1 * car4.getWidth()+400);
		car5 = new Car(0, (int)((90) + 350), 7,5); //log from left side, random x +/- 100, +10v
		car5.setX(-1 * car5.getWidth()+250);
		car6 = new Car(0, (int)((10) + 350),7,6); //log from left side, random x +/- 100, +10v
		car6.setX(-1 * car6.getWidth()+800);
		//creates trucks
		truck = new Truck(0, (int)((40) + 350), -7,1); //log from left side, random x +/- 100, +10v
		truck.setX(450);
		truck2 = new Truck(0, (int)((125) + 350), -7,2); //log from left side, random x +/- 100, +10v
		truck2.setX(800);
		cars.add(car);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		//frogs and their lives
		frog = new Frog(450, 600, 20); //frog's init position is (0,0) and init vel is 20
		life1 = new Frog(700, 10, 30);
		life2 = new Frog(750, 10, 30);
		life3 = new Frog(800, 10, 30);
		log = new Log(0, (int)((170)), 1); //log from left side, random x +/- 100, +10v
		log.setX(-1 * log.getWidth());
		log2 = new Log(0, (int)((170)), 1); //log from left side, random x +/- 100, +10v
		log2.setX(-1 * log2.getWidth()+450);
		sl = new ShortLog(0, (int)((170)), 1);
		sl.setX(-1 * sl.getWidth()+700);
		log3 = new Log(0, (int)((272)), 1); //log from left side, random x +/- 100, +10v
		log3.setX(-1 * log2.getWidth());
		log4 = new Log(0, (int)((272)), 1); //log from left side, random x +/- 100, +10v
		log4.setX(-1 * log2.getWidth()+700);
		sl2 = new ShortLog(0, (int)((270)), 1);
		sl2.setX(-1 * sl2.getWidth()+300);
		l = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		l.setX(25);
		l2 = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		l2.setX(225);
		l3 = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		l3.setX(425);
		l4 = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		l4.setX(625);
		l5 = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		l5.setX(825);
		//l6 = new Lillipad(0, (int)((50)), 0); //lillipad from left side, random x +/- 100, +10v
		//l6.setX(200);
		//creates turtles
		turtle = new Turtle(0, (int)((215)), -1);
		turtle.setX(-1 * turtle.getWidth()+900);
		turtle2 = new Turtle(0, (int)((215)), -1);
		//offsets so they look like consecutive turtles
		turtle2.setX(-1 * turtle2.getWidth()+900-turtle2.getWidth());
		turtle3 = new Turtle(0, (int)((215)), -1);
		turtle3.setX(-1 * turtle3.getWidth()+450);
		turtle4 = new Turtle(0, (int)((215)), -1);
		turtle4.setX(-1 * turtle4.getWidth()+450-turtle4.getWidth());
		turtle5 = new Turtle(0, (int)((215)), -1);
		turtle5.setX(-1 * turtle5.getWidth()+450-2*turtle5.getWidth());
		turtle6 = new Turtle(0, (int)((110)), -1);
		turtle6.setX(-1 * turtle6.getWidth()+600);
		turtle7 = new Turtle(0, (int)((110)), -1);
		turtle7.setX(-1 * turtle7.getWidth()+600-turtle7.getWidth());
		turtle8 = new Turtle(0, (int)((110)), -1);
		turtle8.setX(-1 * turtle8.getWidth()+150);
		turtle9 = new Turtle(0, (int)((110)), -1);
		turtle9.setX(-1 * turtle9.getWidth()+150-turtle9.getWidth());
		turtle10 = new Turtle(0, (int)((110)), -1);
		turtle10.setX(-1 * turtle10.getWidth()+150-2*turtle10.getWidth());
		turtles.add(turtle);
		turtles.add(turtle2);
		turtles.add(turtle3);
		turtles.add(turtle4);
		turtles.add(turtle5);
		turtles.add(turtle6);
		turtles.add(turtle7);
		turtles.add(turtle8);
		turtles.add(turtle9);
		turtles.add(turtle10);
		w = new Water(0, (int)((50)), 0);
		w.setX(0);
		timer = new Timer(20, this); //timer will call actionPerformed every 100 ms
		timer.start(); 
	}
	
	public void paint(Graphics g)
	{
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		//less painted as lives decrease
		if(lives == 0)
		{
			g2d.drawString("GAME OVER",410,300);
			g2d.drawString("SCORE: " + score,410,320);
			return;
		}
		g2d.drawString("SCORE "+score,25,25);
		g2d.drawString("LEVEL "+level,150,25);
		//decreases as lives are lost
		if(lives == 3)
		{
			g2d.drawImage(life1.getImage(), life1.getX(), life1.getY(), this);
			g2d.drawImage(life2.getImage(), life2.getX(), life2.getY(), this);
			g2d.drawImage(life3.getImage(), life3.getX(), life3.getY(), this);
			if(level%2==0)
			{
				g2d.drawImage(life1.getAltImage(), life1.getX(), life1.getY(), this);
				g2d.drawImage(life2.getAltImage(), life2.getX(), life2.getY(), this);
				g2d.drawImage(life3.getAltImage(), life3.getX(), life3.getY(), this);
			}
		}
		if(lives == 2)
		{
			g2d.drawImage(life1.getImage(), life1.getX(), life1.getY(), this);
			g2d.drawImage(life2.getImage(), life2.getX(), life2.getY(), this);
			if(level%2==0)
			{
				g2d.drawImage(life1.getAltImage(), life1.getX(), life1.getY(), this);
				g2d.drawImage(life2.getAltImage(), life2.getX(), life2.getY(), this);
			}
		}
		if(lives == 1)
		{
			g2d.drawImage(life1.getImage(), life1.getX(), life1.getY(), this);
			if(level%2==0)
			{
				g2d.drawImage(life1.getAltImage(), life1.getX(), life1.getY(), this);
			}
		}
		g2d.drawImage(w.getImage(), w.getX(), w.getY(), this);
		g2d.drawImage(log.getImage(), log.getX(), log.getY(), this);
		g2d.drawImage(log2.getImage(), log2.getX(), log2.getY(), this);
		g2d.drawImage(log3.getImage(), log3.getX(), log3.getY(), this);
		g2d.drawImage(log4.getImage(), log4.getX(), log4.getY(), this);
		g2d.drawImage(sl.getImage(), sl.getX(), sl.getY(), this);
		g2d.drawImage(sl2.getImage(), sl2.getX(), sl2.getY(), this);
		for(Car c:cars)
		{
			g2d.drawImage(c.getImage(),c.getX(),c.getY(),this);
		}
		g2d.drawImage(truck.getImage(),truck.getX(),truck.getY(),this);
		g2d.drawImage(truck2.getImage(),truck2.getX(),truck2.getY(),this);
		g2d.drawImage(l.getImage(), l.getX(), l.getY(), this);
		g2d.drawImage(l2.getImage(), l2.getX(), l2.getY(), this);
		g2d.drawImage(l3.getImage(), l3.getX(), l3.getY(), this);
		g2d.drawImage(l4.getImage(), l4.getX(), l4.getY(), this);
		g2d.drawImage(l5.getImage(), l5.getX(), l5.getY(), this);
		//g2d.drawImage(l6.getImage(), l6.getX(), l6.getY(), this);
		for(Turtle t: turtles)
		{
			g2d.drawImage(t.getImage(),t.getX(),t.getY(),this);
		}
		g2d.drawImage(frog.getImage(), frog.getX(), frog.getY(), this);
		if(level%2==0)
			g2d.drawImage(frog.getAltImage(), frog.getX(), frog.getY(), this);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		frog.setObstacleStatus(false);
		//System.out.println(frog.x + ", " + frog.y);
		//System.out.println(car2.top + ", " +car2.bot + ", " +car2.left + ", " +car2.right);
		//Car intersections
		if(car.getBounds().intersects(frog.getBounds()) ||   truck.getBounds().intersects(frog.getBounds()) || truck2.getBounds().intersects(frog.getBounds()) || car4.getBounds().intersects(frog.getBounds()) || car5.getBounds().intersects(frog.getBounds()) || car6.getBounds().intersects(frog.getBounds()))
		{
			frog.setX(450- (frog.getWidth() / 2));
			frog.setY(600);
			lives--;
		}
		/*if(frog.getY() < 50)
		{
			frog.setX(450); 
			frog.setY(600);
			level++;
		}*/
		//lillipad intersections, if even level put a red frog, if odd put a yellow
				if(l.getBounds().intersects(frog.getBounds()))
				{
					if(l.checkIfFull() == false)
					{
						frog.setX(450); 
						frog.setY(600);
						lillipadsFilled++;
						score+=50;
						l.changeToHaveFrog();
						if(level%2==0)
							l.changeToHaveFrogAlt();			
					}
				}

				if(l2.getBounds().intersects(frog.getBounds()))
				{
					if(l2.checkIfFull() == false)
					{
						frog.setX(450); 
						frog.setY(600);
						lillipadsFilled++;
						score+=50;
						l2.changeToHaveFrog();
						if(level%2==0)
							l2.changeToHaveFrogAlt();				
					}
				}
				if(l3.getBounds().intersects(frog.getBounds()))
				{
					if(l3.checkIfFull() == false)
					{
						frog.setX(450); 
						frog.setY(600);
						lillipadsFilled++;
						score+=50;
						l3.changeToHaveFrog();
						if(level%2==0)
							l3.changeToHaveFrogAlt();
					}
				}
				if(l4.getBounds().intersects(frog.getBounds()))
				{
					if(l4.checkIfFull() == false)
					{
						frog.setX(450); 
						frog.setY(600);
						lillipadsFilled++;
						score+=50;
						l4.changeToHaveFrog();
						if(level%2==0)
							l4.changeToHaveFrogAlt();
					}
				}

				if(l5.getBounds().intersects(frog.getBounds()))
				{
					if(l5.checkIfFull() == false)
					{
						frog.setX(450); 
						frog.setY(600);
						lillipadsFilled++;
						score+=50;
						l5.changeToHaveFrog();
						if(level%2==0)
							l5.changeToHaveFrogAlt();				
					}
				}

		//log and turtle intersections
		else if(log.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = log.getVelocity();
		}

		else if(log2.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = log2.getVelocity();
		}

		
		else if(log3.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = log3.getVelocity();
		}
		
		else if(log4.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = log4.getVelocity();
		}
		else if(sl.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = sl.getVelocity();
		}
		else if(sl2.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = sl2.getVelocity();
		}
		//turtle collisions
		else if(turtle.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle.getVelocity();
		}
		else if(turtle2.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle2.getVelocity();
		}
		else if(turtle3.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle3.getVelocity();
		}
		else if(turtle4.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle4.getVelocity();
		}
		else if(turtle5.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle5.getVelocity();
		}
		else if(turtle6.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle6.getVelocity();
		}
		else if(turtle7.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle7.getVelocity();
		}
		else if(turtle8.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle8.getVelocity();
		}
		else if(turtle9.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle9.getVelocity();
		}
		else if(turtle10.getBounds().intersects(frog.getBounds()))
		{
			frog.setObstacleStatus(true);
			v = turtle10.getVelocity();
		}
		//elses are if it is touching water and only touching
		else if(w.getBounds().intersects(frog.getBounds()))
		{
			frog.setX(450- (frog.getWidth() / 2));
			frog.setY(600);
			lives--;
		}
		//various moves
		frog.move(v);
		log.move();
		log2.move();
		log3.move();
		log4.move();
		sl.move();
		sl2.move();
		l.move();
		l2.move();
		l3.move();
		l4.move();
		l5.move();
		/*if(level>1)
		{
			car.addRandomStop();
			car5.addRandomStop();
			log.addRandomStop();
			sl2.addRandomStop();

		}
		if(level>2)
		{
			car.addRandomStop();
			car4.addRandomStop();
			car5.addRandomStop();
			car6.addRandomStop();
			truck.addRandomStop();
			truck2.addRandomStop();
			log2.addRandomStop();
			log4.addRandomStop();
			sl.addRandomStop();
		}
		if(level>3)
		{
			car.addRandomStop();
			car4.addRandomStop();
			car5.addRandomStop();
			car6.addRandomStop();
			truck.addRandomStop();
			truck2.addRandomStop();
			log.addRandomStop();
			log2.addRandomStop();
			log3.addRandomStop();
			log4.addRandomStop();
			sl.addRandomStop();
			sl2.addRandomStop();
		}*/
		for(Car c:cars)
			c.move();
		truck.move();
		truck2.move();
		for(int k=0;k<10;k++)
		{
			turtles.get(k).move();
		}
		if(lillipadsFilled == 5)
		{
			level++;
			
			frog.change(level);
			car.change(level);
			car4.change(level);
			car5.change(level);
			car6.change(level);
			truck.change(level);
			truck2.change(level);
			log.change(level);
			log2.change(level);
			log3.change(level);
			log4.change(level);
			sl.change(level);
			sl2.change(level);
			turtle.change(level);
			turtle2.change(level);
			turtle3.change(level);
			turtle4.change(level);
			turtle5.change(level);
			turtle6.change(level);
			turtle7.change(level);
			turtle8.change(level);
			turtle9.change(level);
			turtle10.change(level);
			
			car.changeVelocity();
			car4.changeVelocity();
			car5.changeVelocity();
			car6.changeVelocity();
			truck.changeVelocity();
			truck2.changeVelocity();
			log.changeVelocity();
			log2.changeVelocity();
			log3.changeVelocity();
			log4.changeVelocity();
			sl.changeVelocity();
			sl2.changeVelocity();
			turtle.changeVelocity();
			turtle2.changeVelocity();
			turtle3.changeVelocity();
			turtle4.changeVelocity();
			turtle5.changeVelocity();
			turtle6.changeVelocity();
			turtle7.changeVelocity();
			turtle8.changeVelocity();
			turtle9.changeVelocity();
			turtle10.changeVelocity();

			lillipadsFilled = 0;
			l.changeToBeEmpty();
			l2.changeToBeEmpty();
			l3.changeToBeEmpty();
			l4.changeToBeEmpty();
			l5.changeToBeEmpty();
			
			//l6.changeToBeEmpty();
			score += 1000;		
		}
		repaint();
	}
	public static int getScore()
	{
		return score;
	}
	public static void setScore(int x)
	{
		score = x;
	}
	private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            frog.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            frog.keyPressed(e);
        }
    }
}
