package com.dsa.DSADump.matrix;

import org.springframework.stereotype.Service;

/*
We have matrix with X and O, so we have to convert all O surrounded by X to X only.
X X X O
X O O X
X O X X
X X X O

-->

X X X O
X X X X
X X X X
X X X O

 */
@Service
public class TurnCell {

    public void driver() {
        char[][] mat = {{'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'O'}};

        int rows = mat.length;
        int cols = mat[0].length;

        handler(mat,rows,cols);
        for(int i=0;i<rows;i++){
            for(int j= 0;j<cols;j++){
                System.out.print(mat[i][j]+" ");
            }
        System.out.println();}
    }

    private void handler(char[][] mat, int rows, int cols) {
        for(int i=0;i<rows;i++){
            matDfs(mat,i,0);
            matDfs(mat,i,cols-1);
        }

        for(int i=1;i<cols-1;i++){
            matDfs(mat,0,i);
            matDfs(mat,rows-1,i);
        }

        for(int i=0;i<rows;i++){
            for(int j= 0;j<cols;j++){

                if(mat[i][j]=='O')
                    mat[i][j]='X';
                if(mat[i][j]=='*')
                    mat[i][j]='O';
            }
        }
    }

    private void matDfs(char[][] mat, int row, int col) {
        if(row<0||col<0||row>=mat.length||col>=mat[0].length||mat[row][col]!='O')
            return;
        mat[row][col]='*';
        matDfs(mat,row,col+1);
        matDfs(mat,row,col-1);
        matDfs(mat,row+1,col);
        matDfs(mat,row-1,col);
    }
}
