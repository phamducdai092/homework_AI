package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCostSearchAlgo implements ISearchAlgo {

	double pathCost = 0;

	@Override
	public Node execute(Node root, String goal) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		ArrayList<Node> explored = new ArrayList<Node>();

		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge edge : children) {
					double pathCost = current.getPathCost() + edge.getWeight();
					Node end = edge.getEnd();
					if (!frontier.contains(end) && !explored.contains(end)) {
						frontier.add(end);
						end.setPathCost(pathCost);
						end.setParent(current);
					} else if (frontier.contains(end) && end.getPathCost() > pathCost) {
						end.setPathCost(pathCost);
						end.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		Set<Node> explored = new HashSet<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node temp = frontier.poll();
			if (temp.getLabel().equals(goal)) {
				return temp;
			} else {
				explored.add(temp);
				List<Edge> children = temp.getChildren();
				for (Edge chill : children) {
					Node n = chill.getEnd();
					double t = (temp.getPathCost() + chill.getWeight());
					if (!frontier.contains(n) && !explored.contains(n)) {
						frontier.add(n);
						n.setParent(temp);
						n.setPathCost(t);
					} else if (n.getPathCost() < (t)) {
						n.setParent(temp);
						n.setPathCost(t);
					}
				}
				for (Node node : temp.getChildrenNodes()) {
					if (node.getLabel() == start) {
						node.setParent(null);
						frontier.clear();
						explored.clear();
						frontier.add(node);
						node.setPathCost(node.getPathCost() + temp.getPathCost());
					}
				}
			}
		}
		return null;
	}

	class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			int re = Double.compare(o1.getPathCost(), o2.getPathCost());
			if (re == 0) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
			return re;
		}

	}

}
