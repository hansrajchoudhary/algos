package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("Length of LIS is "+ lis(arr, 0, arr.length-1));
		//System.out.println("Length of LIS is "+ lisDP(arr, 0, arr.length-1));
	}

	private static int lis(int[] arr, int start, int end) {
		if(start == end)
			return 1;
		
		int x = lis(arr, start, end-1);
		
		if(arr[end] > arr[end-1])
			return 1+x;
		else
			return x;
		
	}
	
	private static int lisDP(int[] arr, int start, int end) {
		List<List<Integer>> storedVals = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		first.add(arr[0]);
		storedVals.add(first);
		
		for(int i=1 ;i<arr.length;i++)
		{
			int max = -1;
			List<Integer> curr = new ArrayList<Integer>();

			for(int j = 0; j<i; j++)
			{
				List<Integer> last = storedVals.get(j);
				int lastNum = last.get(last.size()-1);
				int currMax = last.size();
				
				if(arr[i]>lastNum)
				{
					curr.clear();
					curr.addAll(last);
					curr.add(arr[i]);
					max = curr.size();
				}
				else
				{
					curr.clear();
					curr.addAll(last);
				}
			}
			System.out.println(curr.toString());
			storedVals.add(curr);
		}
		return storedVals.get(arr.length-1).size();
	}
}