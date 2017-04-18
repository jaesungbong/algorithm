package 코드그라운드_normal1_등차수열;

import java.util.Scanner;

public class Solution {
	static long num[] = new long[100001]; // 숫자들
	static long sub[] = new long[100000]; // 차들
	static long gcd[] = new long[99999];

	public static long getGcd(long a, long b) { //최대공약수 구하기
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}

	public static long getDivisor(long x) { // 약수의 개수 구하기
		long cnt = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				cnt ++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int m = sc.nextInt(); // 수열 원소의 개수
			int flag = 0; // 모든 공차가 0일 때
			long cnt = 0;
			for (int i = 1; i <= m; i++) {
				num[i] = sc.nextInt(); // 숫자 입력
				if (i > 1) {
					sub[i - 1] = num[i] - num[i - 1];
					if (sub[i - 1] != 0) {
						flag = 1;
					}
					gcd[i - 1] = sub[i - 1];
				} else if (i > 2) {
					gcd[i - 1] = getGcd(gcd[i - 2], sub[i - 1]);
				}
			}
			if (flag == 0) {
				cnt = 1;
			} else if (flag == 1 && m == 2) {
				cnt = getDivisor(sub[1]);
			} else if (flag == 1 && m > 2) {
				cnt = getDivisor(gcd[m - 2]);
			}
			System.out.println("Case #" + t);
			System.out.println(cnt);
		}
		sc.close();
	}
}
