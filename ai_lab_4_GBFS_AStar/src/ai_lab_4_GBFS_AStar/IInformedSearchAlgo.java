package ai_lab_4_GBFS_AStar;

public interface IInformedSearchAlgo {
	public Node execute(Node root, String goal);

	public Node execute(Node root, String start, String goal);
	
	public boolean isAdmissibleH(Node root, String goal);
}
