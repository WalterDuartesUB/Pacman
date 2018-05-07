import ar.edu.ub.programacion3.pacman.Maze;

public class Aplicacion
{

	public static void main(String[] args) throws InterruptedException
	{		
		
		Maze maze = new Maze();
		
		maze.pacManRight();
		
		maze.tick();		
		maze.print();
		

	}

}
