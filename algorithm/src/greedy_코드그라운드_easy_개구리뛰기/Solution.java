package greedy_코드그라운드_easy_개구리뛰기;
//https://www.codeground.org/practice/practiceProbView.do?probId=11

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt(); // 돌들의 개수
			int[] a = new int[N + 1]; // 돌위치의 배열
			for (int j = 1; j <= N; j++) {
				a[j] = sc.nextInt();
			}
			int K = sc.nextInt(); // 한번에 뛸 수 있는 최대 거리

			// 실행
			int until = K; // 개구리가 현재 뛸 수 있는 최대거리
			int jump = 0; // 개구리가 뛴 횟수
			int nowIdx = 0; // 개구리의 현재 인덱스
			for (int j = 1; j <= N; j++) {
				if (a[j] - a[j - 1] > K) { // 돌들 사이의 거리가 한번에 뛸 수 있는 최대거리보다 크면 중지
					break;
				}
				if (a[j] == until) { //현재 최적의 돌에 있다면
					jump++;
					until = a[j] + K; 
					nowIdx = j;
				} else if (a[j - 1] < until && a[j] > until) { //이미 뛸수 있는 범위를 넘었다면
					j--; //다시 되돌아감
					jump++;
					until = a[j] + K;
					nowIdx = j;
				} else if (j == N && nowIdx != N) { //마지막
					nowIdx = N;
					jump++;
				}
			}
			
			//출력
			System.out.println("Case #" + i);
			if (a[nowIdx] == a[N]) { //현재 위치와 목적지가 같다면
				System.out.println(jump);
			} else {
				System.out.println(- 1);
			}
		}
	}
}
