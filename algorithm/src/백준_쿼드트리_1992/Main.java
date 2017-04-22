package 백준_쿼드트리_1992;

import java.util.Scanner;

public class Main {
	static int dot[][]; // 영상 점

	static String compress(int startI, int startJ, int size) {
		boolean isCompress = true;
		for (int i = startI; i <= startI + size - 1; i++) { // 이 영역 전체를 압축 할 수 있는지
			for (int j = startJ; j <= startJ + size - 1; j++) {
				if (dot[startI][startJ] != dot[i][j]) { // 요소가 다르다면
					isCompress = false; // 압축은 불가능
					break;
				}
			}
		}
		if (isCompress) { // 전체 압축이 가능 하다면
			return dot[startI][startJ] + "";
		} else { // 불가능 하다면
			return "(" +
				compress(startI, startJ, size / 2) +
				compress(startI, startJ  + size / 2, size / 2) +
				compress(startI + size / 2, startJ, size / 2) +
				compress(startI + size / 2 , startJ + size / 2, size / 2) +
				")";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()); // 영상의 크기
		dot = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			char[] line = sc.nextLine().toCharArray();
			for (int j = 1; j <= n; j++) {
				dot[i][j] = Integer.parseInt(line[j - 1] + "");
			}
		}
		sc.close();
		String result = compress(1, 1, n);
		System.out.println(result);
	}
}