package fp.vuelos;

public class Loops {

	public static void main(String[] args) {
		// to 100 
		for (int i = 1; i <= 100; i++) {
		    System.out.println(i);
		}
		
		// sum n numbers 0+... +10
		int n = 10;
		int sum = 0, i = 1;
		while (i <= n) {
		    sum += i;
		    i++;
		}
		System.out.println("Sum = " + sum);
		
		
		//Extract and reverse digits. Given an integer (e.g., 12345), reverse its digits.
		// 1000 +2000 +300 +40 +5 
		int num = 12345 , reversed = 0 ;
		while (num != 0) {
			// remmber In base-10 (decimal system), dividing a number by 10 gives: Quotient /: the number without its last digit.Remainder $: the last digit.
			int digit = num % 10 ; // outpu 5
			reversed = reversed *10 +digit ; // 0*10+5 //5*10+4 //4*10+3//3*10+2//2*10+1
			num /= 10; //1234  /123 /12 /1 /0 /ends
		}System.out.println("Reversed = " + reversed);
		
		
		int l = 20 , e = 1 , sum2 = 0;
		//Accumulate sum using a loop.
		while (e<=l) {
			sum2 += e;
			e++;
		}

		System.out.println("Sum = " + sum2);

	}

}
