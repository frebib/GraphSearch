package search;

public class Coordinate {
	public int x,y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	// Both hasCode and equals must be overridden for the hashtablemap to work correctly
	@Override
	public int hashCode() {
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
		*/
		return x + y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
