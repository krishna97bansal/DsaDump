package com.dsa.DSADump.array;

import org.springframework.stereotype.Service;

@Service
public class Permutation {
    public void driver(){
        String s="abc";

        permute(s,0);
    }

    private void permute(String input,int level) {
        if(level>=input.length()){
            System.out.println(input);
            return;
        }

        for(int i = level ;i < input.length(); i++)
        {
            input=swap(input,level,i);
            permute(input,level+1);
            input= swap(input,level,i);
        }
    }

    private String swap(String input, int level, int i) {
        char temp;
        char[] charArray = input.toCharArray();
        temp = charArray[level] ;
        charArray[level] = charArray[i];
        charArray[i] = temp;
        return String.valueOf(charArray);
    }
}
