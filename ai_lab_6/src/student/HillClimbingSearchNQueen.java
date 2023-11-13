package student;

public class HillClimbingSearchNQueen {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node execute(Node currentState) {
		Node neighbour = null;
		if (currentState.getH() == 0) {
			return currentState;
		}
		stepClimbed++;
		while (currentState.getH() != 0) {
			neighbour = findBestSub(currentState);
			if (neighbour.getH() >= currentState.getH()) { // currentState is best state
				stepClimbed = 0;
				return currentState;
			}
			currentState = neighbour;
		}
		return currentState;
	}

	public Node findBestSub(Node state) {
		int i = Integer.MAX_VALUE;
		Node temp = new Node();
		for (Node child : state.generateAllCandidates()) {
			if (child.getH() < i) {
				i = child.getH();
				temp = child;
			}
		}
		return temp;
	}

	public Node executeHillClimbingWithRandomRestart(Node currentState) {
		Node temp = execute(currentState);
		if (temp.getH() == 0) {
			return temp;
		}
		while (temp.getH() != 0) {
			randomRestarts++;
			temp.generateBoard();
			temp = execute(temp);
		}
		return temp;
	}
}
