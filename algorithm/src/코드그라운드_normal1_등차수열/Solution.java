package 코드그라운드_normal1_등차수열;

import java.util.Scanner;
//https://www.codeground.org/practice/practiceProbView.do?probId=16

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt(); // 숫자의 개수
			long num = sc.nextLong(); // 첫번째 숫자
			long gcd = 0;

			// 원소들의 차들의 최대공약수 구하기
			for (int i = 0; i < n - 1; i++) {
				// 원소들의 차 구하기
				long tempNum = sc.nextLong();
				long sub = tempNum - num;
				num = tempNum;
				if (i == 0) {
					gcd = sub;
				} else {
					while (sub != 0) { // 최대공약수 구하기
						long temp2 = gcd % sub;
						gcd = sub;
						sub = temp2;
					}
				}
			}

			int gcdsNum = 0;
			if (gcd == 0) {
				gcdsNum = 1;
			} else {
				for (int i = 1; i <= gcd; i++) {
					if (gcd % i == 0) {
						gcdsNum++;
					}
				}
			}
			System.out.println("Case #" + t);
			System.out.println(gcdsNum);
		}
		sc.close();
	}
}
