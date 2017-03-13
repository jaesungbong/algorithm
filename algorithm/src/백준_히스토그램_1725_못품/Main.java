package 백준_히스토그램_1725_못품;

import java.util.Scanner;

public class Main {
	static int[] height = new int[100001];
	
//	int search(int idx) {
//		
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 히스토 그램의 가로 칸의 수
		height[1] = sc.nextInt(); //첫번째 높이
		int max = height[1]; //최대값
		for (int i = 2; i <= N; i++) {
			height[i] = sc.nextInt();
//			max = Math.max(max, search(i));
		}
		sc.close();
	}
}
