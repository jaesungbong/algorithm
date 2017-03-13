package 백준_별찍기4_2441;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String strStar = "";
			int gap = i;
			for (int j = 0; j < n; j++) {
				if ( j < i ) {
					strStar += " ";
				} else {
					strStar += "*";
				}
			}
			System.out.println(strStar);
		}
	}
}