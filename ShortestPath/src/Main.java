
import WeightedGraph.ReadGraph;
import WeightedGraph.SparseWeight_Graph;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-10
 * @Time: 21:46
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        SparseWeight_Graph sparse_graph = new SparseWeight_Graph(5, true);
        ReadGraph<Double> readGraph = new ReadGraph(sparse_graph, "F:\\Workspace\\Arithmetic\\ShortestPath\\src\\test1.txt");
        //Prim<Double> prime = new Prim<>(sparse_graph);
        //
        //Dijkstra<Double> dijkstra = new Dijkstra<>(sparse_graph, 0);
        //dijkstra.showPath(4);
        //System.out.println("-----");
        Bellman_Ford<Double> bellman_ford = new Bellman_Ford<>(sparse_graph, 0);
        if (bellman_ford.hasPath(4))
            bellman_ford.showPath(4);
        else
            System.out.println("没有路径");

    }
}
