import java.util.LinkedList;

public class Piece {

	protected LinkedList<Square> possibleMoves = new LinkedList<Square>();
	protected Square currentSquare;
	
	public Piece(int x, int y){
			currentSquare = new Square(x,y);
	}
	
	public Piece(Square s){
		currentSquare = s;
	}
	
	
}
