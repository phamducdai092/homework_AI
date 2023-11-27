package lab8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		System.out.println("AlphaBeta: Right -> Left");
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		node.setValue(v);
		for (Node chil : node.getChildren()) {
			if (node.getValue() == chil.getValue()) {
				System.out.println("Nuoc di tot nhat de Max tai " + node.getLabel() + " la: " + chil.getLabel() );
			}
		}
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MIN_VALUE;
		List<Node> chil = node.getChildren();
		Collections.sort(chil, node.LabelComparator);
		Collections.reverse(chil);

		for (int i = 0; i < chil.size(); i++) {
			v = Math.max(v, minValue(chil.get(i), alpha, beta));
			if (v >= beta) {
				for (int j = i + 1; j < chil.size(); j++) {
					System.out.println("Cat tia node: " + chil.get(j).getLabel());
				}
				node.setValue(v);
				return v;
			}
			alpha = Math.max(alpha, v);
		}

		node.setValue(v);
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MAX_VALUE;
		List<Node> chil = node.getChildren();
		Collections.sort(chil, node.LabelComparator);
		Collections.reverse(chil);

		for (int i = 0; i < chil.size(); i++) {
			v = Math.min(v, maxValue(chil.get(i), alpha, beta));
			if (v <= alpha) {
				for (int j = i + 1; j < chil.size(); j++) {
					System.out.println("Cat tia node: " + chil.get(j).getLabel());
				}
				node.setValue(v);
				return v;
			}
			beta = Math.min(beta, v);
		}
		node.setValue(v);
		return v;
	}
}
