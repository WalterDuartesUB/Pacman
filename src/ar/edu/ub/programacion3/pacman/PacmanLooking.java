package ar.edu.ub.programacion3.pacman;

public enum PacmanLooking {
	UP {
		@Override
		public String getRepresentation() {
			return MazeContent.PACMAN_UP.getRepresentation();
		}

		@Override
		public Coordinates getStep() {
			return new Coordinates( -1, 0 );
		}
	},DOWN {
		@Override
		public String getRepresentation() {
			return MazeContent.PACMAN_DOWN.getRepresentation();
		}
		@Override
		public Coordinates getStep() {
			return new Coordinates( 1, 0 );
		}		
	},LEFT {
		@Override
		public String getRepresentation() {
			return MazeContent.PACMAN_LEFT.getRepresentation();
		}
		@Override
		public Coordinates getStep() {
			return new Coordinates( 0, -1 );
		}		
	},RIGHT {
		@Override
		public String getRepresentation() {
			return MazeContent.PACMAN_RIGHT.getRepresentation();
		}
		
		@Override
		public Coordinates getStep() {
			return new Coordinates( 0, 1 );
		}		
	};
	
	public abstract Coordinates getStep();
	public abstract String getRepresentation();
}
