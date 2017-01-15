package stack_10828;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> stackNums = new ArrayList<Integer>();
	
	public static void push(int num) {
		stackNums.add(num);
	}
	
	public static void pop() {
		if (stackNums.size() != 0) {
			System.out.println(stackNums.get(stackNums.size() - 1));
			stackNums.remove(stackNums.size() - 1);
		} else {
			System.out.println(-1);
		}
	}
	
	public static void top() {
		if (stackNums.size() != 0) {
			System.out.println(stackNums.get(stackNums.size() - 1));
		} else {
			System.out.println(-1);
		}
	}
	
	public static void size() {
		System.out.println(stackNums.size());
	}
	
	public static void empty() {
		if (stackNums.size() != 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for(int i = 0; i < input; i++ ) {
			String command = sc.next();
			if (command.equals("push")) {
				int pushedNum = sc.nextInt();
				push(pushedNum);
			} else if (command.equals("top")) {
				top();
			} else if (command.equals("size")) {
				size();
			} else if (command.equals("empty")) {
				empty();
			} else if (command.equals("pop")) {
				pop();
			} else {
				System.out.println("error");
			}
		}
	}
}
