package student;

public class TestHillClimbing {
	public static void main(String[] args) {

		Node test = new Node();
		test.generateBoard();
		System.out.println("Default board: ");
		test.displayBoard();
		
		System.out.println("\nHill Climbing: ");
		HillClimbingSearchNQueen testHill = new HillClimbingSearchNQueen();
		testHill.executeHillClimbingWithRandomRestart(test).displayBoard();

		System.out.println("\nSA: ");
		SA_NQueenAlgo testSA = new SA_NQueenAlgo();
		testSA.execute(test).displayBoard();
	}
}
