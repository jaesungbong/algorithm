package 백준_Baseball_10214;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int yonsei = 0; 
			int korea = 0;
			for (int i = 0; i < 9; i++) {
				yonsei += sc.nextInt();
				korea += sc.nextInt();
			}
			String result = yonsei > korea ? "Yonsei" : (yonsei == korea ? "Draw" : "Korea");
			System.out.println(result);
		}
		sc.close();
	}
}
