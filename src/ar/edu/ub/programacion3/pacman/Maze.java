package ar.edu.ub.programacion3.pacman;

public class Maze
{
	private static final int MAZE_DEFAULT_ROWS = 5;
	private static final int MAZE_DEFAULT_COLUMNS = 5;
	
	private static final int PACMAN_DEFAULT_INITIAL_ROW = 2;
	private static final int PACMAN_DEFAULT_INITIAL_COLUMN = 2;

	///////////////////////////////////////////////////////////////////////////
	//
	
	private int rows;
	private int columns;
	
	private String[][] maze;	
	private Pacman pacman;
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public Maze()
	{
		this.setRows( getMazeDefaultRows() );
		this.setColumns( getMazeDefaultColumns() );		
		
		this.setPacman( new Pacman( new Coordinates( getPacmanDefaultInitialRow(), getPacmanDefaultInitialColumn() ) ) );
		
		this.initializeMaze();		
	}
	
	private void initializeMaze()
	{
		this.setMaze( new String[ this.getRows() ] [this.getColumns() ] );
		
		for( int row = 0; row < this.getRows(); row++ )
			for( int column = 0; column < this.getColumns(); column++ )
				this.getMaze()[row][column] = MazeContent.BALL.getRepresentation();
		
		this.pacManUp();		
	}

	private void updatePacmanDraw()
	{
		this.getMaze()[this.getActualRow()][this.getActualColumn()] = this.getPacmanRepresentation();		
	}

	private String getPacmanRepresentation()
	{	
		return this.getPacman().getRepresentation();
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
		if( !isValidCoordinate(row, column) )
			return false;
		
		return this.getMaze()[ row ][ column ] == MazeContent.EMPTY.getRepresentation();
	}

	private boolean isValidCoordinate(int row, int column) {
		return this.isValidRow( row  ) && this.isValidColumn( column );
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
		if( !isValidCoordinate(row, column) )
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
	}
	
	public boolean isPacManLookingUp()
	{
		return this.getPacman().isPacManLookingUp();
	}
	
	public boolean isPacManLookingLeft()
	{
		return this.getPacman().isPacManLookingLeft();
	}
	
	public boolean isPacManLookingRight()
	{
		return this.getPacman().isPacManLookingRight();
	}
	
	public void pacManDown()
	{
		this.getPacman().pacManDown();
		this.updatePacmanDraw();
	}	
	
	public void pacManUp()
	{
		this.getPacman().pacManUp();
		this.updatePacmanDraw();
	}	
	
	public void pacManLeft()
	{
		this.getPacman().pacManLeft();
		this.updatePacmanDraw();
	}	
	
	public void pacManRight()
	{
		this.getPacman().pacManRight();
		this.updatePacmanDraw();
	}	
	
	public void tick()
	{
		int oldRow = this.getActualRow();
		int oldColumn = this.getActualColumn();

		//Hago el step del pacman
		this.setPacmanCoordinate( this.getValidCoordinate( this.getPacman().getNextCoordinate() ) );		
		
		//Hago el dibujo
		this.updatePacmanDraw();
		
		//Reemplazo la posicion anterior por un blanco
		this.getMaze()[oldRow][oldColumn] = MazeContent.EMPTY.getRepresentation();
		
	}
	
	private void setPacmanCoordinate(Coordinates validCoordinate) {
		this.getPacman().setRow( validCoordinate.getRow() );
		this.getPacman().setColumn( validCoordinate.getColumn() );		
	}
	
	private int getValidCoordinate( int value, int maximum ){
		return ( ( value % maximum ) + maximum ) % maximum;		
	}

	private Coordinates getValidCoordinate(Coordinates coordinate) {
		
		Coordinates validCoordinate = new Coordinates( coordinate );
		
		validCoordinate.setColumn( this.getValidCoordinate( validCoordinate.getColumn(), this.getColumns() ) ); 
		validCoordinate.setRow( this.getValidCoordinate( validCoordinate.getRow(), this.getRows() ) ); 		
		
		return validCoordinate;
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
		return this.getPacman().getRow();
	}

	private int getActualColumn()
	{
		return this.getPacman().getColumn();
	}

	private String[][] getMaze()
	{
		return maze;
	}

	private void setMaze(String[][] maze)
	{
		this.maze = maze;
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
