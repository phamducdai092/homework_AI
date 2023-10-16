package k21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class DepthFirstSearchAlgo implements ISearchAlgo {
	Stack<Node> frontier = new Stack<Node>();

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<>();

		frontier.add(root);
		while (!frontier.isEmpty()) {

			Node currentNode = frontier.pop();
			List<Node> children = currentNode.getChildrenNodes();
			Collections.reverse(children);
			
			if (!explored.contains(currentNode)) {
				explored.add(currentNode);
				if (currentNode.getLabel().equals(goal)) {
					return currentNode;
				}
				for (Node child : children) {
					if (!explored.contains(child)) {
						frontier.add(child);
						child.setParent(currentNode);
					}
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		ArrayList<Node> explored = new ArrayList();
		frontier.push(root);
		while (!frontier.empty()) {
			Node temp = frontier.pop();
			List<Node> childrenNode = temp.getChildrenNodes();
			Collections.reverse(childrenNode);
			if (!explored.contains(temp)) {
				explored.add(temp);
				if (temp.getLabel().equals(goal)) {
					return temp;
				}
				for (Node chill : childrenNode) {
					if (!explored.contains(chill)) {
						frontier.push(chill);
						chill.setParent(temp);
					}
				}
				for (Node node : childrenNode) {
					if (node.getLabel() == start) {
						node.setParent(null);
						frontier.clear();
						explored.clear();
						frontier.push(node);
					}
				}
			}
		}
		return null;
	}

}
