import java.util.LinkedList;

public class Piece {

	private int xCoord;
	private int yCoord;
	protected Square currentLoc;
	
	public Piece(int x, int y){
		xCoord = x;
		yCoord = y;
	}
	
	public Piece(Square s){
		xCoord = s.getxCoord();
		yCoord = s.getyCoord();
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
	
	
}
