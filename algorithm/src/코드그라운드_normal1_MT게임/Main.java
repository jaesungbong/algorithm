package 코드그라운드_normal1_MT게임;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int a = sc.nextInt(); // A학과의 학생 수
			int b = sc.nextInt(); // B학과의 학생 수
			int c = sc.nextInt(); // 게임의 횟수
			String result = "";
			while (c-- > 0) {
				int aNum = a; // A학과의 학생 수
				int bNum = b; // B 학과의 학생 수
				int N = sc.nextInt(); // 게임이 끝나는 수
				int K = sc.nextInt(); // 연속한 숫자를 부를 수 있는 최대 개수
				int turn = ((N - 1) / (K + 1) * 2) + ((N - 1) % (K + 1) + 1);
				while (turn-- > 0) {
					if (aNum > 0 && bNum > 0) {
						aNum--;
					} else if (aNum == 0 && bNum > 0) {
						bNum--;
					} else if (aNum == 0 && bNum == 0) {
						aNum = a;
						bNum = b;
						aNum--;
					}
				}
				if (bNum > 0) {
					result.concat("b");
				} else {
					result.concat("a");
				}
			}
			System.out.println("Case #" + t);
			System.out.println(result);
		}
		sc.close();
	}
}
