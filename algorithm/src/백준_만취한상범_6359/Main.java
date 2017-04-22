package 백준_만취한상범_6359;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 케이스
		while (0 < t) {
			int n = sc.nextInt();
			int[] nArray = new int[n + 1]; // 방을 나타내는 배열

			// 모든 방을 잠그기
			for (int i = 1; i <= n; i++) {
				nArray[i] = 1; // 모든 방을 잠근다.
			}

			// 라운드 진행
			for (int i = 1; i <= n; i++) {
				int visit = 1;
				int x = 1;
				while (i * x <= n) {
					visit = i * x;
					if (nArray[visit] == 1) { // 잠겨 있으면 열고
						nArray[visit] = 0;
					} else { // 열려 있으면 잠근다
						nArray[visit] = 1;
					}
					x++;
				}
			}

			// 열려있는 방의 갯수 세기
			int openedRoom = 0;
			for (int i = 1; i <= n; i++) {
				if (nArray[i] == 0) {
					openedRoom++;
				}
			}

			System.out.println(openedRoom);
			t--;
		}
		sc.close();
	}
}
