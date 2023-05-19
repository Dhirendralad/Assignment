package Day11_assignment;

import java.util.Random;

public class CouponNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a random number generator
        Random random = new Random();

        // Get the characters to use
        char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();

        // Generate a random coupon number
        char[] couponNumber = new char[5];
        for (int i = 0; i < couponNumber.length; i++) {
            couponNumber[i] = characters[random.nextInt(characters.length)];
        }

        // Print the coupon number
        System.out.println(new String(couponNumber));
	}

}
