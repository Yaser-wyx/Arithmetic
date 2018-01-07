package myUnion_Find;

public interface Union_Find {
    int find(int p);

    boolean isConnected(int p, int q);

    void union(int p, int q);

}
