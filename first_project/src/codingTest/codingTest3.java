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
//적록색약
//입력
//첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
//
//둘째 줄부터 N개 줄에는 그림이 주어진다.
//
//출력
//적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
//
//예제 입력 1 
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//예제 출력 1 
//4 3
public class codingTest3 {
	static int n;
	static char[][] map1, map2;//입력받은 그래프 넣을 배열
	static boolean[][] visited1,visited2;//방문했는지 채크할 배열
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	private static void bfs(int i, int j, char[][] map, boolean[][] visited) {
		char word = map[i][j];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int k = 0; k<4; k++) {
				int ny = y+ dy[k];
				int nx = x+ dx[k];
				if(ny<0 || ny>=n || nx<0 || nx>=n ) continue;
				if(!visited[ny][nx] && map[ny][nx] == word) {
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   n = Integer.parseInt(br.readLine());
	   map1 = new char[n][n];
	   map2 = new char[n][n];
	   visited1 = new boolean[n][n];
	   visited2 = new boolean[n][n];
	   for(int i = 0; i<n; i++) {
		   String s = br.readLine();
		   for(int j = 0; j<n; j++) {
			   char one = s.charAt(j);
			   map1[i][j] = one;
			   map2[i][j] = one;
			   if(one =='G') {
				   map2[i][j] = 'R';
			   }
		   }//for
	   }//for
	   
		   
	   int count1 = 0;//적록색약아님
	   int count2 = 0;//적록색약
	   for(int i = 0; i<n; i++) {
		   for(int j = 0; j<n; j++) {
			   if(visited1[i][j]) continue;
			   count1++;
			   bfs(i, j, map1, visited1);
		   }
	   }
	   //적록색약이면 빨강 == 파랑
	   for(int i = 0; i<n; i++) {
		   for(int j = 0; j<n; j++) {
			   if(visited2[i][j]) continue;
			   count2++;
			   bfs(i, j, map2, visited2);
		   }
	   }//for
	   System.out.println(count1+" "+count2);
    }

}
   