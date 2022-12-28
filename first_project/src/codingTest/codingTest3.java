package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//배추
//입력
//입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
//그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.
//
//출력
//각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
//
//예제 입력 1 
//2
//10 8 17
//0 0
//1 0
//1 1
//4 2
//4 3
//4 5
//2 4
//3 4
//7 4
//8 4
//9 4
//7 5
//8 5
//9 5
//7 6
//8 6
//9 6
//10 10 1
//5 5
//예제 출력 1 
//5
//1
public class codingTest3 {
	static int c;//테스트 개수
	static int n;//세로
	static int m;//가로
	static int k;//배추 개수
	static int count;
	static int[][] map;//배추 표시할 배열
	static boolean[][] visited;//탐색했는지 판단할 배열
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<Integer> one = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		for(int i1=0; i1<c; i1++) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			visited = new boolean[m][n];
			for(int i=0; i<k; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st1.nextToken());//가로 위치
				int x = Integer.parseInt(st1.nextToken());//세로 위치
				map[y][x]=1;//배추 표시
			}//for
			bfs();
			
		}//for

		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}//public
	
	private static void bfs() {
	int count = 0;
	//0,0부터 탐색
	for(int i=0; i<m; i++) {
		for(int j=0; j<n; j++) {
//			System.out.println(i+" "+j);
//			System.out.println("배추가 있는가?>>"+map[i][j]);
			//이미 탐색했거나, 배추가 있는 곳이 아니면 continue 
			if(visited[i][j] || map[i][j] != 1) {
//				System.out.println("패스!~~~");
				continue;
			}//if
			//현재위치 방문!
			visited[i][j] = true;
			
//				System.out.println("visited>>"+visited[i][j]);
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {i,j});
			//아래와 같이 하면 오류남
			//Queue<Integer> q = new LinkedList<Integer>();
			//q.add(i);
			//q.add(j);
			count++;//여기서 값 증가 시켜주고 while문으로 연결된 모든 배추를 true로 바꿔준다...
			while(!q.isEmpty()) {
				int qi = q.peek()[0];
				int qj = q.peek()[1];
				q.poll();
				visited[qi][qj]=true;
//				System.out.println("qi>>"+qi);
//				System.out.println("qj>>"+qj);
				for(int p=0; p<4; p++) {
						int ny = qi + dy[p];
						int nx = qj + dx[p];
						//범위를 벗어나면 continue 또는 배추가 있는곳이 아니면!
						if(ny<0 || ny>=m || nx<0 || nx>=n || map[ny][nx] != 1) {
							continue;
						}
						//이미 방문했으면 (true면) continue
						if(visited[ny][nx]) {
//							System.out.println("이미 true");
							continue;
						}//if
						visited[ny][nx]=true;
						q.add(new int[] {ny,nx});
//						System.out.println("count>>====== "+count+" nynx: "+ny+nx);
					}//p for
				}//while
			}//for
		}//for
		sb.append(count).append("\n");
	}//private
		
	
}
