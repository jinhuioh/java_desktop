package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
//문제:얼음깨기
//도도는 심심해서 보드게임 카페에 갔다. 마침 평소에 즐겨 했던 얼음 깨기 펭귄의 업그레이드 버전으로 특수 얼음 깨기 펭귄 보드게임이 나와 직접 플레이해 보기로 결정했다. 특수 얼음 깨기 펭귄 게임은 특수 안경이 있어 특수 안경을 끼고 얼음들을 보면 얼음들 간의 연결 관계가 보인다.
//
//특수 얼음 깨기 펭귄 게임에 있는 얼음의 종류로는 지지대의 역할을 하는 얼음과 일반 얼음 총 2가지의 얼음이 존재한다. 지지대의 역할을 하는 얼음의 경우,
//빨간색으로 구분하여 볼 수 있으며 일반 얼음을 지탱해 주어 일반 얼음들이 깨지지 않도록 도와준다.
//일반 얼음의 경우에는 1개의 지지대만이 연결되어 있어도 얼음이 깨지지 않지만 펭귄이 올라가 있는 얼음은 2개 이상의 지지대의 역할을 하는 얼음이 연결되어 있어야만 얼음이 깨지지 않는다.
//이때, 지지대가 연결되어 있다는 것은 지지대로부터 서로 다른 일반 얼음들을 통해 연결 관계가 이어져 있는 것을 이야기한다.
//특수 얼음 깨기 펭귄 게임에서 도도가 펭귄을 떨어뜨리지 않고 최대 몇 개의 얼음을 깰 수 있을까?
//		입력
//		첫째 줄에 얼음 블록의 개수 
//		$N$(
//		$ 3 \leq N \leq 328\,000$)과 지지대의 역할을 하게 되는 얼음의 개수 
//		$S$(
//		$ 2 \leq S \leq N-1$), 펭귄이 위치한 얼음 블록의 번호 
//		$P$(
//		$ S \lt P \leq N$)가 주어진다. 지지대의 역할을 하게 되는 얼음의 개수가 
//		$S$일 때, 
//		$1$번부터 
//		$S$번까지의 얼음은 지지대의 역할을 한다.
//
//		둘째 줄부터 
//		$N-1$개의 줄에 두 개의 정수 
//		$A$, 
//		$B$가 주어진다. 이는 
//		$A$번 얼음과 
//		$B$번 얼음이 연결되어 있음을 의미하며 같은 연결은 여러 번 주어지지 않는다.
//
//		게임 시작 시 펭귄은 일반 얼음 위에 위치해 있고 어떤 얼음도 깨지지 않은 상태로 시작하게 된다. 각 얼음들은 
//		$1$번부터 
//		$N$번까지 정수 번호로 주어져 있으며 서로 다른 두 얼음을 잇는 경로는 하나뿐이다. 더불어 서로 다른 지지대가 펭귄이 올라가 있는 얼음을 거치지 않고 연결되어 있는 경우는 없다.
//
//		출력
//		플레이어가 펭귄을 떨어트리지 않고 깰 수 있는 얼음의 최대 개수를 구하여라. 지지대의 역할을 하는 얼음 역시 깰 수 있는 얼음에 속한다.
//
//		예제 입력 1 
//		21 6 12
//		1 9
//		1 10
//		10 12
//		2 13
//		13 11
//		11 12
//		3 8
//		8 7
//		8 12
//		5 19
//		5 14
//		14 12
//		6 20
//		6 21
//		20 15
//		15 12
//		4 18
//		4 17
//		17 16
//		16 12
		
public class codingTest7 {
	static int n,s,p;//블록,지지대블록,펭귄위치
	static ArrayList<Integer> list[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//함수실행. 펭귄 위치부터 지지대까지의 거리
		//매개변수로 다음점(이동점),현재위치,카운트를 준다.
		dfs(p, -1, 0);
		Collections.sort(answer);
		System.out.println(n-answer.get(0)-answer.get(1)-1);
	}
	static List<Integer> answer = new ArrayList<Integer>();
	private static void dfs(int nxt, int cur, int count) {
		//만약 시작 위치가 s범위 안에 있다면 지지대이므로 answer에 add
		if(nxt >=1 && nxt<=s) {
			answer.add(count);
			return;
		}
		for(int i = 0; i<list[nxt].size(); i++) {
			int next = list[nxt].get(i);
			if(next != cur) {//이동위치가 현재 위치와 다르다면 재귀호출
				dfs(next, nxt, count+1);
			
			}
		}
	}
}
		
		
//		n = Integer.parseInt(st.nextToken());
//		s = Integer.parseInt(st.nextToken());
//		p = Integer.parseInt(st.nextToken());
//		
//		list = new ArrayList[n+1];
//		for(int i = 0; i<n+1; i++) {
//			list[i] = new ArrayList<>();
//		}
//		
//		for(int i = 0; i<n-1; i++) {
//			//연결된 블록들 값 받기
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			list[a].add(b);
//			list[b].add(a);
//		}//for
//		
//		dfs(p, -1, 0);//펭귄의 위치, -1은 의미없는 초기값, 0은 한 칸씩 이동할때 마다 +1할 초기값.
////	answer.sort((o1,o2) -> o1-o2);//o1-o2가 음수면 o1을 더 낮은 인덱스로, 양수면 o2를 더 낮은 인덱스로 지정하는 함수..Collections.sort(answer);와 같음.
//		Collections.sort(answer);
//		System.out.println(n-1-answer.get(0)-answer.get(1));
//		}
//	
//	static ArrayList<Integer> answer = new ArrayList<Integer>();

//	static void dfs(int cur, int parent, int cnt) {
//		if(1<= cur && cur<=s) {//현재 위치가 지지대위치와 같다면 answer 리스트에 add(펭귄으로부터 지지대까지의 위치이므로)
//			answer.add(cnt);
//			return;
//		}
//		for(int i = 0; i<list[cur].size(); i++) {
//			int next = list[cur].get(i);//cur에는p가 들어감. 펭귄의 위치와 연결된 i블럭을 next로 지정.
////			펭귄이 한 칸 움직인 후parent 의 위치와 같지 않다면(당연히 같지 않아야 dfs를 호출하기 때문에 parent=-1로 줌.)
////			두번째 부터는 이동값이 지금 현재 값과 같지 않다면 재귀 호출.
//			if(next != parent) {
//				dfs(next, cur, cnt+1);
//			}
//		}
//	}
//		
//}

