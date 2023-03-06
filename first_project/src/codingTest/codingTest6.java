package codingTest;
import java.io.*;
import java.util.*;
//문제: 헌내기는 친구가 필요해
//2020년에 입학한 헌내기 도연이가 있다. 도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다. 드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다. 
//
//도연이가 다니는 대학의 캠퍼스는 
//$N \times M$ 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다. 예를 들어, 도연이가 (
//$x$, 
//$y$)에 있다면 이동할 수 있는 곳은 (
//$x+1$, 
//$y$), (
//$x$, 
//$y+1$), (
//$x-1$, 
//$y$), (
//$x$, 
//$y-1$)이다. 단, 캠퍼스의 밖으로 이동할 수는 없다.
//
//불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.
//
//입력
//첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수 
//$N$ (
//$ 1 \leq N \leq 600$), 
//$M$ (
//$ 1 \leq M \leq 600$)이 주어진다.
//
//둘째 줄부터 
//$N$개의 줄에는 캠퍼스의 정보들이 주어진다. O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.
//
//출력
//첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.
//
//예제 입력 1 
//3 5
//OOOPO
//OIOOX
//OOOXP
//예제 출력 1 
//1
class node1{
	int y,x;
	node1(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class codingTest6 {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static Queue<node1> q = new LinkedList<>();
	static int[] dy = {0,0,1,-1};
	static int[] dx = {-1,1,0,0};
	
	private static int bfs() {
		int answer = 0;
		while(!q.isEmpty()) {
			node1 qp = q.poll();
			for(int k = 0; k<4; k++) {
				int ny = qp.y + dy[k];
				int nx = qp.x + dx[k];
				if(ny<0 || nx<0 || ny>=n || nx>=m || visited[ny][nx] || map[ny][nx] == 'X') continue;
				if(map[ny][nx] == 'P') {
					answer++;
				}
				q.add(new node1(ny,nx));
				visited[ny][nx] = true;
			}
		}
		
		return answer;
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
				if(map[i][j]=='I') {
					visited[i][j] = true;
					q.add(new node1(i,j));
				}
			}
		}
		int answer = bfs();
		if(answer == 0) {
			System.out.println("TT");
		}else {
			System.out.println(answer);
		}
	}
}