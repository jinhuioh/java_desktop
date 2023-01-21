package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest4 {
//격자상의경로
//	입력
//	입력의 첫째 줄에는 격자의 행의 수와 열의 수를 나타내는 두 정수 N과 M(1 ≤ N, M ≤ 15), 그리고 ○로 표시된 칸의 번호를 나타내는 정수 K(K=0 또는 1 < K < N×M)가 차례로 주어지며, 각 값은 공백으로 구분된다. K의 값이 0인 경우도 있는데, 이는 ○로 표시된 칸이 없음을 의미한다. N과 M이 동시에 1인 경우는 없다.
//
//	출력
//	주어진 격자의 정보를 이용하여 설명한 조건을 만족하는 서로 다른 경로의 수를 계산하여 출력해야 한다. 
//
//	예제 입력 1 
//	3 5 8
//	예제 출력 1 
//	9
	static int n,m,k;
	static int[][] map,arr;
	
	private static int dp_def(int y, int x) {
//		System.out.println("yx 는<>> "+y+" "+x);
		arr = new int[y+1][x+1];
		for(int p1=0; p1<x; p1++) {
			arr[0][p1] = 1;
		}
		for(int p1=0; p1<y; p1++) {
			arr[p1][0] = 1;
		}
		
		
		for(int i = 1; i < y; i++) {
			for(int j = 1; j < x; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
//				System.out.println("arr[i][j]> "+i+" "+j+" "+arr[i][j]);
			}
		}
//		System.out.println("answer>> "+arr[y-1][x-1]);
		return arr[y-1][x-1];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		if(k==0) {
			System.out.println(dp_def(n, m));
			System.exit(0);
		}
		
		int p = 1;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				map[i][j] = p;
				
				if(map[i][j] == k) {
//					System.out.println("함수시작!>> "+i+" "+j+" "+k);
//					arr1 = new int[i-1][j-1];
//					arr2 = new int[n-i+1][m-j+1];
					int answer1 = dp_def(i, j);
					int answer2 = dp_def(n-i+1,m-j+1);
					System.out.println(answer1*answer2);
					System.exit(0);
				}
				p++;
			}//for
		}//for
		
	}
}
