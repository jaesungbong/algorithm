package dijkstra_최단경로_1753_못품;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int INF = 999999;
	static int[] dist;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		int K = sc.nextInt(); // 시작 정점의 번호
		dist = new int[V + 1]; // 시작 정점으로부터 목적 정점까지의 최소 거리
		ArrayList<Edge>[] a = (ArrayList<Edge>[]) new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			a[i] = new ArrayList<Edge>();
			if (i != K) {
				dist[i] = INF;
			} else {
				visit[i] = true;
			}
		}
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			Edge e = new Edge(v, w);
			a[u].add(e);
		}
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(a[K]);
		int start = K;
		while(!q.isEmpty()) {
			Edge e = q.remove();
			int x = e.dest;
		}
	}
}

class Edge implements Comparable<Edge> {
	int dest; // 간선의 목적지
	int weight; // 간선의 가중치

	Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}

	public int compareTo(Edge o) {
		if (this.weight > o.weight) {
			return 1;
		} else if (this.weight < o.weight) {
			return -1;
		} else {
			return 0;
		}
	}
}
