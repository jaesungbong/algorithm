package 백준_별찍기3_2440;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String strStar = "";
			int gap = n - i;
			for (int j = 0; j < gap; j++) {
				if (j < gap) {
					strStar += "*";
				} else {
					strStar += " ";
				}
			}
			System.out.println(strStar);
		}
	}
}
