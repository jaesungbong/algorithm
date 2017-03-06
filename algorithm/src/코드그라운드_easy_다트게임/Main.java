package 코드그라운드_easy_다트게임;

import java.util.Scanner;

public class Main {
	public static double tan9 = 0.15838444032;
	public static double tan27 = 0.32491969623;
	public static double tan45 = 1;
	public static double tan63 = 1.96261050551;
	public static double tan81 = 6.31375151468;

	public static int getScore(int x, int y) {
		if (x == 0 && y == 0) {
			return 1;
		} else if (x == 0 && y != 0) {
			if (y > 0) {
				return 20;
			} else {
				return 3;
			}
		} else if (y == 0 && x != 0) {
			if (x > 0) {
				return 9;
			} else {
				return 11;
			}
		} else {
			int angle = y / x;
			if (x > 0 && y > 0) { // 1 사분면
					if (angle < tan9) {
						return 6;
					} else if (angle < tan27) {
						return 13;
					} else if (angle < tan45) {
						return 4;
					} else if (angle < tan63) {
						return 18;
					} else if (angle < 81) {
						return 1;
					} else {
						return 20;
					}
				} else if (x < 0 && y > 0) { // 2 사분면
					if (angle > -tan9) {
						return 11;
					} else if (angle > -tan27) {
						return 14;
					} else if (angle > -tan45) {
						return 9;
					} else if (angle > -tan63) {
						return 12;
					} else if (angle > -tan81) {
						return 5;
					} else {
						return 20;
					}
				} else if (x < 0 && y < 0) { // 3 사분면
					if (angle < tan9) {
						return 11;
					} else if (angle < tan27) {
						return 8;
					} else if (angle < tan45) {
						return 16;
					} else if (angle < tan63) {
						return 7;
					} else if (angle < tan81) {
						return 19;
					} else {
						return 3;
					}
				} else if (x > 0 && y < 0) { // 4 사분면에 위치
					if (angle > -tan9) {
						return 9;
					} else if (angle > -tan27) {
						return 10;
					} else if (angle > -tan45) {
						return 15;
					} else if (angle > -tan63) {
						return 2;
					} else if (angle > -tan81) {
						return 17;
					} else {
						return 3;
					}
				}
		}
		return 0;
	}
	
	public static double getMulti(double score, double dist, int B, int C, int D, int E) {
		if (B < dist && dist < C) {
			return score * 3;
		} else if (C <dist && dist < C) {
			return score;
		} else if (D< dist && dist < E) {
			return score * 2;
		} else if (E < dist){
			return 0;
		} else {
			return score;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			int E = sc.nextInt();
			int N = sc.nextInt(); // 쏜 다트의 개수
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				int x = sc.nextInt(); // x좌표
				int y = sc.nextInt(); // y좌표
				double dist = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
				if (dist < A) {
					sum += 50;
				} else {
					sum += (int) getMulti(getScore(x, y), dist, B, C, D, E);
				}
			}
			System.out.println("Case #" + t);
			System.out.println(sum);
		}
		sc.close();
	}
}
