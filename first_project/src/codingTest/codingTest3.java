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
//미로 탐색
//N×M크기의 배열로 표현되는 미로가 있다.
//미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
//이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
//한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
//칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

//입력
//첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
//
//출력
//첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

//예제 입력 1 
//4 6
//101111
//101010
//101011
//111011
//예제 출력 1 
//15
public class codingTest3 {
	static int n,m;
	static int[][] map;//입력받은 그래프 넣을 배열
	static int[][] map_bfs;//이동한 칸 개수
	static boolean[][] visited;//방문했는지 채크할 배열
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	private static int bfs(int i, int j) {
		map_bfs = new int[n][m];
		visited = new boolean[n][m];
		map_bfs[i][j] = 1;
		Queue<int []> q = new LinkedList<int []>();
		q.add(new int[]{i,j});//초기값 0,0이 들어감
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];//세로
			int y = q.peek()[1];//가로
			q.poll();
			for(int k = 0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
//				System.out.println("nx ny>> "+nx+" "+ny);
				//이미 방문했거나 범위를 벗어나면 continue
				if(nx < 0|| nx >= n || ny < 0 || ny >= m) {
//					System.out.println("continue>>  "+nx+" "+ny);
					continue;
				}
				//0은 이동할 수 없는 칸
				if(visited[nx][ny] || map[nx][ny]==0) continue;
				visited[nx][ny] = true;
				map_bfs[nx][ny] = map_bfs[x][y] + 1;//이동한 칸 개수
//				System.out.println("nxny add>>>>"+nx+" "+ ny);
				q.add(new int[] {nx, ny});
			}
		}//while
		return map_bfs[n-1][m-1];
	}
    public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   n = Integer.parseInt(st.nextToken());
	   m = Integer.parseInt(st.nextToken());
	   
	   map = new int[n][m];
	   
	   for(int i=0; i<n; i++) {
		   String s = br.readLine();//공백없이 한 줄로 입력받으므로 stringtokenizer대신 string으로 받는다.
		   for(int j=0; j<m; j++) {
			 map[i][j] = s.charAt(j)-'0';  
//		   System.out.println(map[i][j] );
		   }//for
	   }//for
	   //1은 이동 가능 0,0에서 시작
	   int answer = bfs(0, 0);
	   System.out.println(answer);
    }

}
   