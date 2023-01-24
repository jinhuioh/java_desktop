package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//빙산
//	입력
//	첫 줄에는 이차원 배열의 행의 개수와 열의 개수를 나타내는 두 정수 N과 M이 한 개의 빈칸을 사이에 두고 주어진다. N과 M은 3 이상 300 이하이다. 그 다음 N개의 줄에는 각 줄마다 배열의 각 행을 나타내는 M개의 정수가 한 개의 빈 칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0 이상 10 이하이다. 배열에서 빙산이 차지하는 칸의 개수, 즉, 1 이상의 정수가 들어가는 칸의 개수는 10,000 개 이하이다. 배열의 첫 번째 행과 열, 마지막 행과 열에는 항상 0으로 채워진다.
//
//	출력
//	첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다. 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.
//
//	예제 입력 1 
//	5 7
//	0 0 0 0 0 0 0
//	0 2 4 5 3 0 0
//	0 3 0 2 5 2 0
//	0 7 6 2 4 0 0
//	0 0 0 0 0 0 0
//	예제 출력 1 
//	2

//행렬위치와 인접한 0의 개수를 넣을 클래스
class indexclass{
	int y;
	int x;
	int z;//상하좌우 0의 개수
	indexclass(int y, int x, int z){
		this.y = y;
		this.x = x;
		this.z = z;
	}
}


public class codingTest4 {

	private static int bfs() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] !=0) {
					int count0 = 0;
					for(int k = 0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx] == 0) {
							count0++;
						}
					}
					q.add(new indexclass(i, j, count0));
				}
			}
		}//for
		//빙하 녹이기
		while (!q.isEmpty()) {
			indexclass qp = q.remove();
			int y = qp.y;
			int x = qp.x;
			int z = qp.z;
			map[y][x] = map[y][x]-z;
			if(map[y][x]<0) {
				map[y][x] = 0;
			}//if
		}//while
		
		
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		//빙하의 개수 카운트
		visited = new boolean[n][m];
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] !=0 && !visited[i][j]) {
					count_ice(i,j);
					count++;
				}
				
			}
		}//for
//		System.out.println("bfs에서 countice>> "+count);
//		System.out.println();
		return count;
	}//private
	
	private static void count_ice(int y, int x) {
		visited[y][x] = true;
		Queue<indexclass> q = new LinkedList<indexclass>();
		q.add(new indexclass(y, x, 0));
		
		while (!q.isEmpty()) {
			indexclass qp = q.remove();
			int y1 = qp.y;
			int x1 = qp.x;
			for(int k = 0; k<4; k++) {
				int ny = y1 + dy[k];
				int nx = x1 + dx[k];
				if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx] != 0 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new indexclass(ny, nx, 0));
				}
			}
		}
	}
	
	static int n,m;
	static int[][] map;
	static Queue<indexclass> q = new LinkedList<indexclass>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}//for
		}//for
	
		
		//빙하의 개수 카운트
		visited = new boolean[n][m];
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] !=0 && !visited[i][j]) {
					count_ice(i,j);
					count++;
				}
				
			}
		}//for
		if(count>=2) {
			System.out.println(0);
			System.exit(0);
		}
		
		
		int days = 0;
		int result = 1;
		Loop1 :
		while(true) {
			int c = 0;
			result = bfs();//나누어진 빙산의 개수
			days++;
//			System.out.println("날짜>> "+days);
			if(result >= 2){
				System.out.println(days);
				System.exit(0);
			}
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] !=0) {
						c = 1;
					}
				}
			}//for
			if(c==0) {
				break Loop1;
			}//if
		}//while
		
		System.out.println(0);
		
		
	}
}