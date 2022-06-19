package com.company.graph.disjointset;

import java.util.HashSet;

public class Google_MostStoneRemovedWithSameRowOrColumn {
    int[] parent;
    int[] rank;
    public int removeStones(int[][] stones) {
        int l = stones.length;
        parent = new int[l];
        rank = new int[l];
        // every node is its own parent at first
        for(int i=0;i<l;i++) parent[i] = i;
        // create sets
        for(int i =0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i,j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<l;i++) {
            getParent(i); // path compression
            set.add(parent[i]);
        }
        return l-set.size();
    }

    public int getParent(int node){
        if(parent[node] == node) return node;
        parent[node] = getParent(parent[node]);
        return parent[node];
    }

    public void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(rank[b] > rank[a]){
            parent[a] = b;
            rank[b] += 1;
        }else{
            parent[b] = a;
            rank[a] += 1;
        }
    }
}
