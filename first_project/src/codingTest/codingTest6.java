package codingTest;
import java.io.*;
import java.util.*;
//문제 : 양치기 꿍
//양치기 꿍은 맨날 늑대가 나타났다고 마을 사람들을 속였지만 이젠 더이상 마을 사람들이 속지 않는다. 화가 난 꿍은 복수심에 불타 아예 늑대들을 양들이 있는 울타리안에 마구 집어넣어 양들을 잡아먹게 했다.
//
//하지만 양들은 보통 양들이 아니다. 같은 울타리 영역 안의 양들의 숫자가 늑대의 숫자보다 더 많을 경우 늑대가 전부 잡아먹힌다. 물론 그 외의 경우는 양이 전부 잡아먹히겠지만 말이다.
//
//꿍은 워낙 똑똑했기 때문에 이들의 결과는 이미 알고있다. 만약 빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k'라고 나타낸다면 여러분은 몇 마리의 양과 늑대가 살아남을지 계산할 수 있겠는가?
//
//단, 울타리로 막히지 않은 영역에는 양과 늑대가 없으며 양과 늑대는 대각선으로 이동할 수 없다.
//
//입력
//입력의 첫 번째 줄에는 각각 영역의 세로와 가로의 길이를 나타내는 두 개의 정수 R, C (3 ≤ R, C ≤ 250)가 주어진다.
//
//다음 각 R줄에는 C개의 문자가 주어지며 이들은 위에서 설명한 기호들이다.
//
//출력
//살아남게 되는 양과 늑대의 수를 각각 순서대로 출력한다.
//
//예제 입력 1 
//6 6
//...#..
//.##v#.
//#v.#.#
//#.k#.#
//.###.#
//...###
//예제 출력 1 
//0 2
class node1{
	int y,x;
	node1(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
	static int n,m, k_answer, v_answer;
	static char[][] map;
	static boolean[][] visited;
	static Queue<node1> q = new LinkedList<>();
	static int[] dy = {0,0,1,-1};
	static int[] dx = {-1,1,0,0};
	
	private static void bfs(int i, int j) {
		int k_num = 0;
		int v_num = 0;
		if(map[i][j]=='v') {
			v_num = 1;
		}
		else {
			k_num = 1;
		}
		
		visited[i][j] = true;
		q.add(new node1(i,j));
		
		while(!q.isEmpty()) {
			node1 qp = q.poll();
			for(int t = 0; t<4; t++) {
				int ny = qp.y + dy[t];
				int nx = qp.x + dx[t];
				
				if(ny<0|| nx<0 || ny>=n || nx>=m || map[ny][nx]=='#' || visited[ny][nx]) continue;
				if(map[ny][nx] == 'v') {
					v_num ++;
				}
				else if(map[ny][nx] == 'k') {
					k_num++;
				}
				 visited[ny][nx] = true;
				 q.add(new node1(ny,nx));
				
			}
		}//while
		if(v_num>=k_num) {
			v_answer += v_num;
		}
		else {
			k_answer += k_num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = s.charAt(j); 
			}//for
		}//for
		
		k_answer = 0;
		v_answer = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 'k' || map[i][j] == 'v') {
					if(!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
		}//for
		System.out.println(k_answer +" "+ v_answer);
	}
}