package Day11_assignment;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a number: ");
			int n = sc.nextInt();

			int reverse = 0;

			while (n != 0) {
			    int remainder = n % 10;
			    reverse = reverse * 10 + remainder;
			    n = n / 10;
			}

			System.out.println("The reverse of the number is: " + reverse);
		}
	}

}
