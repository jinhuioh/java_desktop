package codingTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//노드사이의 거리
//문제
//N(2≤N≤1,000)개의 노드로 이루어진 트리가 주어지고 M(M≤1,000)개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.
//
//입력
//첫째 줄에 노드의 개수 N이 입력되고 다음 N-1개의 줄에 트리 상에 연결된 두 점과 거리(10,000 이하의 정수)를 입력받는다. 그 다음 줄에는 거리를 알고 싶은 M개의 노드 쌍이 한 줄에 한 쌍씩 입력된다.
//
//출력
//M개의 줄에 차례대로 입력받은 두 노드 사이의 거리를 출력한다.
//
//예제 입력 1 
//4 2
//2 1 2
//4 3 2
//1 4 3
//1 2
//3 2
//예제 출력 1 
//2
//7

public class codingTest3 {
	static int n,m;
	static int[][] map;
	static int Max = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//트리 상 연결된 두 점과 거리
		m = Integer.parseInt(st.nextToken());//알고싶은 노드 쌍의 거리
		
		//map 입력받기
		map = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				map[i][j] = Max;
				if(i==j) map[i][j]=0;
			}
		}
		
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());//두 노드 사이의 거리
			map[y][x] = k;
			map[x][y] = k;
		}//for
		
		for(int p=1; p<=n; p++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(map[i][j] > map[p][j] + map[i][p]) {
						map[i][j] = map[p][j] + map[i][p];
					}
				}
			}
		}
		//		거리를 알고 싶은 M개의 노드 쌍
		for(int j=0; j<m; j++) {
			st =  new StringTokenizer(br.readLine());
			int start_node = Integer.parseInt(st.nextToken());
			int end_node = Integer.parseInt(st.nextToken());
			System.out.println(map[start_node][end_node]);
		}//for
		
    }
}


