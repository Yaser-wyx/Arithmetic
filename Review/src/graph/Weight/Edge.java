package graph.Weight;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-16
 * @Time: 12:00
 * To change this template use File | Settings | File Templates.
 * @desc 有权图的边
 */
public class Edge<T> {
    private int v;
    private int w;
    private double weight;//权值

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Edge edge) {
        this.v = edge.v;
        this.w = edge.w;
        this.weight = edge.weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    public int getOther(int v) {
        return v == this.v ? this.w : this.v;
    }
}
