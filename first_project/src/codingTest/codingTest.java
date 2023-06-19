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
//표준 입력으로 다음 정보가 주어진다. 입력은 한 줄로 구성되며 이 줄에는 타일의 개수를 나타내는 정수 N(1 ≤ N ≤ 80)이 주어진다. 
//
//출력
//표준 출력으로 N 개의 타일이 구성하는 타일 장식물 직사각형의 둘레를 출력한다. 
public class codingTest {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		dp[1] = 4;
		if(n>=2) {
			dp[2] = 6;
			for(int i = 3; i<n+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[n]);
	}
}