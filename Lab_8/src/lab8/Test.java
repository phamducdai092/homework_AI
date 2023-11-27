package lab8;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D", 0);
		Node E = new Node("E");
		Node K = new Node("K");
		Node F = new Node("F");
		Node M = new Node("M");
		Node O = new Node("O");
		Node J = new Node("J");
		
		Node G = new Node("G", -5);
		Node H = new Node("H", 3);
		Node I = new Node("I", 8);
		Node L = new Node("L", 2);
		Node N = new Node("N", 4);
		Node P = new Node("P", 9);
		Node Q = new Node("Q", -6);
		Node R = new Node("R", 0);
		Node S = new Node("S", 3);
		Node T = new Node("T", 5);
		Node U = new Node("U", -7);
		Node V = new Node("V", -9);
		Node W = new Node("W", -3);
		Node X = new Node("X", -5);
		
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);
		
		B.addChild(F);
		B.addChild(G);
		
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		
		E.addChild(K);
		E.addChild(L);
		E.addChild(M);
		
		F.addChild(N);
		F.addChild(O);
		
		J.addChild(P);
		J.addChild(Q);
		J.addChild(R);
		
		K.addChild(S);
		K.addChild(T);
		
		M.addChild(U);
		M.addChild(V);
		
		O.addChild(W);
		O.addChild(X);
		
//		ISearchAlgo algo = new MiniMaxSearchAlgo();
//		algo.execute(A);
//		System.out.println("value cua A la: " + A.getValue());
//		System.out.println();
		
		ISearchAlgo algo2 = new AlphaBetaSearchAlgo();
		algo2.execute(A);
		System.out.println("value cua A la: " + A.getValue());
		System.out.println();
//		
//		ISearchAlgo algo3 = new AlphaBetaRightToLeftSearchAlgo();
//		algo3.execute(A);
//		System.out.println("value cua A la: " + A.getValue());
		
	}

}