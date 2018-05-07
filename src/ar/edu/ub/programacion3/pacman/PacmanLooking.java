package ar.edu.ub.programacion3.pacman;

public enum PacmanLooking {
	UP {
		@Override
		public String getRepresentation() {
			return "V";
		}
	},DOWN {
		@Override
		public String getRepresentation() {
			return "^";
		}
	},LEFT {
		@Override
		public String getRepresentation() {
			return ">";
		}
	},RIGHT {
		@Override
		public String getRepresentation() {
			return "<";
		}
	};
	
	public abstract String getRepresentation();
}
