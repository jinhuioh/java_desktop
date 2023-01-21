package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//치즈
//	입력
//	첫째 줄에는 사각형 모양 판의 세로와 가로의 길이가 양의 정수로 주어진다. 세로와 가로의 길이는 최대 100이다. 판의 각 가로줄의 모양이 윗 줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 
//	치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지며 각 숫자 사이에는 빈칸이 하나씩 있다.
//
//	출력
//	첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고, 둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다.
//	예제 입력 1 
//	13 12
//	0 0 0 0 0 0 0 0 0 0 0 0
//	0 0 0 0 0 0 0 0 0 0 0 0
//	0 0 0 0 0 0 0 1 1 0 0 0
//	0 1 1 1 0 0 0 1 1 0 0 0
//	0 1 1 1 1 1 1 0 0 0 0 0
//	0 1 1 1 1 1 0 1 1 0 0 0
//	0 1 1 1 1 0 0 1 1 0 0 0
//	0 0 1 1 0 0 0 1 1 0 0 0
//	0 0 1 1 1 1 1 1 1 0 0 0
//	0 0 1 1 1 1 1 1 1 0 0 0
//	0 0 1 1 1 1 1 1 1 0 0 0
//	0 0 1 1 1 1 1 1 1 0 0 0
//	0 0 0 0 0 0 0 0 0 0 0 0
//	예제 출력 1 
//	3
//	5
class ch{
	int y;
	int x;
	ch(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class codingTest7 {
	static int m,n;
	static int[][] map;
	static int[][] arr;
	static boolean[][] visited,visited1;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<ch> q = new LinkedList<ch>();
	static Queue<ch> q1 = new LinkedList<ch>();
	static Queue<ch> q2 = new LinkedList<ch>();
	
	//마지막에 있는 칸의 개수 반환
	private static int bfs(int i , int j) {
		int count;
		for(int i1 = 0; i1<n; i1++) {
			for(int j1 = 0; j1<m; j1++) {
				
			}
		}
		
		
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		arr = new int[n][m];//치즈가 다 없어지는데 걸리는 일수 계산할 배열
		visited = new boolean[n][m];
		visited1 = new boolean[n][m];
		//map입력받기
		for(int i = 0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
				if(map[i][j]==1) {//0과 인접해있는 위치를 전부 큐에 넣는다.
						if(map[i-1][j]==2 || map[i+1][j]==2 || map[i][j-1]==2 || map[i][j+1]==2) {
							q1.add(new ch(i, j));
					}
				}
			}
		}//for
		
		//1. 1로 둘러싸인 0을 빼고 겉부분 0을 2로 표시
		map[0][0]=2;
		visited[0][0] = true;
		q.add(new ch(0, 0));
		while (!q.isEmpty()) {
			ch qp = q.remove();
			int y = qp.y; 
			int x = qp.x;
			
			for(int k = 0; k<4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]==0 && !visited[ny][nx]) {
					visited[ny][nx]=true;
					map[ny][nx] = 2;
					q.add(new ch(ny, nx));
				}//if
			}//for
		}//while

		
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}//for
//		System.out.println();
		int count = 0;
		List<Integer> answer_list = new ArrayList<Integer>();
		while (true) {
			int count_one = 0;
			int finish = 0;
//		2. q1에 넣은 0과 인접한 위치 중에서 2와 인접한 것들만 연산
			while (!q1.isEmpty()) {
				ch qp1 = q1.remove();
				int y1 = qp1.y;
				int x1 = qp1.x;
				
//				visited1[y1][x1] = true;
				//공기와 닿는다면 해당 위치 2로 갱신
				map[y1][x1] = 2;
				
				
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<m; j++) {
	//				//for문 돌면서 0과 2가 인접해있으면 0을 2로 갱신
						if(map[i][j]==0) {
							if(map[i-1][j]==2 || map[i+1][j]==2 || map[i][j-1]==2 || map[i][j+1]==2) {
							visited = new boolean[n][m];
							q2.add(new ch(i,j));
							visited[i][j] = true;
							while (!q2.isEmpty()) {
								ch qp2 = q2.remove();
								int y2 = qp2.y; 
								int x2 = qp2.x;
								
								for(int k = 0; k<4; k++) {
									int ny = y2 + dy[k];
									int nx = x2 + dx[k];
										if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]==0 && !visited[ny][nx]) {
											visited[ny][nx]=true;
											map[ny][nx] = 2;
											q2.add(new ch(ny, nx));
										}
									}//if
								}
							}//for
						}//if
					}
				}
				
//				for(int k = 0; k<4; k++) {
//					int ny1 = y1 + dy[k];
//					int nx1 = x1 + dx[k];
//					System.out.println("nynx1>>> "+ny1+" "+nx1);
//					if(ny1>=0 && nx1>=0 && ny1<n && nx1<m ) {
//						if(map[ny1][nx1]==1 && !visited1[ny1][nx1]) {
//							visited1[ny1][nx1]=true;
//							map[ny1][nx1] = 2;
//						}
//					}//if
//				}//for
			}//while
//		
//			for(int i = 0; i<n; i++) {
//				for(int j = 0; j<m; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}//for
//			System.out.println();
//			System.out.println();
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					
					if(map[i][j]==1) {//0과 인접해있는 위치를 전부 큐에 넣는다.
						count_one++;
						if(map[i-1][j]==2 || map[i+1][j]==2 || map[i][j-1]==2 || map[i][j+1]==2) {
							q1.add(new ch(i, j));
							finish = 1;
						}
					}
				}
			}//for
			answer_list.add(count_one);
			if(finish == 0) {
				break;
			}
			else if(finish == 1) {
				count++;
			}
			
			
		}//while
		System.out.println(count);
		System.out.println(answer_list.get(answer_list.size()-2));
			
	}

}
