package 코드그라운드_normal1_재활용_못품;
// https://www.codeground.org/practice/practiceProbView.do?probId=36

import java.util.Scanner;

public class Main {
	static int[] house;

	// ==================================
	// 한 그룹의 각 집에서 최적의 수집통까지의 거리의 합
	// ==================================
	static int getGroupsCenter(int startIdx, int endIdx) {
		int minDistance = 0;
		int temp = 0;
		for (int i = house[startIdx]; i <= house[endIdx]; i++) {
			for (int j = startIdx; j <= endIdx; j++) {
				if (i == house[startIdx]) {
					minDistance += Math.abs(house[j] - i);
				}
				temp += Math.abs(house[j] - i);
			}
			minDistance = Math.min(minDistance, temp);
			temp = 0;
		}
		return minDistance;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트 케이스
		for (int t = 1; t <= testCase; t++) {
			// ====
			// INPUT
			// ====
			int n = sc.nextInt(); // 집의 수
			int m = sc.nextInt(); // 수집통의 수
			house = new int[n + 1];

			// ======
			// OUTPUT
			// ======
			System.out.println("Case #" + t);
		}
		sc.close();
	}
}