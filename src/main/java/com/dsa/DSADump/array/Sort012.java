package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

@Service
public class Sort012 {
    public void driver(){
        int a[]={2,1,0,1,1,0,0,2,1,0,1,1,0};
        int i=0,j=0,k=a.length-1;
        while(j<=k){
            if(a[j]==0){
                swap(a,i,j);
                i++;
                j++;

            }
            else if(a[j]==1){
                j++;
            }
            else{
                swap(a,j,k);
                k--;
            }
        }
        for(Integer o: a){
            System.out.print(o);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
