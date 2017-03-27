package 백준_ATM_11399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[] accumulatedTime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //사람의 수
		accumulatedTime = new int[n];
		ArrayList<Integer> time = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			time.add(sc.nextInt());
		}
		Collections.sort(time);
		accumulatedTime[0] = time.get(0);
		for (int i = 1; i < n; i++) {
			accumulatedTime[i] += accumulatedTime[i - 1] + time.get(i);
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			ret += accumulatedTime[i];
		}
		sc.close();
		System.out.println(ret);
	}
}
