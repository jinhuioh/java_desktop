package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
//입력
//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
//
//출력
//첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
public class codingTest {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1]; 
		dp[1] = 1;
		if(n>1) {
			dp[2] = 3;
			for(int i = 3; i<=n; i++) {
				dp[i] = (dp[i-2]*2 + dp[i-1])%10007;
			}
		}
		System.out.println(dp[n]%10007);
	}
}