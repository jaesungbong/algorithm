package sort_국영수_10825;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //학생 수
		ArrayList<Student> pq = new ArrayList<Student>();
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			int koreanScore = sc.nextInt();
			int englishScore = sc.nextInt();
			int mathScore = sc.nextInt();
			Student s = new Student(name, koreanScore, englishScore, mathScore);
			pq.add(s);
		}
		while(!pq.isEmpty()) {
			Student s = pq.remove(0);
			System.out.println(s.name);
		}
		sc.close();
	}
}

class Student implements Comparable<Student> {
	String name;
	public int koreanScore;
	public int englishScore;
	public int mathScore;
	
	public Student(String name, int k, int e, int m) {
		super();
		this.koreanScore = k;
		this.englishScore = e;
		this.mathScore = m;
	}

	public int compareTo(Student o) {
		if (this.koreanScore > o.koreanScore) {
			return 1;
		} else if (this.koreanScore < o.koreanScore) {
			return -1;
		}
		return 0;
	}
}
