package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

@Service

public class SearchInrotatedSortedArray {
    public void driver(){
        int a[]={ 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int key=3;
        System.out.println(a[find(a,0,a.length-1,key)]);
    }

    private int find(int[] a, int i, int j, int key) {
        while(i<=j){
            int med=(i+j)/2;
            if(a[med]==key)
                return med;
            if(a[i]<=a[med]){
                if(key>=a[i] && key<=a[med])
                    j=med-1;
                else
                    i=med+1;
            }
            else{
                if(key>=a[med] && key<=a[j])
                    i=med+1;
                else
                    j=med-1;
            }
        }

        return -1;
    }
}
