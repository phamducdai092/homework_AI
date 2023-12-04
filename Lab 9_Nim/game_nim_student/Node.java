package game_nim_student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> nodeChill = new ArrayList<>();

		for (int i = 0; i < data.size(); i++) {
			int cur = data.get(i);
			for (int j = 1; j <= cur / 2; j++) {
				if (cur - j != j) {
					Node node = new Node();
					node.add(j);
					node.add(cur - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i)
							node.add(data.get(k));
					}
					if (!nodeChill.contains(node)) {
						nodeChill.add(node);
					}
				}
			}

		}
//  System.out.println(nodeChill);
		return nodeChill;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		Collections.sort(data, DESCOMPARATOR);
		return data.get(0) < 3;
	}

	public static final Comparator<Integer> DESCOMPARATOR=new Comparator<Integer>(){

	@Override public int compare(Integer o1,Integer o2){return o2.compareTo(o1);}};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
