package 백준_별찍기1_2438;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //줄을 입력 받기
		String strStar = "*";
		for (int i = 1; i <= t; i++) {
			System.out.println(strStar);
			strStar += "*";
		}
	}
}
