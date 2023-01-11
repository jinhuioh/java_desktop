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
///입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 n (1 ≤ n ≤ 100,000)이 주어진다. 
//다음 두 줄에는 n개의 정수가 주어지며, 각 정수는 그 위치에 해당하는 스티커의 점수이다. 연속하는 두 정수 사이에는 빈 칸이 하나 있다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다. 
//
//출력
//각 테스트 케이스 마다, 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값을 출력한다.
//예제 입력 1 
//2
//5
//50 10 100 20 40
//30 50 70  10 60
//7
//10 30 10 50 100 20 40
//20 40 30 50 60 20 80
//예제 출력 1 
//260
//290

public class codingTest3 {
	static int n,m;
	static int[][] map,dp;
    public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   n = Integer.parseInt(br.readLine());
	  
	   for(int i = 0; i<n; i++) {
		   
		   m = Integer.parseInt(br.readLine());
		   map = new int[2][m+1];
		   dp = new int[2][m+1];
		   
		   for(int j = 0; j<2; j++) {
			   StringTokenizer st = new StringTokenizer(br.readLine());
			   for(int k = 1; k<=m; k++) {
				   map[j][k] = Integer.parseInt(st.nextToken());
			   }//for
		   }//for
		   
		   //최대값 구하기!
		   dp[0][1] = map[0][1]; 
		   dp[1][1] = map[1][1]; 
		   //2부터
		   for(int j = 2; j<=m; j++) {
			  dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + map[0][j]; 
			  dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + map[1][j]; 

		   }
		   System.out.println(Math.max(dp[0][m], dp[1][m]));
	   }//n for
    }

}
   