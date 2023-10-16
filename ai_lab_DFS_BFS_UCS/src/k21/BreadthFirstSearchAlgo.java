/**
 * 
 */
package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {

			Node currentNode = frontier.poll();

			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			} else {
				List<Edge> children = currentNode.getChildren();
				for (Edge edge : children) {
					if (!frontier.contains(edge.getEnd()) && !explored.contains(edge.getEnd())) {
						frontier.add(edge.getEnd());
						explored.add(edge.getEnd());
						edge.getEnd().setParent(currentNode);
					}
				}
			}
		}
		return null;
		
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {

			Node currentNode = frontier.poll();

			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			} else {
				List<Edge> children = currentNode.getChildren();
				for (Edge edge : children) {
					if (!frontier.contains(edge.getEnd()) && !explored.contains(edge.getEnd())) {
						frontier.add(edge.getEnd());
						explored.add(edge.getEnd());
						edge.getEnd().setParent(currentNode);
					}
				}
				for (Node node : currentNode.getChildrenNodes()) {
					if (node.getLabel() == start) {
						node.setParent(null);
						frontier.clear();
						explored.clear();
						frontier.add(node);
					}
				}
			}
		}
		return null;
	}

	
	
}
