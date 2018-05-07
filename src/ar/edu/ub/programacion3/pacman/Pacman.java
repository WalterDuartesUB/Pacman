package ar.edu.ub.programacion3.pacman;

public class Pacman {
	private PacmanLooking looking;
	private Coordinates coordinates;
	
	public Pacman(PacmanLooking looking, Coordinates coordinates) {
		this.setPacmanLooking( looking );
		this.setCoordinates(coordinates);
	}

	public Pacman() {
		this( PacmanLooking.UP, new Coordinates( 2, 2 ) );
		
	}
	
	public Pacman(Coordinates coordinates) { 
		this( PacmanLooking.UP, coordinates );
	}

	private PacmanLooking getPacmanLooking() {
		return looking;
	}

	private void setPacmanLooking(PacmanLooking looking) {
		this.looking = looking;
	}
	
	public boolean isPacManLookingDown()
	{
		return this.getPacmanLooking() == PacmanLooking.DOWN;
	}
	
	public boolean isPacManLookingUp()
	{
		return this.getPacmanLooking() == PacmanLooking.UP;
	}
	
	public boolean isPacManLookingLeft()
	{
		return this.getPacmanLooking() == PacmanLooking.LEFT;
	}
	
	public boolean isPacManLookingRight()
	{
		return this.getPacmanLooking() == PacmanLooking.RIGHT;
	}
	
	public void pacManDown()
	{
		this.setPacmanLooking( PacmanLooking.DOWN );
	}	
	
	public void pacManUp()
	{
		this.setPacmanLooking( PacmanLooking.UP );
	}	
	
	public void pacManLeft()
	{
		this.setPacmanLooking( PacmanLooking.LEFT );
	}	
	
	public void pacManRight()
	{
		this.setPacmanLooking( PacmanLooking.RIGHT );
	}

	public String getRepresentation() {
		return this.getPacmanLooking().getRepresentation();
	}

	private Coordinates getCoordinates() {	
		return this.coordinates;
	}

	private void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public int getRow() {
		return this.getCoordinates().getRow();
	}

	public void setRow(int row) {
		this.getCoordinates().setRow(row);
	}
	
	public int getColumn() {
		return this.getCoordinates().getColumn();
	}

	public void setColumn(int column) {
		this.getCoordinates().setColumn(column);
	}

	public Coordinates getNextCoordinate() {
		return this.getCoordinates().add( this.getPacmanLooking().getStep() );
	}
}
