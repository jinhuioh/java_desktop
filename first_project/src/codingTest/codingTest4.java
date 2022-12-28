package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest4 {
	static int m,n,k;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			visited[x][y] = true;
			q.poll();
			
			for(int i = 0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx >= 0 && cy >= 0 && cx < m && cy < n) {
					if(!visited[cx][cy] && map[cx][cy]==1) {
						q.add(new int[] {cx, cy});
						visited[cx][cy]=true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int c = 0; c<t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			 m = Integer.parseInt(st.nextToken());
			 n = Integer.parseInt(st.nextToken());
			 k = Integer.parseInt(st.nextToken());
			 map = new int[m][n];
			 visited = new boolean[m][n];
			 count=0;
			 
			 for(int i = 0; i<k; i++) {
				 st = new StringTokenizer(br.readLine()," ");
				 int p1 = Integer.parseInt(st.nextToken());
				 int p2 = Integer.parseInt(st.nextToken());
				 
				 map[p1][p2] = 1;
			 }//for
			 for(int i = 0; i < m; i++) {
				 for(int j = 0; j < n; j++) {
					 if(map[i][j]==1 && !visited[i][j]) {
						 bfs(i,j);
						 count++;
					 }
				 }//for
			 }//for
			 System.out.println(count);
		}
	}
}
