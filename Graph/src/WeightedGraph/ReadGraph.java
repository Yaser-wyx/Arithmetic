package WeightedGraph;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-07
 * @Time: 20:48
 * To change this template use File | Settings | File Templates.
 * @desc graph的辅助类
 */
public class ReadGraph<Weight extends Number & Comparable> {
    private Scanner scanner;

    public ReadGraph(WeightGraph<Weight> graph, String filename) {
        readfile(filename);
        int VertexNum = scanner.nextInt();
        if (VertexNum < 0) {
            throw new IllegalArgumentException("number of vertex must be bigger than zero!");
        }
        assert VertexNum == graph.getVertexNum();

        int edgeNum = scanner.nextInt();
        if (edgeNum < 0) {
            throw new IllegalArgumentException("number of edge must be bigger than zero!");
        }
        for (int i = 0; i < edgeNum; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            Weight weight = (Weight) (Object) scanner.nextDouble();
            assert v >= 0 && v < VertexNum;
            assert w >= 0 && w < VertexNum;

            graph.addEdge(new Edge(v, w, weight));
        }

    }

    private void readfile(String filename) {
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), "utf-8");
                scanner.useLocale(Locale.ENGLISH);

            } else {
                throw new IllegalArgumentException(filename + " is not exist!");
            }
        } catch (IOException io) {
            throw new IllegalArgumentException(filename + " can't open!");
        }


    }
}
