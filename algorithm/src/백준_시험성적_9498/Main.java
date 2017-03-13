package 백준_시험성적_9498;

import java.util.Scanner;

public class Main {
	static int getGrade(int n) {
		if (90 <= n) {
			return 'A';
		} else if (80 <= n) {
			return 'B';
		} else if (70 <= n) {
			return 'C';
		} else if (60 <= n) {
			return 'D';
		} else {
			return 'F';
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((char)getGrade(n));
	}
}
