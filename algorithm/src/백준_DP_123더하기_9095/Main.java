package 백준_DP_123더하기_9095;

import java.util.Scanner;

public class Main {
	static int[] fibonacci = new int[12];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while(testCase-- > 0) {
			int n = sc.nextInt();
			fibonacci[1] = 1;
			fibonacci[2] = 2;
			fibonacci[3] = 4;
			for (int i = 4; i <= 11; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3]; 
			}
			System.out.println(fibonacci[n]);
		}
		sc.close();
	}
}
