package 백준_generationsOfTribbles_9507;

import java.util.Scanner;

public class Main {
	static long[] fibonacci = new long[68]; //피보나치를 저장시킬 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 케이스 입력 받기
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		fibonacci[2] = 2;
		fibonacci[3] = 4;
		while (0 < t--) {
			int n = sc.nextInt(); //값 입력받기
			if (fibonacci[n] == 0) { //배열의 초기값은 0이므로
				for (int i = 4; i <= n; i++) {
					fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3] + fibonacci[i - 4];
				}
			}
			System.out.println(fibonacci[n]);
		}
	}
}
