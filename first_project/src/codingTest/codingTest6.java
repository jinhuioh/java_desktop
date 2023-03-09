package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//피보나치 수 구하기
public class codingTest6 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		BigInteger[] dp = new BigInteger[n+1];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		if(n <= 1) {
			System.out.println(dp[n]);
		}else {
			for(int i = 2; i<=n; i++) {
				dp[i] = dp[i-2].add(dp[i-1]); 
//				System.out.println(dp[i]);
			}
			System.out.println(dp[n]);
		}
	}
}