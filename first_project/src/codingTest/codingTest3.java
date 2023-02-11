package codingTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//문제: 물통
//각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 이 과정에서 손실되는 물은 없다고 가정한다.
//
//이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 세 정수 A, B, C가 주어진다.
//
//출력
//첫째 줄에 공백으로 구분하여 답을 출력한다. 각 용량은 오름차순으로 정렬한다.
//
//예제 입력 1 
//8 9 10
//예제 출력 1 
//1 2 8 9 10

public class codingTest3 {

	static int[] limit;
	static boolean[][] check;
	static Set<Integer> answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		limit = new int[3];
		check = new boolean[201][201];
		for(int i=0; i<3; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new TreeSet<>();
		dfs(0,0, limit[2]);
		
		for(int num : answer) {
			System.out.print(num+" ");
		}
	}
	static void dfs(int a, int b, int c){
		if(check[a][b]) return;
		
		if(a==0) {
			answer.add(c);
		}
		check[a][b] = true;
		// 0 -> 1
		if(a+b > limit[1]) {
			dfs((a+b)-limit[1], limit[1], c);
		}else {
			dfs(0, a+b, c);
		}
		
		// 1 -> 0
		if(a+b > limit[0]) {
			dfs(limit[0], a+b-limit[0], c);
		}else {
			dfs(a+b, 0, c);
		}
		
		// 2 -> 0
		if(a+c > limit[0]) {
			dfs(limit[0], b, a+c-limit[0]);
		}else {
			dfs(a+c, b, 0);
		}
		
		
		// 2 -> 1
		if(b+c > limit[1]) 	{
			dfs(a, limit[1], b+c-limit[1]);
		}else {
			dfs(a, b+c, 0);
		}
		
		// 0 -> 2
		dfs(a, 0, b+c);
		// 1 -> 2
		dfs(0, b, a+c);
	}
}