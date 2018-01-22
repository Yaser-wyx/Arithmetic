package graph.UnWeught;


import UnweightedGraph.ReadGraph;
import UnweightedGraph.Sparse_Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 10:39
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        String filename = "F:\\Workspace\\Arithmetic\\Graph\\src\\UnweightedGraph\\test2.txt";
        Sparse_Graph sparse_graph = new Sparse_Graph(8, false);
        ReadGraph readGraph = new ReadGraph(sparse_graph, filename);
        Path path = new Path(0, sparse_graph);
        path.showpath(2);
        path.showpath(7);
        path.showpath(3);
        System.out.println("----------------");
        ShortestPath shortestPath = new ShortestPath(sparse_graph, 0);
        shortestPath.show(2);
        shortestPath.show(3);

    }
}
