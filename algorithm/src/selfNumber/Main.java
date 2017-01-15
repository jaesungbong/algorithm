package selfNumber;

import java.util.ArrayList;

public class Main {
	public int d(int num) {
		int result = 0;
		if ( num < 10 ) {
			result = num * 2;
		} else {
			result = num;
			while ( num != 0 ) {
				result += num % 10;
				num = num / 10;
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		Main main = new Main();
		ArrayList<Integer> hasConstructor = new ArrayList<Integer>();
		ArrayList<Integer> noConstructor = new ArrayList<Integer>();
		int i = 1;
		while ( i <= 10000 ) {
			hasConstructor.add(main.d(i));
			if (hasConstructor.indexOf(i) == -1) {
				noConstructor.add(i);
			}
			i++;
		}
		for (int k : noConstructor) {
			System.out.println(k);
		}
	}
}