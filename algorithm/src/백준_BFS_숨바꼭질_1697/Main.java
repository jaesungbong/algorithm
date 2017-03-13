package 백준_BFS_숨바꼭질_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int start;
	static int dest;
	static int[] dist = new int[100001];

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		dist[start] = 1;
		while (!q.isEmpty()) {
			int x = q.remove();
			if (x == dest) {
				System.out.println(dist[x] - 1);
				break;
			} else {
				if ((0 <= x - 1) && (dist[x - 1] == 0)) { //이동되는 위치가 범위 안에 있고, -1 로 이동한다면
					q.add(x - 1);
					dist[x - 1] = dist[x] + 1;
				}
				if ((x + 1 <= 100000) && (dist[x + 1] == 0)) { //이동되는 위치가 범위 안에 있고, +1 로 이동한다면
					q.add(x + 1);
					dist[x + 1] = dist[x] + 1;
				}
				if ((x * 2 <= 100000) && (dist[x * 2] == 0)) { //이동되는 위치가 범위 안에 있고, *2 로 이동한다면
					q.add(x * 2);
					dist[x * 2] = dist[x] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt(); // 수빈이의 위치
		dest = sc.nextInt(); // 동생의 위치
		bfs();
		sc.close();
	}
}
