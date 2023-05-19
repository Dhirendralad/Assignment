package Day11_assignment;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a number: ");
			int n = sc.nextInt();

			boolean isPrime = true;

			for (int i = 2; i <= Math.sqrt(n); i++) {
			    if (n % i == 0) {
			        isPrime = false;
			        break;
			    }
			}

			if (isPrime) {
			    System.out.println(n + " is a prime number.");
			} else {
			    System.out.println(n + " is not a prime number.");
			}
		}
	}

}
