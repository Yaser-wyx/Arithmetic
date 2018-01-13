package WeightedGraph;

import MST.Krusk;
import MST.LazyPrim;
import MST.Prim;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-09
 * @Time: 17:31
 * To change this template use File | Settings | File Templates.
 * @desc Test
 */
public class Main {
    public static void main(String[] args) {
        SparseWeight_Graph<Double> sparseWeight_graph = new SparseWeight_Graph<>(6, false);
        String file = "F:\\Workspace\\Arithmetic\\Graph\\src\\WeightedGraph\\test3.txt";
        ReadGraph<Double> readGraph = new ReadGraph(sparseWeight_graph, file);

        LazyPrim<Double> lazyPrim = new LazyPrim<>(sparseWeight_graph);
        System.out.println(lazyPrim.getWeight());
        for (Edge<Double> edge : lazyPrim.getMst()) {
            System.out.println(edge);

        }

        Prim<Double> prim = new Prim<>(sparseWeight_graph);
        System.out.println(prim.getWeight());

        Krusk<Double> krusk = new Krusk<>(sparseWeight_graph);
        System.out.println(krusk.getWeight());


    }
}
