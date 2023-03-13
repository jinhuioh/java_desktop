package codingTest;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//문제
//정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
//2를 곱한다.
//1을 수의 가장 오른쪽에 추가한다. 
//A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
//
//입력
//첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
//
//출력
//A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
//
//예제 입력 1 
//2 162
//예제 출력 1 
//5
public class codingTest6 {
	static int answer;
	static long n,m;
	static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i<size; i++) {
				long qp = q.poll();
				if(qp==m) {
					return ++answer;
				}
				if(qp*2<=m) q.add(qp*2);
				if(qp*10+1<=m) q.add(qp*10+1);
			}
			answer++;
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		m = sc.nextLong();
		System.out.println(bfs());
		
	}
}