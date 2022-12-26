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
		
		// - 개수
		// -나오면 count = 1로 바꿨다가 ㅣ 나오면 count = 0으로 초기화
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
//				System.out.println("arr[i][j]>>"+i+j+arr[i][j]);
				if(arr[i][j] == '|') {
//					System.out.println("l인경우 count>> "+count);
//					System.out.println("l인경우 answer>> "+answer);
					count=0;
				}//if
				//행이 바뀌는데 첫번째-의 경우 count의 값을 0으로 초기화
				else if(j == 0 && arr[i][j] == '-') {
					count=0;
				}//else if
				if(count == 0 && arr[i][j] == '-') {
					count=1;
					//정답 개수 증가 시키기
					answer++;
//					System.out.println("-인경우 count>> "+count);
//					System.out.println("-인경우 answer>> "+answer);
				}//else if
			}//for
		}//for
		
		// | 개수
		int count2 =0;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if(arr[i][j] == '-') {
					count2=0;
				}//if
				//열이 바뀌고 행이1인데 이전 열 마지막값과 다음열 첫번째 값이 |인 경우
				else if(i == 0 && arr[i][j] == '|') {
					count2=0;
				}//else if
				if(count2 == 0 && arr[i][j] == '|') {
					count2=1;
					//정답 개수 증가 시키기
					answer++;
				}//else if
			}//for
		}//for
		System.out.println(answer);
	    }
}
