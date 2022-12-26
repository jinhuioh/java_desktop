package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//바닥 장식
public class codingTest3 {
//	이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 
//	두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
//
//	기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.
//	입력
//	첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 
//	둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다.
//	N과 M은 50 이하인 자연수이다.
//
//	출력
//	첫째 줄에 문제의 정답을 출력한다.

	// 예제입력
//	6 9
//	-||--||--
//	--||--||-
//	|--||--||
//	||--||--|
//	-||--||--
//	--||--||-
//	
//	답: 31
	static int n;// 행
	static int m;// 열
	static int answer = 0;// 정답이 될 변수

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			// 한 줄 입력받기
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = row.charAt(j);
			} // for
		} // for
		

		
	    }
}
