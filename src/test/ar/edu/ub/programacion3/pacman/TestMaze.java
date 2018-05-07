package test.ar.edu.ub.programacion3.pacman;

import ar.edu.ub.programacion3.pacman.Maze;
import junit.framework.TestCase;

public class TestMaze extends TestCase
{
	public void testInitIsPacManLookingUp()
	{
		Maze maze = new Maze();
		
		assertTrue( maze.isPacManLookingUp() );
	}
	
	public void testInitIsPacmanAtDefaultRowCols()
	{
		Maze maze = new Maze();
		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );		
	}
	
	public void testTurnUpFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManUp();
		
		assertTrue( maze.isPacManLookingUp() );
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );		
	}
	
	public void testTurnDownFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManDown();
		
		assertTrue( maze.isPacManLookingDown() );
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );		
	}
	
	public void testTurnLeftFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManLeft();
		
		assertTrue( maze.isPacManLookingLeft() );
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );		
	}
	
	public void testTurnRightFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManRight();
		
		assertTrue( maze.isPacManLookingRight() );
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );		
	}
	
	public void testMoveUpFromInit()
	{
		Maze maze = new Maze();
		
		maze.tick();
		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow() - 1, Maze.getPacmanDefaultInitialColumn() ) );
		assertTrue( maze.isEmptyAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );
	}
	
	public void testMoveDownFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManDown();
		assertTrue( maze.isPacManLookingDown() );
		
		maze.tick();		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow() + 1, Maze.getPacmanDefaultInitialColumn() ) );
		assertTrue( maze.isEmptyAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );
	}
	
	public void testMoveLeftFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManLeft();
		assertTrue( maze.isPacManLookingLeft() );
		
		maze.tick();		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() - 1) );
		assertTrue( maze.isEmptyAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );
	}
	
	
	public void testMoveRightFromInit()
	{
		Maze maze = new Maze();
		
		maze.pacManRight();
		assertTrue( maze.isPacManLookingRight() );
		
		maze.tick();		
		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() + 1) );
		assertTrue( maze.isEmptyAt( Maze.getPacmanDefaultInitialRow(), Maze.getPacmanDefaultInitialColumn() ) );
	}
	
	public void testMoveUpFromInitUntilCycles()
	{
		Maze maze = new Maze();
		
		maze.tick();
		maze.tick();
		maze.tick();
		
		assertTrue( maze.isPacmanAt( Maze.getMazeDefaultRows() - 1, Maze.getPacmanDefaultInitialColumn() ) );
		assertTrue( maze.isPacManLookingUp() );
	}	
	
	public void testMoveLeftFromInitUntilCycles()
	{
		Maze maze = new Maze();
		
		maze.pacManLeft();
		
		maze.tick();
		maze.tick();
		maze.tick();
		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), Maze.getMazeDefaultColumns() -1  ) );
		assertTrue( maze.isPacManLookingLeft() );
	}	
	
	public void testMoveDownFromInitUntilCycles()
	{
		Maze maze = new Maze();
		
		maze.pacManDown();
		
		maze.tick();
		maze.tick();
		maze.tick();
		
		assertTrue( maze.isPacmanAt( 0, Maze.getPacmanDefaultInitialColumn()  ) );
		assertTrue( maze.isPacManLookingDown() );
	}	
	
	public void testMoveRightFromInitUntilCycles()
	{
		Maze maze = new Maze();
		
		maze.pacManRight();
		
		maze.tick();
		maze.tick();
		maze.tick();
		
		assertTrue( maze.isPacmanAt( Maze.getPacmanDefaultInitialRow(), 0  ) );
		assertTrue( maze.isPacManLookingRight() );
	}	
	
}
