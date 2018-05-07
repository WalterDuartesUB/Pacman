package ar.edu.ub.programacion3.pacman;

public class Maze
{
	private static final int MAZE_DEFAULT_ROWS = 5;
	private static final int MAZE_DEFAULT_COLUMNS = 5;
		
	private static final String MAZE_POSITION_BALL = "*";
	private static final String MAZE_POSITION_EMPTY = " ";
	
	private static final String MAZE_POSITION_PACMAN_UP = "^";
	private static final String MAZE_POSITION_PACMAN_DOWN = "V";
	private static final String MAZE_POSITION_PACMAN_LEFT = "<";
	private static final String MAZE_POSITION_PACMAN_RIGHT = ">";
	
	private static final int PACMAN_DEFAULT_INITIAL_ROW = 2;
	private static final int PACMAN_DEFAULT_INITIAL_COLUMN = 2;
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private enum PacmanLooking{
		PACMAN_UP,
		PACMAN_DOWN,
		PACMAN_LEFT,
		PACMAN_RIGHT
	};
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private int rows;
	private int columns;
	
	private int actualRow;
	private int actualColumn;
	
	private String[][] maze;
	
	private PacmanLooking pacmanLooking;
	
	private Pacman pacman;
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public Maze()
	{
		this.setRows( getMazeDefaultRows() );
		this.setColumns( getMazeDefaultColumns() );
		
		this.setActualColumn(getPacmanDefaultInitialColumn() );
		this.setActualRow( getPacmanDefaultInitialRow() );
		
		this.setPacman( new Pacman() );
		
		this.initializeMaze();		
	}
	
	private void initializeMaze()
	{
		this.setMaze( new String[ this.getRows() ] [this.getColumns() ] );
		
		for( int row = 0; row < this.getRows(); row++ )
			for( int column = 0; column < this.getColumns(); column++ )
				this.getMaze()[row][column] = MAZE_POSITION_BALL;
		
		this.pacManUp();		
	}

	private void updatePacmanDraw()
	{
		this.getMaze()[this.getActualRow()][this.getActualColumn()] = this.getPacmanRepresentation();		
	}

	private String getPacmanRepresentation()
	{	
		return this.getPacman().getRepresentation();
		/*
		if( this.isPacManLookingDown() )
			return MAZE_POSITION_PACMAN_DOWN;
		
		if( this.isPacManLookingUp() )
			return MAZE_POSITION_PACMAN_UP;
		
		if( this.isPacManLookingLeft() )
			return MAZE_POSITION_PACMAN_LEFT;
				
		return MAZE_POSITION_PACMAN_RIGHT;
		*/
	}

	public int getRows()
	{
		return rows;
	}
	private void setRows(int rows)
	{
		this.rows = rows;
	}
	public int getColumns()
	{
		return columns;
	}
	private void setColumns(int columns)
	{
		this.columns = columns;
	}
	
	public boolean isEmptyAt(int row, int column )
	{
		if( !this.isValidRow( row  ) || !this.isValidColumn( column ) )
			return false;
		
		return this.getMaze()[ row ][ column ] == MAZE_POSITION_EMPTY;
	}
	
	private boolean isValidColumn(int column)
	{
		return column >= 0 || column < this.getColumns();
	}

	private boolean isValidRow(int row)
	{
		return row >= 0 || row < this.getRows();
	}

	public boolean isPacmanAt(int row, int column )
	{
		if( !this.isValidRow( row  ) || !this.isValidColumn( column ) )
			return false;
		
		return this.isPacman( this.getMaze()[ row ][ column ] );
	}
	
	private boolean isPacman(String mazePosition )
	{
		return  mazePosition == this.getPacmanRepresentation();
	}

	public boolean isPacManLookingDown()
	{
		return this.getPacman().isPacManLookingDown();
//		return this.getPacmanLooking() == PacmanLooking.PACMAN_DOWN;
	}
	
