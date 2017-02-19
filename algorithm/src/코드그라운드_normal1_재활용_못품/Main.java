package 코드그라운드_normal1_재활용_못품;

import java.util.Scanner;

public class Main {
	static int[] house = new int[501];
	static Distance[] housesDistance = new Distance[501];

	static int getCenter(int x1, int x2) {
		int sum = 0;
		int result = 0;
		for (int i = x1; i <= x2; i++) { 
			sum += house[i]; //집 위치의 평균 구하기
		}
		sum /= (x2 - x1 + 1);
		for (int i = x1; i <= x2; i++) {
			result += Math.abs(house[i] - sum); // 각 집의 위치에서 평균위치를 뺀 값을 모두 더하기
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //집의 수
		int m = sc.nextInt(); //수집통의 수
		
		for (int i = 1; i <= n; i++) { //집의 위치 저장
			house[i] = sc.nextInt();
		}
		
		if (1 < m) { //휴지통이 2개 이상일 때
			int result = 0;
			for (int i = 1; i < n; i++) {
				Distance d = new Distance(i, i + 1, Math.abs(house[i] - house[i + 1]));
			}
			for (int i = 1; i <=m ;i++) {
				
			}
		} else { //휴지통이 하나일 때
			System.out.println(getCenter(1, n));
		}
	}
}
class Distance implements Comparable<Distance> {
	int x1;
	int x2;
	int distance;
	
	Distance(int x1, int x2, int distance) {
		this.x1 = x1;
		this.x2 = x2;
		this.distance = distance;
	}

	@Override
	public int compareTo(Distance o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
