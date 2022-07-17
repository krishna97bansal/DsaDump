package com.dsa.DSADump.dp;

import org.springframework.stereotype.Service;

@Service
public class LCS {
    public void driver(){
        String a="AGGTAB";
        String b="GXTXAYB";

        System.out.println(lcs(a,b,0,0));
    }

    private int lcs(String a, String b, int i, int j) {
        if(i>a.length()-1 || j>b.length()-1)
            return 0;

        if(a.charAt(i)==b.charAt(j))
            return 1+lcs(a,b,i+1,j+1);

        return Math.max(lcs(a,b,i+1,j),lcs(a,b,i,j+1));
    }
}
