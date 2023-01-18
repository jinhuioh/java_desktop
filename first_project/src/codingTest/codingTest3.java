package codingTest;

import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.management.Query;
import javax.swing.JPopupMenu.Separator;
public class codingTest3 {
//	RGB거리
//	문제
//	RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//
//	집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//
//	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//	입력
//	첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
//
//	출력
//	첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
//
//	예제 입력 1 
//	3
//	26 40 83
//	49 60 57
//	13 89 99
//	예제 출력 1 
//	96
	
	//접근법: 2번째 줄부터 각 숫자의 최소값으로 위에꺼랑 더해서 갱신해나감
	static int n;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   n = Integer.parseInt(br.readLine());
	   dp = new int[n][n];
	   for(int i = 0; i<n; i++) {
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   for(int j = 0; j<3; j++) {
			   dp[i][j] = Integer.parseInt(st.nextToken());
		   }//for
	   }//for

	   for(int i = 1; i<n; i++) {
		   for(int j = 0; j<3; j++) {
			   if(j==0) {
				   dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2])+dp[i][j];
				   
			   }
			   else if(j==1) {
				   dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j+1])+dp[i][j];
			   
			   }
			   else {
				   dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j-2])+dp[i][j];
				   
			   }
		   }//for
	   }//for
	   System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }
}
   