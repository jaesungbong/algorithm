package 백준_최대곱_1500;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); // 정수 S
		int k = sc.nextInt(); // 합이 S인 K개의 정수
		int q = s / k; // s 를 k 로 나눈 몫
		int r = s % k; // s 를 k로 나눈 나머지
		long max = 1;
		for (int i = 1; i <= k; i++) {
			if(i <= r) { //나머지 갯수만큼 +1
				max *= (q + 1);
			} else { //
				max *= q;
			}
		}
		System.out.println(max);
		sc.close();
	}
}
