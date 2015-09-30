package dp;

public class EditDistance {
	public static void main(String[] args) {
		String str1 = "Bangalore";
		String str2 = "Jaipur";

		//System.out.println(editDist(str1, str2, str1.length(), str2.length()));
		 System.out.println(editDistDP(str1,str2));
	}

	private static int editDistDP(String str1, String str2) {
		// TODO Auto-generated method stub
		int[][] valueStore = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			valueStore[i][0] = i;
		}

		for (int j = 0; j <= str2.length(); j++) {
			valueStore[0][j] = j;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1))
					valueStore[i][j] = Math.min(valueStore[i][j - 1], Math.min(
							valueStore[i - 1][j - 1], valueStore[i - 1][j]));
				else
					valueStore[i][j] = Math.min(valueStore[i][j - 1], Math.min(
							valueStore[i - 1][j - 1], valueStore[i - 1][j])) + 1;
			}
		}
		return valueStore[str1.length()][str2.length()];
	}

	private static int editDist(String str1, String str2, int m, int n) {
		// TODO Auto-generated method stub
		if (m == 0 && n == 0)
			return 0;

		if (m == 0)
			return n;

		if (n == 0)
			return m;

		// Recurse
		int one = editDist(str1, str2, m - 1, n) + 1;
		int two = editDist(str1, str2, m, n - 1) + 1;
		int three = editDist(str1, str2, m - 1, n - 1) + 1;
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			three = editDist(str1, str2, m - 1, n - 1);

		return Math.min(one, Math.min(two, three));
	}
}
