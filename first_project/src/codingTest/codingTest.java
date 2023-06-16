package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
//
//상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
//
//또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
//
//퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
//
//상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
//
//둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
//
//출력
//첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
//
//예제 입력 1 
//7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200
//예제 출력 1 
//45
public class codingTest {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n+15];
		int[] p = new int[n+15];
		int[] arr = new int[n+15];
		
		for(int i = 0; i<n; i++) {
			int t_one = sc.nextInt();
			int p_one = sc.nextInt();
			t[i] = t_one;
			p[i] = p_one;
		}
		int answer = 0;
		for(int i = 0; i<=n; i++) {
			arr[i] = Math.max(arr[i], answer);
			arr[i+t[i]] = Math.max(arr[i+t[i]], p[i] + arr[i]);
			answer = Math.max(answer, arr[i]);
		}//for
		System.out.println(answer);
	}
}