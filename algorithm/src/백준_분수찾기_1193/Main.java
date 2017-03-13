package 백준_분수찾기_1193;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int input = sc.nextInt();
      int arithmetic = 2;
      int x = 1;
      int flag = 0;
      while (input > x) {
         x += arithmetic;
         arithmetic += 1;
         flag ++;
      }
      if (flag % 2 == 0) {
    	  System.out.println(((x - input) + 1) + "/" + ((flag + 1) - (x - input)));
      } else {
    	  System.out.println(((flag + 1) - (x - input)) + "/" + ((x - input) + 1));
      }
   }
}