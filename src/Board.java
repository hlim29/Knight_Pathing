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
		Solver.solve(sourceKnight.getSquare(), destinationKnight.getSquare());
	}

	private String readInput() {
		return sc.nextLine();
	}

	

}
