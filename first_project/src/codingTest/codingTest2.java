package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codingTest2 {
//촌수계산
//	입력
//	사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
//	둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
//	넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
//
//	각 사람의 부모는 최대 한 명만 주어진다.
//
//	출력
//	입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다
//	//예제입력
//	9
//	7 3
//	7
//	1 2
//	1 3
//	2 7
//	2 8
//	2 9
//	4 5
//	4 6

	static int n,m,p1,p2;
	static int[][] map;
	static int[]d;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//사람 전체 수 입력
		n = Integer.parseInt(br.readLine());
		//사람수만큼 map범위 설정
		map = new int[n+1][n+1];
		d = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		//구해야하는 사람 번호
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		//촌수개수
		m = Integer.parseInt(br.readLine());

		for(int i=0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			
			//map에 넣기 촌수는 서로 연결되어있는 것이므로 x,y에 넣고 y,x에도 넣어준다.
			map[x][y]=1;
			map[y][x]=1;
		}//for

		//d배열로 촌수를 세는 함수를 호출
		bfs(p1, p2);
		if(d[p2]==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(d[p2]);
		}
		
	}
	private static void bfs(int start, int end) {
		//queue 생성
		Queue<Integer> q = new LinkedList<Integer>(); 
		//시작값 넣기
		q.add(start);
		
		//end가 될 때까지 while문돌면서 촌수 증가시키기
		while(!q.isEmpty()) {
			int qpoll = q.poll();
			if(qpoll==end) {
				break;
			}//if
			for(int i=1; i<=n; i++) {
				//촌수를 센 적없고 && 촌수가 연결되어 있는 경우 
				if(d[i]==0 && map[qpoll][i]==1) {
					//세어준다.
					d[i] = d[qpoll]+1;
					//세어준 위치로 이동
					q.add(i);
				}//if
			}//for
		}//while
	}//private
}
