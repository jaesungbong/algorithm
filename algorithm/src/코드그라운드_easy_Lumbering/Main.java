package 코드그라운드_easy_Lumbering;
//https://www.codeground.org/practice/practiceProbView.do?probId=35

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int N = sc.nextInt(); // 트리의 수, 개월
			int[] treesHeight = new int[N + 1]; //각 트리의 높이 배열
			for (int i = 1; i <= N; i++) {
				treesHeight[i] = sc.nextInt();
			}
			long sum = 0; // 합
			int lasersHeight = 100000;
			for (int i = 0; i < N; i++) { // 가장 낮은 높이의 레이저의 높이 구하기
				int height = sc.nextInt() - i;
				lasersHeight = Math.min(height, lasersHeight);
			}
			for (int i = 1; i <= N; i++) { // 벌목한 트리 구하기
				sum += (treesHeight[i] > lasersHeight) ? treesHeight[i] - lasersHeight : 0; 
			}
			System.out.println("Case #" + t);
			System.out.println(sum);
		}
		sc.close();
	}
}