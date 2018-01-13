package WeightedGraph;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-09
 * @Time: 16:36
 * To change this template use File | Settings | File Templates.
 * @desc 有权图的边
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {
    private int v, w;//两个顶点
    private Weight weight;//边的权值

    public Edge(int v, int w, Weight weight) {//初始化
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge) {//初始化
        this.v = edge.v;
        this.w = edge.w;
        this.weight = edge.weight;

    }

    public int getV() {//获取一个顶点
        return v;
    }

    public int getW() {//获取另一个顶点
        return w;
    }

    public Edge() {//无参构造器
    }


    public int other(int x) {//给定一个顶点，返回另一个顶点
        assert x == v || x == w;
        return x == this.v ? this.w : this.v;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                " ->  w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {//比较两条边
        if (this.weight.compareTo(o.weight) > 0) {
            return 1;
        } else if (this.weight.compareTo(o.weight) < 0) {
            return -1;
        } else {
            return 0;
        }

    }

    public Weight getWeight() {//获取该边的权值
        return weight;
    }
}
