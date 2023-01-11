package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest7 {
//토마토
//		입력
//		첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
//
//		토마토가 하나 이상 있는 경우만 입력으로 주어진다.
//
//		출력
//		여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
//
//		예제 입력 1 
//		6 4
//		0 0 0 0 0 0
//		0 0 0 0 0 0
//		0 0 0 0 0 0
//		0 0 0 0 0 1
//		예제 출력 1 
//		8
	
	static int m,n;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<int[]> q = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		//map입력받기
		for(int i = 0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				int p1 = Integer.parseInt(st1.nextToken());
				map[i][j] = p1;
				if(map[i][j]==1) {
					//익은토마토 위치 넣기
					q.add(new int[] {i,j});
				}
			}
		}//for
		
		while (!q.isEmpty()) {
			int ny = q.peek()[0];
			int nx = q.peek()[1];
			q.poll();
			for(int k = 0; k<4; k++) {
				int y = dy[k] + ny;
				int x = dx[k] + nx;
				if(y<0 || y>=n || x<0 || x>=m) { 
					continue;
				}
				//안익은 토마토 익히기
				if(map[y][x]==0) {
					q.add(new int[] {y,x});
					//익은 날짜 갱신
					map[y][x] = map[ny][nx] + 1; 
				}//if
			}//for
		
		}//while
		
		//답 구하기
		int answer = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				//안익은 토마토가 있으면
				if(map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}//if
				//일수 최대값 구하기
				answer = Math.max(answer, map[i][j]);
			}
		}//for
		System.out.println(answer-1);
	}

}
