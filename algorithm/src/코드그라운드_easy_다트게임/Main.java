package 코드그라운드_easy_다트게임;

import java.util.Scanner;

public class Main {
	public static final int[] score = { 6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int A = sc.nextInt(); // BULL의 반지름
			int B = sc.nextInt(); // TRIPLE 시작 구간
			int C = sc.nextInt(); // TRIPLE 종료구간
			int D = sc.nextInt(); // DOUBLE 시작 구간
			int E = sc.nextInt(); // DOUBLE 종료 구간
			int N = sc.nextInt(); // 쏜 다트의 개수
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				int x = sc.nextInt(); // x좌표
				int y = sc.nextInt(); // y좌표
				double dist = Math.sqrt(x * x + y * y); // 다트에서 원점 까지의 거리
				if (dist < A) { // 원점까지 거리가 BULL의 반지름보다 작으면
					sum += 50; // 50점이 더해짐.
				} else {
					double radian = Math.atan2(y, (double) x); // 던진 다트의 라디안 각도.
					// angle는 육십분법(0 ~ 360)으로 표현한 x, y의 각도.
					double angle = Math.toDegrees(radian);
					if (y < 0) { // 3, 4분면은 음수로 나오기 때문에 360을 더하면 양수로 변환됨.
						angle += 360;
					}
					angle += 9;	angle %= 360;
					int s = score[(int) (angle / 18)];
					if (B < dist && dist < C) { // TRIPLE
						sum += 3 * s;
					} else if (D < dist && dist < E) { // DOUBLE
						sum += 2 * s;
					} else if (E < dist) { // OUT
						sum += 0;
					} else { // SINGLE
						sum += s;
					}
				}
			}
			System.out.println("Case #" + t);
			System.out.println(sum);
		}
		sc.close();
	}
}