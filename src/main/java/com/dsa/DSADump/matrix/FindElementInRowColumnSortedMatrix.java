package com.dsa.DSADump.matrix;

import org.springframework.stereotype.Service;

@Service
public class FindElementInRowColumnSortedMatrix {

    public void driver(){
        int  a[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
        };
        int rows=a.length;
        int cols=a[0].length;

       System.out.println(find(a,rows,cols,10));
}

    private boolean find(int[][] a, int rows, int cols,int key) {
        int i=0,j=cols-1;
        while(i<rows && j>=0){
            if(a[i][j]==key){
                System.out.println(i+" "+j);
                return true;
            }
           else if(a[i][j]>key){
               j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
    }
