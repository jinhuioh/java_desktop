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
	static int n,p1,p2;
	static int[][] map;
	static int[] answer_map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//위치 넣을 배열//사람숫자를 1부터 세므로 n+1까지 배열의 범위를 만들어주어야한다.
		map = new int[n+1][n+1];
		//정답증가시킬 배열
		answer_map = new int[n+1];
		
		//구해야하는 변수값
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		//촌수 개수
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}//for
		bfs(p1, p2);
		if(answer_map[p2]==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer_map[p2]);
		}
	}
	//함수생성
	private static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		//start부터 탐색 시작
		q.add(start);
		while(!q.isEmpty()) {
			int qpoll = q.poll();
			//end값이면 종료
			if(qpoll == end) {
				break;
			}//if
			//탐색하기
			for(int i=1; i<=n; i++) {
				if(map[qpoll][i] ==1 && answer_map[i] == 0) {
					answer_map[i] = answer_map[qpoll]+1;
					q.add(i);
				}
			}//for
		}
	}
}
