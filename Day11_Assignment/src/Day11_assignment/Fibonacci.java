package Day11_assignment;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number of terms: ");
			int n = sc.nextInt();

			int a = 0, b = 1;

			System.out.print(a + " " + b);

			for (int i = 2; i < n; i++) {

			    int c = a + b;

			    System.out.print(" " + c);

			    a = b;
			    b = c;
			}
		}
	}
}
