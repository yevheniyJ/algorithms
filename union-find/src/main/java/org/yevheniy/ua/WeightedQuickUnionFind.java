package org.yevheniy.ua;

/**
 * Fast implementation of Union-Find algorithm based on trees
 * Same as {@link QuickUnionFind} but during tree merge
 * decision about who will be child (sub) tree is based on "weight" (count of nodes in tree).
 * Therefore we avoid tall trees and give better scaling for large sizes.
 */
public class WeightedQuickUnionFind implements UninonFind {

    private final int[] id;
    //size of nodes in the tree
    private final int[] sz;

    public WeightedQuickUnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
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
