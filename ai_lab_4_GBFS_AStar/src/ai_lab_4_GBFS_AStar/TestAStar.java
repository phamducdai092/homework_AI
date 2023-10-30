package ai_lab_4_GBFS_AStar;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
		System.out.println("Astar Root -> Goal");
		IInformedSearchAlgo aStar = new AStarSearchAlgo();
		Node res = aStar.execute(s, g.getLabel());
		boolean isAmisibleH = aStar.isAdmissibleH(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res)+"\nCost: "+ res.getG());
		System.out.println("AmissibleH");
		System.out.println(isAmisibleH);
		
		System.out.println("\nAstar Start -> Goal");
		Node res1 = aStar.execute(s, d.getLabel(), g.getLabel());
		System.out.println(NodeUtils.printPath(res1)+"\nCost: "+ res1.getG());
		
		System.out.println("\nGreedy Search");
		IInformedSearchAlgo greedyS = new GreedyBestFirstSearchAlgo();
		Node res2 = greedyS.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res2)+"\nCost: "+ res2.getG());
	}
}
