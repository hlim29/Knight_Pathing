public class Square {

	private int xCoord;
	private int yCoord;
	private final String[] COORDINATE_LETTERS = { null, "A", "B", "C", "D", "E", "F",
			"G", "H" };

	public Square(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	public Square(String algCoord){
		xCoord  = algCoord.charAt(0) - 'A' + 1;
		
		yCoord  = algCoord.charAt(1) - '0';
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public String getCoord() {
		return (COORDINATE_LETTERS[xCoord] + yCoord);
	}

	public boolean offBoard() {
		return (xCoord < 1 || yCoord < 1 || yCoord > 8 || xCoord > 8);
	}
	
	@Override
	public boolean equals(Object other){
		return this.getxCoord() == ((Square) other).getxCoord() && this.getyCoord() == ((Square) other).getyCoord();
	}
	
	@Override
	public String toString(){
		return (COORDINATE_LETTERS[xCoord] + yCoord);
	}

}
