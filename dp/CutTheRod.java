package dp;
/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * @author hansraj.choudhary
 *
 */
public class CutTheRod {

	public static void main(String[] args) {
		int[] cost = { 3, 7, 8, 10, 12 };
		int n = 5;
		//int maxCost = getMaxCost(n, cost);
		int maxCost = getMaxCostDP(n, cost);
		System.out.println(maxCost);
	}

	private static int getMaxCost(int n, int[] cost) {
		// TODO Auto-generated method stub
		if (n <= 0)
			return 0;
		int maxCost = -1;
		for (int i = 0; i < n; i++) {
			maxCost = Math.max(maxCost, cost[i] + getMaxCost(n-i-1, cost));
		}
		
		return maxCost;
	}
	
	private static int getMaxCostDP(int n, int[] cost) {
		// TODO Auto-generated method stub
		int[] storedValues = new int[n+1];
		storedValues[0] = 0;
		for (int i = 0; i < n; i++) {
			int maxCost = -1;
			
			for(int j = 0; j<=i; j++)
			{
				maxCost = Math.max(maxCost, cost[j] + storedValues[i-j]);
			}
			storedValues[i+1] = maxCost;
		}
		
		return storedValues[n];
	}
}
