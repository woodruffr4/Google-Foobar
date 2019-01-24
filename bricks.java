// Accepted

import java.util.Arrays;
import java.util.Scanner;

public class bricks {

	public static int[][] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i=1; i<=200; i++) {
			System.out.println(answer(i));
		}
		
	}

	public static int answer(int bricks) {

		dp = new int[201][201];
		for (int i=0; i<201; i++) {
			Arrays.fill(dp[i],-1);
		}

		int res = 0;

		for (int i=bricks-1; i>=2; i--) {
			int right = bricks-i;
			int left = i;
			if(right>=left) {
				int add = subsetSum(left-1,right);
				res+=add;
			} else {
				int add = subsetSum(right,right);
				res+=add;
			}
			

		}
		return res;
	}

	public static int subsetSum(int curNum, int sum) {
		if(dp[curNum][sum]!=-1) return dp[curNum][sum];
		if(sum==0) return 1;
		if(curNum == 0 && sum!=0) return 0;
		if(curNum > sum) return dp[curNum][sum]=subsetSum(curNum-1,sum);
		return dp[curNum][sum]=(subsetSum(curNum-1, sum) + subsetSum(curNum-1, sum-curNum));
	}
}