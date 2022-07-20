package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

@Service
public class Subsequence {
    public void driver(){
        String s="abc";

        subseq(s,"");
    }

    private void subseq(String input, String res) {
        if(input.length()==0){
            System.out.println(res);
        return;
        }

        subseq(input.substring(1),res+input.charAt(0));
        subseq(input.substring(1),res);

    }
}
