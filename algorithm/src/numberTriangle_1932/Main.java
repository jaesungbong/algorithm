package numberTriangle_1932;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n은 삼각형의 크기
		
		int[] sum = new int[(int)(Math.pow(2, n) - 1)];
		
		sum[0] = sc.nextInt();
		
		for (int i = 1; i < 6; i++ ) {
			sum[i] = sc.nextInt() + sum[(i - 1) / 2];
		}
		
		System.out.println(sum.length);
	}
}
