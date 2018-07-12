package org.yevheniy.ua;

/**
 * Simple implementation of Union-Find algorithm
 * N = 5
 * id[] = {0, 1, 2, 3, 4}
 * union(1,2)
 * id[] = {0, 2, 2, 3, 4}
 * union(2,3)
 * id[] = {0, 3, 3, 3, 4}
 * connected(1,2) = true
 * connected(3,4) = false
 */
public class SimpleUnionFind implements UninonFind {

    private final int[] id;

    public SimpleUnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
