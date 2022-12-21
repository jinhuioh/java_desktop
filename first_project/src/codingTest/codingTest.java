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
		
		
		//초콜릿식사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//먹어야하는 초콜릿개수 입력k
		int k = Integer.parseInt(br.readLine());
		
		//쪼갤 수 있는 초콜릿 개수 리스트
		List<Integer> arr = new ArrayList<Integer>();
		
		int i=1;
		//초기값 입력
		arr.add(i);
		while (i < k) {
			i *= 2;
			arr.add(i);
			
		}//while
		
		//구매해야하는 초콜릿 크기. 배열의 마지막 값을 가져온다.
		int size = arr.get(arr.size()-1);
		//몇 번 쪼개는지
		int count = 0;
		
		
		//리스트 뒤부터 탐색
//		System.out.println("arr 사이즈는"+arr.size());
		//k와 arr마지막 값이 같은 경우
		if(k == size) {
		}//if

		else {
			for(int l=arr.size()-1; l>=0; l--) {
//				System.out.println("l은~ "+arr.get(l));
				if(arr.get(l) <= k) {
					k = k-arr.get(l);
//					System.out.println("k>> "+ k +"count>> "+ count);
				}
				count++;
				if(k==0) {
					//k가 0 이 되는 경우도 계산하므로 1을 빼준다.
					count = count-1;
					break;
				}//if
			}//for
		}//else
		System.out.print(size+" "+count);
		
		
	//리스트를 이용하지 않는 방법. 메모리상으로는 더 효율적인 것 같다..
//	Scanner scan = new Scanner(System.in);
//    int k1 = scan.nextInt();	
//	int size1 = 1;
//	int count1 = 0;
//	int size2 = 0;	
//	
//	while(size1 < k1) {
//		size1 = size1 * 2;
//		size2 = size1;
//	}
//	// K크기의 초콜릿을 얻기 위해서는 그와 같거나 큰 초콜릿이 필요하다.
//    // 2제곱근으로 증가한다고 하니 2씩 곱해주어 가장작은
//    // 초콜릿 크기를 구한다.
//    
//    
//	while(k1 > 0) {
//		if(k1>=size1) {
//			System.out.println("k가 size보다 크거나같"+"k"+k1+"size"+size1);
//			k1-=size1;
//		}else {
//			System.out.println("k가 size보다 작다"+"k"+k1+"size"+size1);
//			System.out.println("count"+count1);
//			size1 /= 2;
//			count1++;
//		}
//	}
//	//최소 초콜릿의 크기가 K보다 클경우 반으로 쪼개고
//    //count를 하나씩 더해준다.
//    //K 가 0보다 작아지면 해당 반복문을 중단한다.
//    
//    
//	System.out.println(size2+" " + count1);
		
	}
	

}
