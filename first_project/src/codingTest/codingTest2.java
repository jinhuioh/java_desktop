package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.PRIVATE_MEMBER;
public class codingTest2 {
	static int[][] map;
	//좌표.오른쪽과 아래만 이동가능
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean[][] visited;
//	입력
//	입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다. 젤리는 오른쪽과 아래로만 이동 가능
//
//	입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.
//
//	게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.
//
//	출력
//	‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력합니다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for
		dfs(0,0,n);
		System.out.println("Hing");
	}//public static
	
		//주어진 위치로부터 X칸 아래 또는 오른쪽으로 이동하는 함수
		private static void dfs(int i, int j, int n) {
			//마지막 위치이면
			if(map[i][j] == -1) {
				System.out.println("HaruHaru");
				//프로그램 종료
				System.exit(0);
			}
			
				for(int k=0; k<2; k++) {
					int ny = i + dy[k] * map[i][j];
					int nx = j + dx[k] * map[i][j];
					//만약 범위를 벗어나면 continue
					if(ny>=n || nx>=n) {
						continue;
					}//if
//					visited[ny][nx] = true;
					//재귀로 호출
					dfs(ny,nx, n);
				}//for
			}//private
}
