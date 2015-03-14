package search;

public class Coordinate {
	public byte x, y;

	public Coordinate(byte x, byte y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate(int x, int y) {
		this.x = (byte) x;
		this.y = (byte) y;
	}
	public Coordinate(float x, float y) {
		this.x = (byte) x;
		this.y = (byte) y;
	}
	public Coordinate(double x, double y) {
		this.x = (byte) x;
		this.y = (byte) y;
	}

	public byte getX() {
		return x;
	}

	public byte getY() {
		return y;
	}

	public void setX(byte x) {
		this.x = x;
	}

	public void setY(byte y) {
		this.y = y;
	}

	public Coordinate getDelta(Coordinate c) {
		return new Coordinate((byte) (c.x - x), (byte) (c.y - y));
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
	@Override
	public int hashCode() {
		return x + (y << 8);
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
