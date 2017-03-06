package dijkstra_최단경로_1753;

import java.util.ArrayList;
import java.util.Scanner;

// ========
// 간선 클래스
// ========
class Edge {
	int dest; // 간선의 목적지
	int weight; // 간선의 가중치

	Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
}

// ==============
// 간선을 저장할 최소힙
// ==============
class Heap {
	private int size;
	private Edge[] element;

	Heap(int length) {
		size = 0;
		element = new Edge[length + 1];
	}

	void insert(Edge e) {
		int i = ++size;
		while (i != 1 && e.weight < element[i / 2].weight) {
			element[i] = element[i / 2];
			i /= 2;
		}
		element[i] = e;
	}

	Edge delete() {
		int parent = 1, child = 2;
		Edge root = element[1], temp = element[size--];
		while (child <= size) {
			if ((child < size) && (element[child].weight > element[child + 1].weight)) {
				child++;
			}
			if (temp.weight <= element[child].weight) {
				break;
			}
			element[parent] = element[child];
			parent = child;
			child *= 2;
		}
		element[parent] = temp;
		return root;
	}

	boolean isEmpty() {
		return size == 0 ? true : false;
	}
}

public class Main {
	static int INF = 99999;
	static int[] dist; // 시작 정점에서 목적 정점까지의 거리
	static boolean[] visit; // 정점을 방문했나 안했나

	public static void main(String[] args) {
		// ====
		// INPUT
		// ====
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		int K = sc.nextInt(); // 시작 정점의 번호
		dist = new int[V + 1]; // 시작 정점으로부터 목적 정점까지의 최소 거리
		visit = new boolean[V + 1]; // 방문 했나 안했나
		// 각 정점의 연결된 간선을 저장
		ArrayList<Edge>[] a = (ArrayList<Edge>[]) new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = INF; // 모든 정점은 일단 무한
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // 간선의 시작
			int v = sc.nextInt(); // 간선의 끝
			int w = sc.nextInt(); // 가중치
			a[u].add(new Edge(v, w));
		}

		// ======
		// EXECUTE
		// ======
		dist[K] = 0; // 시작정점과 시작정점의 거리는 0
		Heap heap = new Heap(E);
		heap.insert(new Edge(K, 0));
		while (!heap.isEmpty()) {
			Edge x = heap.delete();
			visit[x.dest] = true;
			for (Edge y : a[x.dest]) {
				if (visit[y.dest] == false) {
					dist[y.dest] = Math.min(dist[y.dest], dist[x.dest] + y.weight);
					heap.insert(new Edge(y.dest, dist[y.dest]));
				}
			}
		}

		// ======
		// OUTPUT
		// ======
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		sc.close();
	}
}