package codingTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//문제
//전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다. 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
//문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
//
//N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가? 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
//
//입력
//첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다.
//모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.
//
//출력
//첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
//
//예제 입력 1 
//5 5
//WBWWW
//WWWWW
//BBBBB
//BBBWW
//WWWWW
//예제 출력 1 
//130 65
class node {
	int y;
	int x;
	node(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest3 {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<node> q;
	
	private static int bfs(int i, int j) {
		int count = 0;//병사의 수 카운트
		
		q = new LinkedList<node>();
		q.add(new node(i, j));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			node qp = q.poll();
			for(int k=0; k<4; k++) {
				int ny = dy[k] + qp.y;
				int nx = dx[k] + qp.x;
				if(ny>=0 && nx>=0 && ny<n && nx<m && !visited[ny][nx] && map[i][j]==map[ny][nx]) {
					q.add(new node(ny, nx));
					visited[ny][nx] = true;
					count++;
				}
			}
		}//while
		return count+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		//map 입력받기
		map = new char[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = s.charAt(j);
			}//for
		}//for
		
		//B팀의 최대값
		int B_max = 0;
		//W팀의 최대값
		int W_max = 0;
		//병사의 위력 구하기
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!visited[i][j]) {
					int count = bfs(i, j);
					if(map[i][j] == 'B') {
						B_max += count*count;
					}
					else {
						W_max += count*count;
					}
				}//if
			}//for
		}//for
		System.out.print(W_max+" "+B_max);
    }
}


