package dijkstra_최단경로_1753_못품;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int INF = 11;
	
	static void dijkstra(int start, int dest, ArrayList<Integer>[] a, int[][] w, int[] dist) {
		dist[dest] = Math.min(dist[dest], dist[start] + w[start][dest]);
		for (int y : a[dest]) {
			dijkstra(dest, y, a, w, dist);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); // 정점의 개수
		int e = sc.nextInt(); // 간선의 개수
		int k = sc.nextInt(); // 시작 정점의 번호
		
		int[] dist = new int[v + 1]; // dist[i]는 시작 정점으로 부터 정점i까지의 최단 거리
		
		// 정점과 정점의 가중치. w[1][2] = 3 은 정점1에서 정점2로의 가중치가 3이라는 뜻.
		int[][] w = new int[v + 1][v + 1];
		
		// 간선을 저장하기 위한 arraylist. a[1]은 정점1에 연결되는 간선들을 저장.
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[v + 1];
		
		for (int i = 1; i <= v; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt(); // 간선의 시작 정점
			int v2 = sc.nextInt(); // 간선의 끝 정점
			int weight = sc.nextInt(); // 가중치
			a[v1].add(v2); // 간선 저장
			w[v1][v2] = weight; // 가중치 저장
		}
		
		for (int i = 1; i <= v; i++) { // 거리 초기화
			dist[i] = ((i == k) ? 0 : INF); // 시작점의 거리는 0 나머지는 INF
		}
		
		for (int y : a[k]) {
			dijkstra(k, y, a, w, dist);
		}
		
		for (int i = 1; i <= v; i++) { // 정점의 각 거리 출력
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println((int) dist[i]);
			}
		}
		sc.close();
	}
}
