package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class codingTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		알바생 강호
		//큰수부터 정렬을 한다!
//		입력
//		첫째 줄에 스타박스 앞에 서 있는 사람의 수 N이 주어진다. N은 100,000보다 작거나 같은 자연수이다. 
//		둘째 줄부터 총 N개의 줄에 각 사람이 주려고 하는 팁이 주어진다. 팁은 100,000보다 작거나 같은 자연수이다.
//
//		출력
//		강호가 받을 수 있는 팁의 최댓값을 출력한다.
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = Integer.parseInt(br.readLine());
//		// 팁의 최대값 변수
//		// n의 최대값이 100,000이므로 int로 변수를 생성하면 오버플로우 문제가 발생할 수 있기 때문에 long으로 변수를 잡아준다.
//		long answer = 0;
//		
//		//팁들을 넣을 리스트 변수
//		List <Integer> tips = new ArrayList<Integer>();
//		for(int i=0; i<n; i++) {
//			//tip입력받기
//			int tip = Integer.parseInt(br.readLine());
//			tips.add(tip);
//		}
//		//큰 수부터 정렬
//		Collections.sort(tips, Collections.reverseOrder());
//		
//		//받을 수 있는 팁의 최대값 구하기
//		for(int j=0; j < tips.size(); j++) {
//			int tipget = 0;
//			//음수인 경우 팁 받지 않음
//			tipget = (tips.get(j)-(j));
//			if(tipget < 0) {
//				tipget = 0;
//			}
//			answer += tipget;
//		}//for
//		System.out.println(answer);
		
		//안테나
//		입력
//		첫째 줄에 집의 수 N이 자연수로 주어진다. (1≤N≤200,000) 둘째 줄에 N채의 집에 위치가 공백을 기준으로 구분되어 1이상 100,000이하의 자연수로 주어진다.

//		출력
//		첫째 줄에 안테나를 설치할 위치의 값을 출력한다. 단, 안테나를 설치할 수 있는 위치 값으로 여러 개의 값이 도출될 경우 가장 작은 값을 출력한다.

		// 정렬해서 가운데 값으로 출력

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		//집의 개수 입력받기// 구지 double로 안받아서 범위문제는 일어나지 않는다..int로 해도 됨.
//		double n = Integer.parseInt(br.readLine());
//		
//		//집 입력받기
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		//집을 리스트에 하나씩 넣기
//		List<Double> nums = new ArrayList<Double>();
//		for(int i=0; i<n; i++) {
//			nums.add((double) Integer.parseInt(st.nextToken()));
//		}
//		
//		//정렬하기
//		Collections.sort(nums);
//		//가운데 값 찾기
//		double midnum = nums.get((int)((n-1)/2));
//	System.out.println((int)midnum);
		
		
		//카드 문자열
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		for(int i=0; i<n; i++) {
//			//문자개수 입력
//			int num = Integer.parseInt(br.readLine());
//			//문자입력
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			//답이 될 리스트 생성
//			LinkedList<String> nlist = new LinkedList<String>();
//			//입력받은 문자를 하나씩 뽑아서 리스트에 붙여줌
//			//첫 단어 add
//			nlist.add(st.nextToken());
//			for(int k=1; k<num; k++) {
//				String word = st.nextToken();
//				//리스트 0번째 값보다 다음값이 크다면
//				if(word.compareTo(nlist.getFirst())>0) {
//					nlist.addLast(word);
//					
//				}
//				else {
//					nlist.addFirst(word);
//				}//else	
//			}//for
//			for(int l=0; l<nlist.size(); l++) {
//				System.out.print(nlist.get(l));
//			}
//			//개행
//			System.out.println();
//		}//for
		
		
		
	}
	

}
