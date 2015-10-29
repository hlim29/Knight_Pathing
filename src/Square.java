public class Square {

	private int x;
	private int y;

	// For simplicity purposes, the 0th index is not used for the coordinates.
	private final String[] COORDINATE_LETTERS = { null, "A", "B", "C", "D",
			"E", "F", "G", "H" };
	private final int BOARD_LOWER_BOUND = 1;
	private final int BOARD_UPPER_BOUND = 8;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Square(String coord) throws Exception {
		validateInput(coord);
		x = coord.charAt(0) - 'A' + 1;
		y = coord.charAt(1) - '0';
	}

	private void validateInput(String coord) throws Exception {
		if (coord.length() > 2)
			throw new Exception("Invalid coordinate");
		if (coord.charAt(0) < 'A' || coord.charAt(0) > 'H'
				|| coord.charAt(1) < ('0' + BOARD_LOWER_BOUND)
				|| coord.charAt(1) > ('0' + BOARD_UPPER_BOUND))
			throw new Exception("Invalid coordinate");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getCoord() {
		return (COORDINATE_LETTERS[x] + y);
	}

	public boolean offBoard() {
		return (x < BOARD_LOWER_BOUND || y < BOARD_LOWER_BOUND
				|| y > BOARD_UPPER_BOUND || x > BOARD_UPPER_BOUND);
	}

	@Override
	public boolean equals(Object other) {
		return this.x == ((Square) other).getX()
				&& this.y == ((Square) other).getY();
	}

	@Override
	public String toString() {
		return (COORDINATE_LETTERS[x] + y);
	}

}
