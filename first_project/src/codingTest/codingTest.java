package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class codingTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		알바생 강호
		//큰수부터 정렬을 한다!
//		입력
//		첫째 줄에 스타박스 앞에 서 있는 사람의 수 N이 주어진다. N은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 총 N개의 줄에 각 사람이 주려고 하는 팁이 주어진다. 팁은 100,000보다 작거나 같은 자연수이다.
//
//		출력
//		강호가 받을 수 있는 팁의 최댓값을 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		// 팁의 최대값 변수
		int answer = 0;
		
		//팁들을 넣을 리스트 변수
		List <Integer> tips = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) {
			//tip입력받기
			int tip = Integer.parseInt(br.readLine());
			tips.add(tip);
		}
		//큰 수부터 정렬
		Collections.sort(tips, Collections.reverseOrder());
		
		for(int j=0; j < tips.size(); j++) {
			int tipget = 0;
			//음수인 경우 팁 받지 않음
			tipget = (tips.get(j)-(j));
			if(tipget < 0) {
				tipget = 0;
			}
			answer += tipget;
		}//for
		System.out.println(answer);

	}

}
