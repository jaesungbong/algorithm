package numberOfConnectedComponent_11724;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
		c[x] = true;
		for (int y : a[x]) {
			if (c[y] == false) {
				dfs(a, c, y);
			}
		}
	}

	public static void main(String[] args) {
		int numOfComponent = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		boolean[] check = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (check[i] == false) {
				dfs(a, check, i);
				numOfComponent++;
			}
		}
		System.out.println(numOfComponent);
	}
}