	public boolean isPacManLookingUp()
	{
		return this.getPacman().isPacManLookingUp();
//		return this.getPacmanLooking() == PacmanLooking.PACMAN_UP;
	}
	
	public boolean isPacManLookingLeft()
	{
		return this.getPacman().isPacManLookingLeft();
//		return this.getPacmanLooking() == PacmanLooking.PACMAN_LEFT;
	}
	
	public boolean isPacManLookingRight()
	{
		return this.getPacman().isPacManLookingRight();
//		return this.getPacmanLooking() == PacmanLooking.PACMAN_RIGHT;
	}
	
	public void pacManDown()
	{
		this.getPacman().pacManDown();
//		this.setPacmanLooking( PacmanLooking.PACMAN_DOWN );
	}	
	
	public void pacManUp()
	{
		this.getPacman().pacManUp();
//		this.setPacmanLooking( PacmanLooking.PACMAN_UP );
	}	
	
	public void pacManLeft()
	{
		this.getPacman().pacManLeft();
//		this.setPacmanLooking( PacmanLooking.PACMAN_LEFT );
	}	
	
	public void pacManRight()
	{
		this.getPacman().pacManRight();
//		this.setPacmanLooking( PacmanLooking.PACMAN_RIGHT );
	}	
	
	public void tick()
	{
		int oldRow = this.getActualRow();
		int oldColumn = this.getActualColumn();
		
		if( this.isPacManLookingDown() )			
			this.setActualRow( this.nextRow( oldRow ) );
		
		else if( this.isPacManLookingUp() )			
			this.setActualRow( this.prevRow( oldRow ) );
		
		else if( this.isPacManLookingLeft() )			
			this.setActualColumn( this.prevColumn( oldColumn ) );
		
		else if( this.isPacManLookingRight() )	
			this.setActualColumn( this.nextColumn( oldColumn ) );
			
		this.updatePacmanDraw();
		this.getMaze()[oldRow][oldColumn] = MAZE_POSITION_EMPTY;	
		
	}
	
	private int prevColumn(int column)
	{
		return ( column == 0 ? this.getColumns() : column ) - 1;
	}

	private int nextColumn(int column)
	{
		return ( column + 1 == this.getColumns() ? 0 : column + 1 );
	}

	private int prevRow(int row)
	{
		return ( row == 0 ? this.getRows() : row ) - 1;
	}

	private int nextRow(int row)
	{
		return ( row + 1 == this.getRows() ? 0 : row + 1 );
	}

	public void print()
	{
		for( String[] row : this.getMaze() )
		{
			for( String mazePosition : row )
				System.out.print( mazePosition );
			
			System.out.println();
		}
	}

	private int getActualRow()
	{
		return actualRow;
	}

	private void setActualRow(int actualRow)
	{
		this.actualRow = actualRow;
	}

	private int getActualColumn()
	{
		return actualColumn;
	}

	private void setActualColumn(int actualColumn)
	{
		this.actualColumn = actualColumn;
	}

	private String[][] getMaze()
	{
		return maze;
	}

	private void setMaze(String[][] maze)
	{
		this.maze = maze;
	}

	private PacmanLooking getPacmanLooking()
	{
		return pacmanLooking;
	}

	private void setPacmanLooking(PacmanLooking pacmanLooking)
	{
		this.pacmanLooking = pacmanLooking;
		this.updatePacmanDraw();
	}

	public static int getPacmanDefaultInitialRow()
	{
		return PACMAN_DEFAULT_INITIAL_ROW;
	}

	public static int getPacmanDefaultInitialColumn()
	{
		return PACMAN_DEFAULT_INITIAL_COLUMN;
	}

	public static int getMazeDefaultColumns()
	{
		return MAZE_DEFAULT_COLUMNS;
	}

	public static int getMazeDefaultRows()
	{
		return MAZE_DEFAULT_ROWS;
	}

	private Pacman getPacman() {
		return pacman;
	}

	private void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

}
