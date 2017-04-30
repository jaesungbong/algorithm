package 코드그라운드_normal1_회로판위의배터리_못품;

import java.util.Scanner;
//https://www.codeground.org/practice/practiceProbView.do?probId=14

public class Main {
	static int[][] vertex = new int[101][4];
	static int[][] center = new int[101][2];
	static final int x = 0, y = 1;
	static final int x1 = 0, y1 = 1, x2 = 2, y2 = 3;
	
//	static int[] getCenter(int vertex[]) {
//		int[] ret = new int[2];
//		
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 선분의 개수
		for (int i = 1; i <= n; i++) {
			vertex[i][x1] = sc.nextInt();
			vertex[i][y1] = sc.nextInt();
			vertex[i][x2] = sc.nextInt();
			vertex[i][y2] = sc.nextInt();
		}
		double centerX = 100000000;
		double centerY = 100000000;
		for (int i = 2; i <= n; i++) {
//			center[i][x] = getCenter(vertex[i])[0];
//			center[i][y] = getCenter(vertex[i])[1];
		}
		System.out.println(centerX);
		System.out.println(centerY);
		sc.close();
	}
}
