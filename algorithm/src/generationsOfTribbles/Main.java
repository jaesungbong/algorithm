package generationsOfTribbles;

import java.util.Scanner;

public class Main {
	public static int koong(int n) {
		if (n < 2) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		} else {
			return koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(koong(n));
		}
	}
}
