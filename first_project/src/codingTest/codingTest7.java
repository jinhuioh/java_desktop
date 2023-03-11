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
//문제: 안녕
//세준이는 성형수술을 한 후에 병원에 너무 오래 입원해 있었다. 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게 감사하다고 말할 차례이다.
//
//세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다. 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
//
//세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 사람의 수 N(≤ 20)이 들어온다. 둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다. 체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.
//
//예제 입력 1 
//3
//1 21 79
//20 30 25
//예제 출력 1 
//50
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

