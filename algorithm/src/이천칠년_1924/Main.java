package 이천칠년_1924;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int[] monthsLastDate = new int[13];
		int[] daysFromJan = new int[13]; //각 달이 1월로부터 지난 날짜
		String[] dayOfWeek = new String[7]; //요일 문자 저장
		int i = 0;
		
		// 요일 초기화
		dayOfWeek[0] = "MON";
		dayOfWeek[1] = "TUE";
		dayOfWeek[2] = "WED";
		dayOfWeek[3] = "THU";
		dayOfWeek[4] = "FRI";
		dayOfWeek[5] = "SAT";
		dayOfWeek[6] = "SUN";
		
		// 마지막날 초기화
		for (i = 1; i <= 12; i++) {
			if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8) || (i == 10) || (i == 12)) {
				monthsLastDate[i] = 31;
			} else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
				monthsLastDate[i] = 30;
			} else {
				monthsLastDate[i] = 28;
			}
		}
		
		// 각 달의 1일이 1월1일로부터 몇일이나 지났을 지에 대한 계산 
		for (i = 2; i <= 12; i++) {
			daysFromJan[i] = monthsLastDate[i - 1] + daysFromJan[i - 1];
		}
		
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt(); //월을 입력
		int day = sc.nextInt(); //날짜를 입력
		
		System.out.println(dayOfWeek[(daysFromJan[month] + day - 1) % 7]);
	}
}
