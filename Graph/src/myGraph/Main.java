package myGraph;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 20:35
 * To change this template use File | Settings | File Templates.
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        String filename = "F:\\Workspace\\Arithmetic\\Graph\\src\\myGraph\\test2.txt";
        Sparse_Graph sparse_graph = new Sparse_Graph(13, false);
        ReadGraph readGraph = new ReadGraph(sparse_graph, filename);
        Path path = new Path(sparse_graph);
        path.showpath(0, 2);
        path.showpath(7, 3);
        path.showpath(0, 7);
        path.showpath(3, 7);

        System.out.println("------------");
        ShortestPath shortestPath = new ShortestPath(sparse_graph);
        shortestPath.showPath(7, 3);
        shortestPath.showPath(3, 7);
        System.out.println(shortestPath.MinLength(5,3));
        shortestPath.showPath(5, 7);
        shortestPath.showPath(5, 3);


    }

    void test1() {
        String filename = "F:\\Workspace\\Arithmetic\\Graph\\src\\myGraph\\test1.txt";
        Sparse_Graph sparse_graph = new Sparse_Graph(13, false);
        ReadGraph readGraph = new ReadGraph(sparse_graph, filename);
        System.out.println("test1 in sparse_graph:");
        sparse_graph.show();

        Component component = new Component(sparse_graph);
        System.out.println("该图的联通分量为：" + component.getCount());
        System.out.println("--------------------------------");
        Dense_Graph dense_graph = new Dense_Graph(13, false);
        readGraph = new ReadGraph(dense_graph, filename);
        System.out.println("test1 in dense_graph:");
        dense_graph.show();
        component = new Component(dense_graph);
        System.out.println("该图的联通分量为：" + component.getCount());
        System.out.println(component.isConnected(0, 7));
    }
}
