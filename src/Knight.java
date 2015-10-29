import java.util.LinkedList;

public class Knight extends Piece {

	private final int LEGAL_OFFSETS[][] = 
								{ 	{ 2, -1 }, 
									{ -1, -2 },
									{ 2, 1 }, 
									{ -2, 1 }, 
									{ -2, -1 }, 
									{ 1, -2 }, 
									{ 1, 2 },
									{ -1, 2 }, 
									};
	
	public Knight(int x, int y) {
		super(x, y);
	}
	
	public Knight(Square s){
		super(s);
	}

	private void calculatePossibleMoves() {
		Square temp;
		for (int[] offset : LEGAL_OFFSETS){
			temp = new Square(currentSquare.getX() + offset[0], currentSquare.getY() + offset[1]);
			if (!temp.offBoard())
				possibleMoves.add(temp);
		}
	}
	
	public LinkedList<Square> getPossibleMoves(){
		calculatePossibleMoves();
		return possibleMoves;
	}
	
	public Square getSquare(){
		return currentSquare;
	}
}
