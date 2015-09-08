package dp;

/**
 * 
 * @author hansraj.choudhary
 * @email hansrajchoudhary@gmail.com
 *
 */
//Simple implementation of max sum sub-rectangle in a 2-D arrays
public class MaxRectangleSum {
	
	public static void main(String[] args) {
	    int[][] M = {{ 1,  2, -1},
	                 {-8, -3,  4},
	                 { 3,  8, 10},
	                 { 4, -1,  1}
	                };
	    findMaxSum(M);	
	}

	/**
	 * 
	 * @param m 2-d array as input
	 * It will use the idea of 1-D array max sum contiguous subsequence solution
	 */
	private static void findMaxSum(int[][] m) {
		int maxSum = -1000;
		int numRows = m.length;
		int numCols = m[0].length;
		for(int i=0; i<numRows;i++)
		{
			//The array to store sub matrix sum
			int matsum[] = new int[numCols];
			for(int x = 0; x< numCols; x++)
				matsum[x] = 0;
			
			for(int j=i; j<numRows;j++)
			{
				int currS = 0;
				for(int c = 0; c< numCols;c++)
				{
					matsum[c] = matsum[c] + m[j][c];
					currS = currS + matsum[c];
					if(currS > maxSum)
					{
						maxSum = currS;
					}
					if(currS < 0)
					{
						currS = 0;
					}
				}
			}
		}
		System.out.println(maxSum);
	}
}