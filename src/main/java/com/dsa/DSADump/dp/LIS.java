package com.dsa.DSADump.dp;

import org.springframework.stereotype.Service;

@Service
public class LIS {
    public void driver(){
        int a[]={10,22,9,33,21,39,41,60,80,1};
        int rs=Integer.MIN_VALUE;
        int dp[]=new int[a.length];
        dp[0]=1;
        for(int i=0;i<a.length;i++)
        {
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            rs=Math.max(rs,dp[i]);
        }
    }
}
