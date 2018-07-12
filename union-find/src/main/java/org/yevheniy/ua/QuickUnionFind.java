package org.yevheniy.ua;

/**
 * Fast implementation of Union-Find algorithm based on trees
 * N = 5
 * id[] = {0, 1, 2, 3, 4}
 * union(3,2)
 * id[] = {0, 1, 2, 2, 4}
 * union(2,0)
 * id[] = {0, 1, 0, 2, 4}
 * union(4,0)
 * id[] = {0, 1, 0, 2, 0}
 * connected(0,3) = true
 * connected(3,4) = true
 * connected(3,1) = false
 */
public class QuickUnionFind implements UninonFind {

    private final int[] id;

    public QuickUnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
}
