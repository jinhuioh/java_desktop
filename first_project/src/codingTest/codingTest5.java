package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest5 {
	static int m,n,k;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		//초기값넣기
		q.add(new int[] {i,j});
		//초기값 true로 바꿔줌
		visited[i][j]=true;
		
		while(!q.isEmpty()) {
			System.out.println("while~~"+i+" "+j);
			int ny = q.peek()[0];
			int nx = q.peek()[1];
			q.poll();
			for(int i1=0; i1<4; i1++) {
				int y = ny + dy[i1];
				int x = nx + dx[i1];
				System.out.println("y x>>> "+y+" "+x);
				//범위를 벗어나거나 이미 visited가 true이면 또는 map이1이 아니면 continue
				if(y<0 || y>=m || x<0 || x>=n) {
					continue;
				}
				if(!visited[y][x] && map[y][x] == 1) {
					//true갱신
					visited[y][x]=true;
						//q에 add
						q.add(new int[] {y,x});
					
				}
			}//for
		}
	}//private
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int t=0; t<c; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			visited = new boolean[m][n];
			count = 0;
		
			for(int i=0; i<k; i++) {
				st = new  StringTokenizer(br.readLine()," ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				map[p1][p2] = 1;
			}//for
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						//함수 실행
						bfs(i,j);
						count++;
					}
				}
			}//for
			System.out.println(count);
		}//for
	}

}
