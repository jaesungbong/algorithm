package 코드그라운드_normal1_재활용_못품;
// https://www.codeground.org/practice/practiceProbView.do?probId=36

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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

	// =============
	// 집과 집 사이의 거리
	// =============
	static class Distance implements Comparable<Distance> {
		int startIdx;
		int destIdx;
		int distance;

		Distance(int startIdx, int destIdx, int distance) {
			this.startIdx = startIdx;
			this.destIdx = destIdx;
			this.distance = distance;
		}

		@Override
		public int compareTo(Distance o) {
			return this.distance > o.distance ? -1 : 1;
		}
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
			PriorityQueue<Distance> pq = new PriorityQueue<Distance>();
			Distance[] a = new Distance[m - 1];
			for (int i = 1; i <= n; i++) { // 집의 위치 저장
				house[i] = sc.nextInt();
			}
			Arrays.sort(house);

			// =====
			// EXCUTE
			// =====
			int minDist = 0;
			if (m == 1) { // 수거함이 1개일 때
				minDist = getGroupsCenter(1, house.length - 1);
			} else if (m == 2) { // 수거함이 2개 일때
				for (int i = 2; i <= n; i++) {
					pq.add(new Distance(i - 1, i, house[i] - house[i - 1]));
				}
				minDist = getGroupsCenter(1, pq.peek().startIdx) + getGroupsCenter(pq.peek().destIdx, n);
			} else { // 수거함이 3개 이상일 때
				for (int i = 2; i <= n; i++) {
					pq.add(new Distance(i - 1, i, house[i] - house[i - 1]));
				}
				for (int i = 0; i < m - 1; i++) {
					a[i] = pq.poll();
				}
				Arrays.sort(a, new Comparator<Distance>() {
					@Override
					public int compare(Distance o1, Distance o2) {
						return o1.startIdx < o2.startIdx ? -1 : 1;
					}
				});
				for (int i = 0; i < m; i++) {
					if (i == 0) {
						minDist += getGroupsCenter(1, a[i].startIdx);
					} else if (i == m - 1) {
						minDist += getGroupsCenter(a[i - 1].destIdx, n);
					} else {
						minDist += getGroupsCenter(a[i - 1].destIdx, a[i].startIdx);
					}
				}
			}

			// ======
			// OUTPUT
			// ======
			System.out.println("Case #" + t);
			System.out.println(minDist);
		}
		sc.close();
	}
}