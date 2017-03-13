package 백준_DP_인접한비트의개수_2698;

import java.util.Scanner;

public class Main {
	static int[][][] nums= new int[101][100][2]; // [a][b][c] 길이가a인 비트 중 인접한 비트의 개수가 b개이고 c로 끝나는 수열의 개수 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		nums[1][0][1] = nums[1][0][0] = 1;
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			for (int i = 2; i <= 100; i++) {
				for (int j = 0; j <= k; j++) {
					nums[i][j][0] = nums[i - 1][j][0] + nums[i - 1][j][1];
					if (j - 1 < 0) {
						nums[i][j][1] = nums[i - 1][j][0];
					} else {
						nums[i][j][1] = nums[i - 1][j][0] + nums[i - 1][j - 1][1];
					}
				}
			}
			System.out.println(nums[n][k][0] + nums[n][k][1]);
		}
	}
}
