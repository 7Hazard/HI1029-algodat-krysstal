package ten1606;

import java.util.LinkedList;

public class uppg4_svar {

    //i denna implementation h�r ett edge-object till en nod (den vars nods lista den ligger i).
    //den representerar d� b�gen fr�n denna nod till connectedNode och har vikten weight
    private static class Edge{
        private int connectedNode, weight;
        public Edge(int cN,int w){
            connectedNode = cN;
            weight = w;
        }
    }

    public static void main(String[] args) {
        int X = Integer.MAX_VALUE;
        LinkedList<Edge>[] adjacencyList =new LinkedList[8];

        //h�r �r grafen fr�n provet h�rdkodad (A=0, B=1, C=2, D=3, E=4, F=5, G=6, H=7)
        //din kod ska naturligtvis klara godtycklig graf representerad p� samma s�tt
        adjacencyList[0] = new LinkedList<Edge>();//lista med A's b�gar
        adjacencyList[0].add(new Edge(1,2));//b�gen fr�n A till B har vikten 2
        adjacencyList[0].add(new Edge(5,1));//b�gen fr�n A till F har vikten 1
        adjacencyList[1] = new LinkedList<Edge>();//lista med B's b�gar
        adjacencyList[1].add(new Edge(0,2));//b�gen fr�n B till A har vikten 2
        adjacencyList[1].add(new Edge(2,2));//osv
        adjacencyList[1].add(new Edge(3,2));
        adjacencyList[1].add(new Edge(4,4));
        adjacencyList[2] = new LinkedList<Edge>();
        adjacencyList[2].add(new Edge(1,2));
        adjacencyList[2].add(new Edge(4,3));
        adjacencyList[2].add(new Edge(7,1));
        adjacencyList[3] = new LinkedList<Edge>();
        adjacencyList[3].add(new Edge(1,2));
        adjacencyList[3].add(new Edge(4,3));
        adjacencyList[3].add(new Edge(5,1));
        adjacencyList[4] = new LinkedList<Edge>();
        adjacencyList[4].add(new Edge(1,4));
        adjacencyList[4].add(new Edge(2,3));
        adjacencyList[4].add(new Edge(3,3));
        adjacencyList[4].add(new Edge(6,7));
        adjacencyList[5] = new LinkedList<Edge>();
        adjacencyList[5].add(new Edge(0,1));
        adjacencyList[5].add(new Edge(3,1));
        adjacencyList[5].add(new Edge(6,5));
        adjacencyList[6] = new LinkedList<Edge>();
        adjacencyList[6].add(new Edge(4,7));
        adjacencyList[6].add(new Edge(5,5));
        adjacencyList[6].add(new Edge(7,6));
        adjacencyList[7] = new LinkedList<Edge>();
        adjacencyList[7].add(new Edge(2,1));
        adjacencyList[7].add(new Edge(6,6));
        System.out.println(prim(adjacencyList));

        //f�rbindelsematris - anv�nd denna om du inte klarar f�rbindelselistan f�r maximalt 2p
//        int[][] w = {
//                {	X, 2, X, X, X, 1, X, X},
//                {	2, X, 2, 2, 4, X, X, X},
//                {	X, 2, X, X, 3, X, X, 1},
//                {	X, 2, X, X, 3, 1, X, X},
//                {	X, 4, 3, 3, X, X, 7, X},
//                {	1, X, X, 1, X, X, 5, X},
//                {	X, X, X, X, 7, 5, X, 6},
//                {	X, X, 1, X, X, X, 6, X}};
//        System.out.println(primMatrix(w));
//        int[][] w4 = {
//                {	X, 2, X, X, X, 8, X, X},
//                {	2, X, 2, 2, 4, X, X, X},
//                {	X, 2, X, X, 3, X, X, 1},
//                {	X, 2, X, X, 3, 1, X, X},
//                {	X, 4, 3, 3, X, X, 7, X},
//                {	8, X, X, 1, X, X, 5, X},
//                {	X, X, X, X, 7, 5, X, 6},
//                {	X, X, 1, X, X, X, 6, X}};
//        System.out.println(primMatrix(w4));
//        int[][] w2 = {
//                {	X, 3, 4, 5, 6},
//                {	3, X, 6, 5, 6},
//                {	4, 6, X, 3, 4},
//                {	5, 5, 3, X, 2},
//                {	6, 6, 4, 2, X}};
//        System.out.println(primMatrix(w2));
//        int[][] w3 = {
//                {X, 2, X, X, X, 1, X, X},
//                {2, X, 2, 2, 4, X, X, X},
//                {X, 2, X, X, 3, X, X, 1},
//                {X, 2, X, X, 4, 1, X, X},
//                {X, 4, 3, 4, X, X, 7, X},
//                {1, X, X, 1, X, X, 5, X},
//                {X, X, X, X, 7, 5, X, 6},
//                {X, X, 1, X, X, X, 6, X}};
//        int[][] w5 = {
//                {	X, 1, 9, X},
//                {	1, X, X, 9},
//                {	9, X, X, 1},
//                {	X, 9, 1, X}};
//
//        int[][] w6 ={{X, 5, X, 3},
//                {5, X, 2, 1},
//                {X, 2, X, X},
//                {3, 1, X, X}};
//
//        int[][] w7 = {
//                {	X, 1, 1, X},
//                {	1, X, 1, 2},
//                {	1, 1, X, 2},
//                {	X, 2, 2, X}};
//        System.out.println(primMatrix(w7));

    }

    private static int prim(LinkedList<Edge>[] adjacencyList) {
        boolean[] spanningTree = new boolean[adjacencyList.length];
        int totalWeight = 0;
        spanningTree[0]=true;
        for(int j=0;j<spanningTree.length-1;j++){
            int nextToConnect=-1;
            int nextWeight=Integer.MAX_VALUE;
            for(int i=0;i<spanningTree.length;i++){
                if(spanningTree[i])
                    for(Edge e: adjacencyList[i])
                        if(e.weight<nextWeight&&!spanningTree[e.connectedNode]){
                            nextToConnect = e.connectedNode;
                            nextWeight = e.weight;
                        }
            }
            totalWeight+=nextWeight;
            spanningTree[nextToConnect]=true;
        }
        return totalWeight;
    }


    private static int primMatrix(int[][] w) {
        boolean[] spanningTree = new boolean[w[0].length];
        int totalWeight = 0;
        spanningTree[0]=true;

        for(int i=1;i<spanningTree.length;i++){
            int nextToConnect=-1;
            int nextWeight=Integer.MAX_VALUE;
            for(int connectTo=0;connectTo<spanningTree.length;connectTo++){
                if(spanningTree[connectTo]){
                    for(int connect=0;connect<spanningTree.length;connect++){
                        if(!spanningTree[connect]){
                            if(w[connect][connectTo]<nextWeight){
                                nextWeight=w[connect][connectTo];
                                nextToConnect=connect;
                            }
                        }
                    }
                }
            }
            spanningTree[nextToConnect]=true;
            totalWeight+=nextWeight;
            System.out.println(nextToConnect+","+nextWeight);
        }
        return totalWeight;
    }
}