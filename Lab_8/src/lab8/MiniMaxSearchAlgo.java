package lab8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		System.out.println("Minimax:");
		int v = maxValue(node);
		node.setValue(v);
		for (Node chil : node.getChildren()) {
			if (node.getValue() == chil.getValue()) {
				System.out.println("Nuoc di tot nhat de Max tai " + node.getLabel() + " la: " + chil.getLabel() );
			}
		}
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MIN_VALUE;
		for (Node child : node.getChildren()) {
			v = Math.max(v, minValue(child));
		}
		node.setValue(v);
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MAX_VALUE;
		for (Node child : node.getChildren()) {
			v = Math.min(v, maxValue(child));
		}
		node.setValue(v);
		return v;
	}
}