package ai_lab_4_GBFS_AStar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());

		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {

			Node currentNode = frontier.poll();
			explored.add(currentNode);

			if (currentNode.getLabel().equals(goal))
				return currentNode;
			else {
				for (Edge e : currentNode.getChildren()) {
					Node childNode = e.getEnd();

					if (!explored.contains(e.getEnd()) && !frontier.contains(childNode)) {
						childNode.setG(currentNode.getG() + e.getWeight());
						childNode.setParent(currentNode);
						frontier.add(childNode);
					} else {
						for (Node nodeInFrontier : frontier)
							if (childNode.getH() <= nodeInFrontier.getH()) {
								childNode.setG(currentNode.getH() + e.getWeight());
								childNode.setParent(currentNode);
								nodeInFrontier = childNode;
							}
					}
				}

			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());

		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {

			Node currentNode = frontier.poll();
			explored.add(currentNode);

			if (currentNode.getLabel().equals(goal))
				return currentNode;
			else {
				for (Edge e : currentNode.getChildren()) {
					Node childNode = e.getEnd();

					if (!explored.contains(e.getEnd()) && !frontier.contains(childNode)) {
						childNode.setG(currentNode.getG() + e.getWeight());
						childNode.setParent(currentNode);
						frontier.add(childNode);
					} else {
						for (Node nodeInFrontier : frontier)
							if (childNode.getH() <= nodeInFrontier.getH()) {
								childNode.setG(currentNode.getH() + e.getWeight());
								childNode.setParent(currentNode);
								nodeInFrontier = childNode;
							}
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

	class NodeComparatorByHn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}

	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		boolean result;
		HashSet<Node> NodeList = findNodeList(root);
		for (Node child : NodeList) {
			Node temp = execute(child, goal);
			List<String> end = new ArrayList<String>();
			end.add(temp.getLabel());
			Node tmp;
			while ((tmp = temp.getParent()) != null) {

				end.add(tmp.getLabel());
				temp = tmp;
			}
			result = child.getH() <= (end.size() - 2);
			if (result == false)
				return false;
		}
		return true;
	}

	public HashSet<Node> findNodeList(Node root) {
		HashSet<Node> NodeList = new HashSet<>();
		NodeList.add(root);
		Node start = root;
		List<Node> children = start.getChildrenNodes();
		for (Node child : children) {
		}
		if (!children.isEmpty()) {
			NodeList.addAll(children);
			for (Node child : children) {
				findNodeList(child);
			}
		}
		return NodeList;
	}
}
