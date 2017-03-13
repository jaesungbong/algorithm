package 백준_피보나치함수_1003;

import java.util.Scanner;

public class Main {
	static int[] sum = new int[2]; //sum[0] 은 0의 출력 개수, sum[1]은 1의 출력 개수를 저장
	
	static int fibonacci(int n) { //출력 대신 개수를 저장
	    if (n==0) {
	        sum[0] += 1;
	        return 0;
	    } else if (n==1) {
	        sum[1] += 1;
	        return 1;
	    } else {
	        return fibonacci(n - 1) + fibonacci(n - 2);
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i =0; i < t; i++) {
			sum[0] = 0;
			sum[1] = 0;
			int n = sc.nextInt();
			fibonacci(n);
			System.out.println(sum[0] + " " + sum[1]);
		}
	}
}
