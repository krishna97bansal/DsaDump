package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

@Service
public class Sort01 {
    public void driver(){
        int a[]={1,1,0,0,0,1,0,1,0};
        int i=0,j=a.length-1;
        while(i<=j){
            if(a[i]==0){
                i++;
            }
            else{
                swap(a,i,j);
                j--;
            }
        }
        for(Integer k: a){
            System.out.print(k);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
