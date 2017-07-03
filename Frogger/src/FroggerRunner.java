import javax.swing.JFrame;

public class FroggerRunner extends JFrame
{
	//width and height of the game world can be freely accessed by other classes
	public static final int BOARD_WIDTH = 900;
	public static final int BOARD_HEIGHT = 600;
	
	public FroggerRunner()
	{
		add(new FroggerGame());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(BOARD_WIDTH, BOARD_HEIGHT); //setting up dimensions of the game world
		setLocationRelativeTo(null);
		setTitle("FROGGER");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new FroggerRunner();
	}
}
