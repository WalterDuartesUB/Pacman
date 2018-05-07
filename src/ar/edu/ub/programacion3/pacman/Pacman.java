package ar.edu.ub.programacion3.pacman;

public class Pacman {
	private PacmanLooking looking;

	public Pacman(PacmanLooking looking) {
		this.setPacmanLooking( looking );
	}

	public Pacman() {
		this( PacmanLooking.UP );
		
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
}
