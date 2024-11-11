package GenerateRandomNumber;

import java.util.Random;

public class generaterandomnumber {

	public static void main(String[] args) {
		Random ran=new Random();
		int random=ran.nextInt(1000);
		System.out.println(random);

	}

}
