package com;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
		 public static void main(String[] args) throws IOException {
		        Scanner in = new Scanner(System.in);
		        final String fileName = System.getenv("OUTPUT_PATH");
		        BufferedWriter bw = null;
		        if (fileName != null) {
		            bw = new BufferedWriter(new FileWriter(fileName));
		        }
		        else {
		            bw = new BufferedWriter(new OutputStreamWriter(System.out));
		        }

		        int res;
		        int n;
		        n = Integer.parseInt(in.nextLine().trim());

		        int a_size = 0;
		        a_size = Integer.parseInt(in.nextLine().trim());

		        int[] a = new int[a_size];
		        for(int i = 0; i < a_size; i++) {
		            int a_item;
		            a_item = Integer.parseInt(in.nextLine().trim());
		            a[i] = a_item;
		        }

		        res = countUneatenLeaves(n, a);
		        bw.write(String.valueOf(res));
		        bw.newLine();

		        bw.close();
		    }
	    	
		 public static int countUneatenLeaves(int N, int[] A) {
				int uneatenLeaves = 0;
				int ASize = A.length;
				int countEaten = 0;

				HashMap<Integer,Integer> positionEatenHash = new HashMap<Integer,Integer>();
				for( int i = 0; i < ASize; i++ ){
					int catervalue = A[i];
					for(int j = 1; j*catervalue <= N; j++){
						if(!positionEatenHash.containsKey(A[i]*j)){
							positionEatenHash.put(A[i]*j, 1);
							countEaten++;
						}
					}
				}
				uneatenLeaves = N - countEaten;
				return uneatenLeaves;
			}
}