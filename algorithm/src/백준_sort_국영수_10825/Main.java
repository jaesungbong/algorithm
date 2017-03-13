package 백준_sort_국영수_10825;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //학생의 수
		Student[] s = new Student[N];
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			int koreanScore = sc.nextInt();
			int englishScore = sc.nextInt();
			int mathScore = sc.nextInt();
			s[i] = new Student(name, koreanScore, englishScore, mathScore);
		}
		Arrays.sort(s);
		for (int i = 0; i < N; i++) {
			System.out.println(s[i].name);
		}
		sc.close();
	}
}

class Student implements Comparable<Student>{
	public String name;
	public int koreanScore;
	public int englishScore;
	public int mathScore;
	
	public Student(String name, int k, int e, int m) {
		super();
		this.name = name;
		this.koreanScore = k;
		this.englishScore = e;
		this.mathScore = m;
	}

	public int compareTo(Student o) {
		if (this.koreanScore != o.koreanScore) {
			return this.koreanScore > o.koreanScore ? -1 : 1;
		} else if (this.koreanScore == o.koreanScore && this.englishScore != o.englishScore) {
			return this.englishScore > o.englishScore ? 1 : -1;
		} else if (this.koreanScore == o.koreanScore && this.englishScore == o.englishScore && this.mathScore != o.mathScore) {
			return this.mathScore > o.mathScore ? -1 : 1;
		} else {
			return this.name.compareTo(o.name);
		}
	}
}
