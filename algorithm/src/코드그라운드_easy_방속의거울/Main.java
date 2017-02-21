package 코드그라운드_easy_방속의거울;

//https://www.codeground.org/practice/practiceProbView.do?probId=12
import java.util.Scanner;

public class Main {
	// 빛이 방향 상 하 좌 우 에따라
	static int up = 0, down = 1, left = 2, right = 3; 
	// 거울이 없는 방은 그대로 이동하고
	static int[] dx0 = {-1, 1, 0, 0};
	static int[] dy0 = {0, 0, -1, 1};
	
	// 1번 거울이 있는 방은 우 좌 하 상으로 이동하고,
	static int[] dx1 = {0, 0, 1, -1};
	static int[] dy1 = {1, -1, 0, 0};
	// 빛도 우 좌 하 상 으로 이동함.
	static int[] rd1 = {3, 2, 1, 0};
	
	// 2번 거울이 있는 방은 좌 우 상 하로 이동하고,
	static int[] dx2 = {0, 0, -1, 1};
	static int[] dy2 = {-1, 1, 0, 0};
	// 빛도 좌 우 상 하 로 이동함.
	static int[] rd2 = {2, 3, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); //테스트 케이스
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt(); // 한 변의 방의 개수
			int[][] room = new int[n + 1][n + 1];
			boolean visit[][] = new boolean[n + 1][n + 1];
			for (int i = 1; i <= n; i++) { // 각 방의 거울의 정보 저장
				String letter = sc.next();
				for (int j = 1; j <= n; j++) {
					room[i][j] = Integer.parseInt(letter.substring(j - 1, j));
				}
			}
			int cnt = 0;
			int x = 1;
			int y = 1;
			int rasersDirection = right;
			while (!((x <= 0) || (n < x) || (y <= 0) || (n < y))) {
				switch (room[x][y]) { // 방의 거울에 따라서
				case 0: // 거울이 없다면
					x += dx0[rasersDirection];
					y += dy0[rasersDirection];
					break;
				case 1: // 거울이 1이라면
					if (visit[x][y] == false) {
						visit[x][y] = true;
						cnt ++;
					}
					x += dx1[rasersDirection];
					y += dy1[rasersDirection];
					rasersDirection = rd1[rasersDirection];
					break;
				case 2: // 거울이 2라면
					if (visit[x][y] == false) {
						visit[x][y] = true;
						cnt ++;
					}
					x += dx2[rasersDirection];
					y += dy2[rasersDirection];
					rasersDirection = rd2[rasersDirection];
					break;
				}
			}
			System.out.println("Case #" + t);
			System.out.println(cnt);
		}
	}
}
