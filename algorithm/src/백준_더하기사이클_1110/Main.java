package 백준_더하기사이클_1110;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int tensPlace = 0; // 10의 자리 숫자
		int unitsPlace = 0; // 1의자리 숫자
		int rightNumOfSum = 0;  // 10의 자리 숫자와 1의 자리 숫자를 더한 값의 오른쪽 값
		int result = n; //unitsPlace와 rightNumOfSum을 더한 결과값
		
		while (true) {
			tensPlace = result / 10; //10의 자리 숫자를 구함
			unitsPlace = result % 10; //1의 자리 숫자를 구함
			rightNumOfSum = (tensPlace + unitsPlace) % 10;
			result = unitsPlace * 10 + rightNumOfSum;
			count ++;
			if (result == n) {
				break;
			}
		}
		System.out.println(count);
	}
}
