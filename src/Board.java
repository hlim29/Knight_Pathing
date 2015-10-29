import java.util.LinkedList;
import java.util.Scanner;

public class Board {

	private Scanner sc = new Scanner(System.in);
	private Knight sourceKnight;
	private Knight destinationKnight;

	public Board() {
		printWelcome();
		String input = readInput().toUpperCase();
		String[] inputs = input.split(" ");
		Square source;
		Square dest;

		try {
			source = new Square(inputs[0]);
			dest = new Square(inputs[1]);
		} catch (Exception e) {
			System.out
					.println("The program has failed with the following error: "
							+ e.getMessage());
			e.printStackTrace();
			return;
		}

		sourceKnight = new Knight(source);
		destinationKnight = new Knight(dest);

	}
	
	private void printWelcome(){
		System.out.println("Welcome to the Knight's Travails solver!");
		System.out.println("Please input two Chess coordinates, with a space in between them");
		System.out.println("The first coordinate is the starting point, the second coordinate is the destination");
		System.out.println("Example: A8 B7");
	}

	public void solveKnightsTravails() {
		solve(sourceKnight.getSquare(), destinationKnight.getSquare());
	}

	private String readInput() {
		return sc.nextLine();
	}

	/**
	 * Uses the Breadth-first search algorithm. Adapted from psuedocode from
	 * http://en.wikipedia.org/wiki/Breadth-first_search
	 * 
	 * @param start
	 *            - the origin of the knight piece
	 * @param end
	 *            - the destination of the knight piece
	 */
	private void solve(Square start, Square end) {
		if (start == null || end == null)
			return;
		
		LinkedList<Move> paths = new LinkedList<Move>();
		LinkedList<Square> list = new LinkedList<Square>();
		LinkedList<Square> visited = new LinkedList<Square>();

		list.add(start);

		while (!list.isEmpty()) {

			Square s = list.removeFirst();

			if (s.equals(end)) {
				break;
			}

			LinkedList<Square> possibleSquares = new Knight(s).getPossibleMoves();
			for (Square t : possibleSquares) {
				if (!visited.contains(t)) {
					paths.add(new Move(s, t));
					visited.add(t);
					list.add(t);
				}
			}
		}

		LinkedList<Move> validPath = backtrack(paths, start, end,
				new LinkedList<Move>());
		printMoves(validPath);
	}

	/**
	 * Returns a list that begins from the destination to
	 * source positions. Recursive function.
	 * 
	 * @param moves
	 *           
	 *
	 * @param moves - a linkedlist containing piece moves
	 * @param start - the source square
	 * @param end - the destination square
	 * @param buffer - a String LinkedList that contains the current path
	 * @return
	 */
	private LinkedList<Move> backtrack(LinkedList<Move> moves, Square start,
			Square end, LinkedList<Move> buffer) {
		for (Move m : moves) {
			if (m.getNext().equals(end) && !start.equals(m.getNext())) {
				buffer.add(m);
				if (m.getPrev().equals(start))
					break;
				else
					backtrack(moves, start, m.getPrev(), buffer);
			}
		}
		return buffer;
	}

	/**
	 * The backtrack function returns a list that begins from the destination to
	 * source positions The printMoves method prints the list in reverse, so that the
	 * moves are shown from source to destination
	 * 
	 * @param moves
	 *            - a linkedlist containing piece moves
	 */
	private void printMoves(LinkedList<Move> moves) {
		StringBuffer output = new StringBuffer();
		while (!moves.isEmpty()) {
			output.append(moves.removeLast());
			if (moves.size() > 0)
				output.append(", ");
		}
		System.out.println(output.toString());
	}

}
