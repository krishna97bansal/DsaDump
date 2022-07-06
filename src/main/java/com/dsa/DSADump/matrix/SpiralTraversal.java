package com.dsa.DSADump.matrix;

import org.springframework.stereotype.Service;

@Service
public class SpiralTraversal {
    public void driver(){
        int  a[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int rows=a.length;
        int cols=a[0].length;

        printSpiral(a,rows,cols);
    }

    private void printSpiral(int[][] a, int rows, int cols) {

        int rowStart=0,rowEnd=rows;
        int colStart=0, colEnd=cols;

        while(rowStart<rowEnd && colStart<colEnd){
            for(int i=colStart;i<colEnd;i++){
                System.out.print(a[rowStart][i]+" ");
            }
            rowStart++;

            for(int i=rowStart;i<rowEnd;i++){
                System.out.print(a[i][colEnd-1]+" ");
            }
            colEnd--;

            if(rowStart<rowEnd){
                for(int i=colEnd-1;i>=colStart;i--){
                    System.out.print(a[rowEnd-1][i]+" ");
                }
                rowEnd--;
            }
            if(colStart<colEnd){
                for(int i=rowEnd-1;i>=rowStart;i--){
                    System.out.print(a[i][colStart]+" ");
                }
                colStart++;
            }
        }

    }
}
