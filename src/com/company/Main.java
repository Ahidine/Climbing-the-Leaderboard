package com.company;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] rank = new int[scores.length];
        int [] result = new int[alice.length];

        for (int i = 0; i <scores.length ; i++) {
            if (i==0){
                rank[0]=1;
                continue;
            }
            if(scores[i]==scores[i-1]){
                rank[i]=rank[i-1];
            }
            else
                rank[i]=rank[i-1]+1;
        }
        for (int i = 0; i <alice.length ; i++) {
            if (alice[i]>scores[0])
                result[i]=1;
            else
            if (alice[i]<scores[scores.length-1])
                result[i]=rank[rank.length-1]+1;
            else
            {
                for (int j = 0; j < scores.length; j++) {
                    if (alice[i] >= scores[j]) {
                        result[i] = rank[j];
                        break;
                    }
                }
            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[] scores = {100 ,100 ,50 ,40 ,40 ,20 ,10};

        int[] alice = {5 ,25 ,50 ,120};

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }

    }
}
