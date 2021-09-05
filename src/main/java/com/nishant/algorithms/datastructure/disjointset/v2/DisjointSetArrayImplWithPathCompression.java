package com.nishant.algorithms.datastructure.disjointset.v2;

import com.nishant.algorithms.datastructure.disjointset.v1.DisjointSetArrayImpl;

public class DisjointSetArrayImplWithPathCompression {


    private int size;
    private int[] table;
    private int[] sizeTable;
    private int numberOfComponents;

    public DisjointSetArrayImplWithPathCompression() {
        this(10);
    }

    public DisjointSetArrayImplWithPathCompression(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size canot be less than equal to zero.");
        }
        this.size = size;
        this.numberOfComponents = size;
        this.table = new int[this.size];
        this.sizeTable = new int[this.size];
        for (int i = 0; i < size; i++) {
            this.table[i] = i; //Link to itself (self root)
            this.sizeTable[i] = 1;
        }
    }

    /**
     * component identifier for p (0 to N-1)
     *
     * @param p
     * @return
     */
    public int recurssiveFind(int p) {
        if (table[p] == p) {
            return p;
        }
        return recurssiveFind(table[p]);
    }

    /**
     * component identifier for p (0 to N-1)
     *
     * @param p
     * @return
     */
    public int find(int p) {
        int root = this.table[p];
        while (this.table[root] != root) {
            root = this.table[root];
        }

        //path compression algorithm
        while(root != this.table[p]){
            int index = this.table[p];
            this.table[p] = root;
            p = index;
        }

        return root;
    }

    /**
     * add connection between p and q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // These elements are already present in the same group.
        if (rootP == rootQ) {
            return;
        }

        //Merge two components/sets together
        //Merge smaller set to larger set.
        if (this.sizeTable[rootP] < this.sizeTable[rootQ]) {
            this.sizeTable[rootQ] = this.sizeTable[rootQ] + this.sizeTable[rootP];
            this.table[rootP] = rootQ;
        } else {
            this.sizeTable[rootP] = this.sizeTable[rootQ] + this.sizeTable[rootP];
            this.table[rootQ] = rootP;
        }
        numberOfComponents--;
    }

    /**
     * @param p
     * @param q
     * @return return if p qnd q are connected or not. That means If root of p and q are same or not
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @return number of components
     */
    public int count() {
        return numberOfComponents;
    }

    public static void main(String[] args) {
        DisjointSetArrayImplWithPathCompression uf = new DisjointSetArrayImplWithPathCompression(5);

        uf.union(0, 1);
        uf.union(1, 0);
        uf.union(1, 2);
        uf.union(0, 2);
        uf.union(2, 1);
        uf.union(3, 4);
        uf.union(4, 3);
        uf.union(1, 3);
        uf.union(4, 0);

    }


}
