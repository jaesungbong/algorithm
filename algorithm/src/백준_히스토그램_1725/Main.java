package 백준_히스토그램_1725;

import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();

		int n = sc.nextInt();
		int height[] = new int[n + 2];
		for (int i = 1; i <= n; i++)
			height[i] = sc.nextInt();
		int result = 0;
		stack.push(0);

		for (int i = 1; i <= n + 1; i++) {
			System.out.println("i: " + i);
			System.out.println("스택 상황: " + stack.toString());
			System.out.println("height[" + i + "]: " + height[i] + " < " + "height[stack.peek()]: " + height[stack.peek()]);
			while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
				System.out.println("while문 진입");
				int idx = stack.pop();
				System.out.println("idx: " + idx);
				result = Math.max(result, height[idx] * (i - stack.peek() - 1));
			}
			System.out.println("결과: " + result);
			stack.push(i);
			System.out.println("스택에 i 넣기");
			System.out.println();
		}
		sc.close();
		System.out.println(result);
	}
}