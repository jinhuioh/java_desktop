package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
//배낭문제 알고리즘 공부
//방법 2 : 다이나믹 프로그래밍 (DP)
//DP는 큰 문제를 작은 문제로 쪼개서 푸는 방법이다. DP로 해결하려면 각각의 물건이 있는지 없는지를 생각해야 한다.
//
// 
//
//위에서 소개한 문제처럼 물건 ABCD가 있고 무게 제한이 5인 배낭 문제를 다음과 같이 표시하겠다
//
//NS ("ABCD", 5)
//
// 
//
//우선 마지막 물건 D가 가방에 있는 경우, 없는 경우로 나눌 수 있다. 
//
//즉, D가 있는 경우 NS(ABC, 1) + 10 (D가 있어서 배낭의 무게 제한은 1이 되고 가치 10을 더한다) 그리고 D가 가방에 없는 경우 NS(ABC, 5) + 0으로 나눌 수 있다.
//
// 
//
//그림으로 표시하면 다음과 같다.

//N : 물건들의 개수
//
//W : 현재 상태의 무게 제한
//
// 
//
//NS (N-1, W - W [n]) + val [n] : n번째 물건을 배낭에 넣은 경우. 해당 물건을 넣었기 때문에 기존 무게에서 n번째 물건의 무게를 빼줘야 한다. 그리고 n번째 물건의 가치를 더해야 하므로 val [n]을 더한다.
//
// 
//
//NS (N-1, W) : n번째 물건이 없는 경우. 배낭에 물건을 추가하지 않았기 때문에 무게 W는 그대로이다.
//
// 
//
//이 점화식에는 변수가 N, W, 총 2가지 이므로 2차원 DP 테이블을 만들어서 해결한다.
//
// 
//
//세로축이 N, 가로 측이 W를 나타낸다. 우리는 이 예제에서 물건 ABCD 4개가 있고 무게 제한이 5이므로 NS (4, 5)를 구해야 한다. 즉 밑에 있는 테이블에서 빨간색으로 표시되어있는 공간을 구해야 한다.

// https://propercoding.tistory.com/50

public class codingTest7 {
	public static void main(String[] args) throws IOException{
	}
}

