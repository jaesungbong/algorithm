package 코드그라운드_easy_Lumbering_못품;
//https://www.codeground.org/practice/practiceProbView.do?probId=35

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int N = sc.nextInt(); // 트리의 수, 개월
			int[] treesHeight = new int[N + 1];
			for (int i = 1; i <= N; i++) { // 트리의 높이
				treesHeight[i] = sc.nextInt() + (N - 1);
			}
			int sum = 0; // 합
			int lasersHeight = 100000;
			for (int i = 0; i < N; i++) { // 달
				int height = sc.nextInt();
				lasersHeight = Math.min(height, lasersHeight);
			}
			for (int i = 1; i <= N; i++) { // 트리의 높이
				sum += Math.max(treesHeight[i] - lasersHeight, 0);
			}
			System.out.println("Case #" + t);
			System.out.println(sum);
		}
		sc.close();
	}
}