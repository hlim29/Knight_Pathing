import java.util.LinkedList;

public class Knight extends Piece {
	private LinkedList<Square> possibleMoves = new LinkedList<Square>();

	private int legalOffsets[][] = 
								{ 	{ 1, -2 }, 
									{ 2, -1 }, 
									{ 2, 1 }, 
									{ 1, 2 },
									{ -1, 2 }, 
									{ -2, 1 }, 
									{ -2, -1 }, 
									{ -1, -2 }	};
	
	public Knight(int x, int y) {
		super(x, y);
	}
	
	public Knight(Square s){
		super(s);
	}

	private void calculatePossibleMoves() {
		Square temp;
		for (int[] offset : legalOffsets){
			temp = new Square(this.getxCoord() + offset[0], this.getyCoord() + offset[1]);
			if (!temp.offBoard())
				possibleMoves.add(temp);
		}
	}
	
	public LinkedList<Square> getPossibleMoves(){
		calculatePossibleMoves();
		return possibleMoves;
	}
	
	public Square getSquare(){
		return new Square(getxCoord(), getyCoord());
	}
}
