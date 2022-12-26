package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest2 {
//	입력
//	입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다. 젤리는 오른쪽과 아래로만 이동 가능
//
//	입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.
//
//	게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.
//
//	출력
//	‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력합니다.

// 	입력 예제:	
//	3
//	1 1 10
//	1 5 1
//	2 2 -1
	static int[][] map;
	static boolean[][] visited;//방문했으면 true로 바꿀 배열. 기본값은 false이다.
	static int n;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for
		}//for
		
		//0,0부터 시작
		bfs(0, 0);
		//-1에 도달 할 수 없어 System.exit(0);로 프로그램이 종료되지 않는다면 Hing프린트
		System.out.println("Hing");
	}//public
	
	//재귀이용
	//visited 갱신과 map의 위치 이동할 함수
	private static void bfs(int i, int j) {
		//만약 마지막 위치라면
		if(map[i][j]==-1) {
			System.out.println("HaruHaru");
			//종료
			System.exit(0);
		}//if
		//오른쪽 또는 아래로만 위치 이동
		for(int k=0; k<2; k++) {
			int y = i + dy[k]*map[i][j];
			int x = j + dx[k]*map[i][j];
//			System.out.println("y>>"+y+" x>>"+x);
			//이동위치가 만약 map을 벗어나면 continue. 또는 이미 방문했던 곳이면 패스
			if(y>=n || x>=n || visited[y][x]) continue;
			//visited값 갱신
			visited[y][x] = true;
			//이동할 수 있는 위치이면 재귀로 함수 호출
			bfs(y, x);
		}//for
	}//private
}