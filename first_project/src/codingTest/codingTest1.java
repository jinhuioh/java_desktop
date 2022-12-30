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
//	세로로 입력
//	입력
//	총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다. 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다.
//
//	출력
//	영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[15][15];
		for(int i=0; i<5; i++) {
			String words = br.readLine();
			for(int j=0; j<words.length(); j++) {
				map[j][i] = words.charAt(j);
			}
		}//for
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(map[i][j]=='\0') {
					continue;
				}
				System.out.print(map[i][j]);
			}
		}
	}

}
