package com.company;

public class KadaneContigousSubarrayWithLargestSum {
    public int process(int[] a){
        int max = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for(int i=0; i<a.length;i++){
            maxTillNow = maxTillNow + a[i];
            max = Math.max(max, maxTillNow);
            if(maxTillNow < 0)
                maxTillNow = 0;
        }
        return max;
    }
}
