package codingTest;
import java.util.*;

public class codingTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		while(n != 0) {
			if(n%2 == 0) {
				n = n/2;
			}
			else {
				n = n-1;
				count++;
			}
		}
		
		System.out.println(count);
	
	    }
	}