package codingTest;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class codingTest1 {

	public static void main(String[] args) throws IOException {
//		수리공 항승

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//물 새는 곳 개수
		int l = Integer.parseInt(st.nextToken());//테이프길이
		
		//답이 될 변수
		int answer = 0;
		
//		고장난 파이프 입력받기
		int[] pipes = new int[n];
//		토큰으로 한줄입력받아서 한개씩 끊어서 int로 형변환 후 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<pipes.length; i++) {
			pipes[i] = Integer.parseInt(st.nextToken());
		}
		//sort로 작은수부터 리스트에 담기도록 한다
		Arrays.sort(pipes);
//		System.out.println("pipes>> "+pipes);
		
		
		float pnum = 0;//테이프
		
		for(int j=0; j<pipes.length; j++) {
//			리스트에 있는 원소 하나씩 꺼내서  pint 에 담기
			int pint = (int) pipes[j];
//			System.out.println("pint"+pint);
//			System.out.println(pipes.length+" "+j);
			// 리스트에서 꺼 낸 원소가 짧아서 테이프를 붙어야하는 경우
			if(pnum < pint + 0.5) {
				answer +=1;
				//붙인 테이프의 마지막위치 pnum 갱신
				pnum = (float) (pint+l-(0.5));
//				System.out.println("pnum>> "+pnum);
			}else {
				// 리스트에서 꺼 낸 원소가 길어서 테이프를 붙이지않아도 되는 경우
				continue;
			}//else
		}//for
		System.out.println(answer);
	}

}
