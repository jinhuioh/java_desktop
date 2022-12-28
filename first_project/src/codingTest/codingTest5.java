package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//문제
//섬의 개수
//입력
//입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
//
//둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
//
//입력의 마지막 줄에는 0이 두 개 주어진다.
//
//출력
//각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

public class codingTest5 {
	static int w,h;//맵의 가로 세로
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1,1,1,-1,-1};
	static int[] dy = {1,0,-1,0,1,-1,1,-1};
	//탐색할 함수
	private static void bfs(int i, int j) {
//		System.out.println("ij>> "+i+" "+j);
		//현재 위치 true
		visited[i][j]=true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int l=0; l<8; l++) {
				//대각선까지 탐색
				int ny = y + dy[l];
				int nx = x + dx[l];
//				System.out.println("ny nx>> "+ny+" "+nx);
				//범위벗어나거나 이미 true이면 패스
				if(ny<0 || ny>=h || nx<0 || nx>=w || visited[ny][nx] || map[ny][nx] == 0) {
//					System.out.println(ny+" "+nx+"continue!");
					continue;
				}
				
				//방문 갱신
				visited[ny][nx]=true;
				//큐에 값 넣기
				q.add(new int[] {ny,nx});
			}
		}//while
	}//private
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st1.nextToken());//너비
			h = Integer.parseInt(st1.nextToken());//높이
			if(w==0 && h==0) break;// 0 0이 입력되면 break
			
			map = new int[h][w];
			visited = new boolean[h][w];
			//map입력
			for(int i=0; i<h; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
		
			//함수선언
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					//이미 true거나 바다이면 패스
					if(visited[i][j] || map[i][j] == 0) {
						continue;
					}//if
					bfs(i,j);
					count++;
				}
			}
		System.out.println(count);
		}//while
	}//public

}
