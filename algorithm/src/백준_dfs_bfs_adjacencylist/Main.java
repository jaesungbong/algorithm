package 백준_dfs_bfs_adjacencylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(a, c, y);
            }
        }
    }
    
    public static void bfs(ArrayList<Integer>[] a, boolean[] c, int start) {
    	int cnt = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
            cnt ++;
        }
        System.out.println();
        System.out.println(cnt);
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //정점의 개수
        int m = sc.nextInt(); //간선의 개수
        int start = sc.nextInt(); //시작 정점
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1]; //각 정점이 어떤 정점과 연결되어있는지 저장하기 위한 ArrayList
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v); //각 정점 사이의 간선이 존재하는 것을 표현
            a[v].add(u); //각 정점 사이의 간선이 존재하는 것을 표현
        }
        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]); 
        }
        boolean[] c = new boolean[n+1];
        dfs(a, c, start);
        System.out.println();
        Arrays.fill(c, false);
        bfs(a, c, start);
        System.out.println();
    }
}