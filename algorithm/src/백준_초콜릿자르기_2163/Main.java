package 백준_초콜릿자르기_2163;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//(n - 1) * m + (m - 1)
		System.out.println((n * m) - 1);
	}
}
