package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
/*
Approach is simple just create priorityqueue of k size
1. for k largest use ascending queue so the element we need remain at top
 */
@Service
public class KLargest {
    public void driver(){
        int a[]={7,8,0,1,2,6};
        int k=2;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            if(i<k)
                pq.add(a[i]);

            else{
                if(a[i]>pq.peek())
                {
                    pq.poll();
                    pq.add(a[i]);
                }
            }

        }
        System.out.println(pq.peek());
    }
}
