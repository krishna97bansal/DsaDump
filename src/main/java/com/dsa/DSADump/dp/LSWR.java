package com.dsa.DSADump.dp;

import org.springframework.stereotype.Service;

@Service
public class LSWR {
    public void driver(){
        String s="geeksforgeeks";
        String res="";
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            String temp=String.valueOf(s.charAt(i));

            if(res.contains(temp)){
                res=res.substring(res.indexOf(temp)+1);
            }
            res+=temp;
            max=Math.max(max,res.length());
        }
        System.out.println(max);
    }
}
