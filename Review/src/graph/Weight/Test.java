package graph.Weight;


import WeightedGraph.ReadGraph;
import WeightedGraph.SparseWeight_Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 14:54
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        SparseWeight_Graph<Double> sparseWeight_graph = new SparseWeight_Graph<>(8, false);
        String file = "F:\\Workspace\\Arithmetic\\Graph\\src\\WeightedGraph\\test1.txt";
        ReadGraph<Double> readGraph = new ReadGraph(sparseWeight_graph, file);

        Prim prim = new Prim(sparseWeight_graph);

        System.out.println(prim.getWeight());
        System.out.println("------------");
        Kruskal kruskal = new Kruskal(sparseWeight_graph);
        System.out.println(kruskal.getWeight());
    }
}
