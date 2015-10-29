import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String input = prompt().toUpperCase();
		String[] inputs = input.split(" ");

		/*
		 * String test[] = { "a8","b1","c1","d1","e1","f1","g1","h1"};
		 * 
		 * for (String s : test){ Square temp = new Square(s.toUpperCase());
		 * System.out.println(s + " is: " + temp.getCoord());
		 * System.out.println(s + " is: " + temp.getxCoord() + ", " +
		 * temp.getyCoord());
		 * 
		 * }
		 */
		Square source = new Square(inputs[0]);
		Square dest = new Square(inputs[1]);

		Knight k1 = new Knight(source);
		Knight k2 = new Knight(dest);
		// LinkedList<Square> list1 = k.getPossibleMoves();

		// solve(source,dest, new LinkedList<String>(),0);
		bfs(new LinkedList<Square>(), k1.getSquare(), k2.getSquare());
		/*
		 * //TODO: Remove DEBUG LinkedList<Square> list = k1.getPossibleMoves();
		 * 
		 * for (Square s : list){ System.out.println(s.getCoord()); }
		 */

	}

	private static void bfs(LinkedList<Square> list, Square start, Square end) {
		LinkedList<Move> paths = new LinkedList<Move>();
		//Map<Square, Square> path = new HashMap<Square,Square>();
		
			LinkedList<Square> visited = new LinkedList<Square>();
			list.add(start);
			
			while (!list.isEmpty()){
				
				Square s = list.removeFirst();
				
				if (s.equals(end)){
					System.out.println(s.getCoord());
					System.out.println(list);
					System.out.println(visited);
					System.out.println(paths);
					//break;
				}
				
				LinkedList<Square> poss = new Knight(s).getPossibleMoves();
				for (Square t : poss){
					if (!visited.contains(t)){
						paths.add(new Move(s,t));
						visited.add(t);
						list.add(t);
					}
				}
			}
			
			backtrack(paths,start,end);
	}
	
	private static void backtrack(LinkedList<Move> moves, Square start, Square end){
		//LinkedList<Move> buffer = new LinkedList<Move>();
		for (Move m : moves){
			if (m.getNext().equals(end) && !start.equals(m.getNext())){
				//buffer.add(m);
				System.out.println(m);
				backtrack(moves,start,m.getPrev());
			} 
		}
		//buffer
	}

	private static void solve(Square start, Square dest,
			LinkedList<String> moves, int passes) {
		LinkedList<Square> list = new Knight(start).getPossibleMoves();
		for (Square s : list) {
			// String e = s.getCoord();

			if (s.getCoord().equals(dest.getCoord()))
				System.out.println(moves);
			else {
				passes++;
				if (passes < 8) {
					moves.add(s.getCoord());
					solve(s, dest, moves, passes);
				}
			}
		}
	}

	private static String prompt() {
		System.out.println("Input the starting and ending coordinates");
		return sc.nextLine();
	}
}
