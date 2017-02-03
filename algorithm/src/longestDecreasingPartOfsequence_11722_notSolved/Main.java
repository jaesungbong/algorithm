package longestDecreasingPartOfsequence_11722_notSolved;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lengthOfA = sc.nextInt(); // 수열 a의 길이
		int[] a = new int[lengthOfA + 1]; //수열 a 선언
		for (int i = 1; i <= lengthOfA; i++) {
			a[i] = sc.nextInt(); //수열 초기화
		}
		sc.close();
		
		ArrayList<Integer>[] subs = (ArrayList<Integer>[]) new ArrayList[lengthOfA]; // 수열들의 차를 저장하기위한 arrayList
        for (int i=1; i < lengthOfA; i++) {
            subs[i] = new ArrayList<Integer>();
        }
        
        for (int i = 1; i < a.length; i++) {
        	for (int j = i + 1; j < a.length; j++) {
        		if (a[i] - a[j] > 0) {
        			subs[i].add(a[i] - a[j]);
        		}
        	}
        }
        
        for (int i = 1; i < a.length - 1; i++) {
        	System.out.println(subs[i].toString());
        }
	}
}
