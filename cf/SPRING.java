package cf;

import java.io.IOException;
import java.util.Scanner;

public class SPRING{
	public static long gcd(long a, long b) {
		if(b == 0){
		      return a;
		}
		return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--> 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			long m =sc.nextLong();
			long A = m / a;
			long B = m / b;
			long C = m / c;
			long Ab = m / lcm(a, b);
			long Ac = m / lcm(a, c);
			long Bc = m / lcm(b, c);
			long Abc = m / lcm(lcm(a, b), c);
			long Al = 6 * A - 3 * (Ab + Ac) + 2 * Abc;
			long Bob = 6 * B - 3 * (Ab + Bc) + 2 * Abc;
			long Ca = 6 * C - 3 * (Ac + Bc) + 2 * Abc;

			System.out.println(Al + " " + Bob + " " +Ca);
		}
	}
}