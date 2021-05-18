
import structure5.*;

public class Recursion {

	/**
	 * Return number of cannoballs in pyramid with the given `height`.
	 *
	 * @param height the height of the cannonball tower
	 * @return the number of cannonballs in the entire tower
	 * @pre height is an integer greater than 0
	 */
	public static int countCannonballs(int height) {
		if (height == 1) {
			return 1;
		}

		return ((height * height) + countCannonballs(height - 1));
	}

	/**
	 * A method that determines if a string reads the same forwards
	 * and backwards.
	 *
	 * @param str the string to check
	 * @return true if `str` is a palindrome.
	 * @pre str is lowercase
	 */
	public static boolean isPalindrome(String str) {

		if (str.length() <= 1) {
			return true;
		}

		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);

		if (first == last) {
			return isPalindrome(str.substring(1, str.length()-1));
		} else {
			return false;
		}

	}

	/**
	 * Checks whether `str` is a string of properly nested and matched
	 * parens, brackets, and braces.
	 *
	 * @param str a string of parens, brackets, and braces
	 * @return true if str is properly nested and matched
	 * @pre str is only composed of parens, brackets, and braces
	 */
	public static boolean isBalanced(String str) {
		if (str.length() < 1) {
			return true;
		}

		if (str.indexOf("{}") > - 1) {
			return isBalanced(str.substring(0, str.indexOf("{}")) +
				str.substring(str.indexOf("{}") + 2));
		}

		if (str.indexOf("[]") > - 1) {
			return isBalanced(str.substring(0, str.indexOf("[]")) +
				str.substring(str.indexOf("[]") + 2));
		}

		if (str.indexOf("()") > - 1) {
			return isBalanced(str.substring(0, str.indexOf("()")) +
				str.substring(str.indexOf("()") + 2));
		}

		return false;
	}

	/**
	 * A method to print all subsequences of str (order does not matter).
	 *
	 * @param str string to print all subsequences of
	 */
	public static void subsequences(String str) {

		if (str.equals("")) {
			System.out.print(str + " ");
		} else {
			subsequenceHelper(str, str);

			str = str.substring(1);
			subsequences(str);
		}
	}

	/**
	 * Helper method for subsequences()
	 * `soFar` keeps track of the characters currently in the substring
	 * being built
	 */
	protected static void subsequenceHelper(String str, String soFar) {

		if (str.equals("")) {
			;
		}
		else {
			System.out.print(str + " ");

			str = str.substring(0, str.length() - 1);
			subsequenceHelper(str, soFar);
		}
	}


	/**
	 * A method to print the binary digits of a number.
	 *
	 * @param number the number to print in binary
	 * @pre number is a nonnegative integer
	 */
	public static void printInBinary(int number) {
		if (number <= 1) {
			System.out.print(number % 2);
		} else {
			printInBinary(number / 2);
			System.out.print(number % 2);
		}
	}


	/**
	 * Return whether a subset of the numbers in nums add up to sum,
	 * and print them out.
	 */
	public static boolean printSubsetSum(int[] nums, int targetSum) {

		//call helper function starting with full array
		return printSubsetSumHelper(nums, targetSum, 0);

	}

	public static boolean printSubsetSumHelper(int[] nums, int targetSum, int index) {

		// base case: if go though enture array, return whether target sum was achieved
		if (index == nums.length) {
			return targetSum == 0;
		}
		// cycle through all combinations of elements of nums
		// when unwinding, print elements of succesful combination
		if (printSubsetSumHelper(nums, targetSum - nums[index], index + 1)) {
			System.out.print(nums[index] + " ");
			return true;
		} else {
			return printSubsetSumHelper(nums, targetSum, index + 1);
		}
	}


	/**
	 * Return the number of different ways elements in nums can be
	 * added together to equal sum (you do not need to print them all).
	 */
	public static int countSubsetSumSolutions(int[] nums, int targetSum) {

		//call helper function, starting with enture array
		return countSubsetSumSolutionsHelper(nums, targetSum, 0);

	}

	public static int countSubsetSumSolutionsHelper(int[] nums, int targetSum, int index) {

		//base case, whether path through tree was successful or not
		if (index == nums.length) {
			if (targetSum == 0)
				return 1;
			else
				return 0;
		}

		//run through every possible path down the tree until get t base case
		return countSubsetSumSolutionsHelper(nums, targetSum - nums[index], index + 1) +
		countSubsetSumSolutionsHelper(nums, targetSum, index + 1);
}




	/***********************************************************/

	/**
	 * Code to test each recursive function
	 */

	protected static void testCannonballs() {
		System.out.println("Testing cannonballs: ....");
		System.out.println(countCannonballs(3));
		System.out.println(countCannonballs(10));
	}

	protected static void testPalindrome() {
		System.out.println("Testing isPalindrome: ....");
		System.out.println(isPalindrome("mom"));
		System.out.println(isPalindrome("deeded"));
		System.out.println(isPalindrome("ablewasIereIsawelba"));
		System.out.println("");
	}

	protected static void testBalanced() {
		System.out.println("Testing isBalanced: ....");
		System.out.println(isBalanced("[{[()()]}]"));
		System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
		System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));
	}

	protected static void testSubsequence() {
		System.out.println("Testing subsequences: ....");
		subsequences("abc");
		System.out.println();
		subsequences("CSCI136");
		System.out.println();
		subsequences("a");
		System.out.println();
		subsequences("");
		System.out.println();
	}

	protected static void testBinary() {
		System.out.println("Testing printInBinary: ....");
		printInBinary(0);
		System.out.println();
		printInBinary(30);
		System.out.println();
		printInBinary(1);
		System.out.println();
		printInBinary(110);
		System.out.println();
		printInBinary(2048);
		System.out.println();
		printInBinary(43);
		System.out.println();
    	}

	protected static void testCanMakeSum() {
		System.out.println("Testing canMakeSum: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(canMakeSum(numSet, 21));
		System.out.println(canMakeSum(numSet, 22));
		System.out.println(canMakeSum(numSet, 3));
		System.out.println(canMakeSum(numSet, 30));
	}

	protected static void testPrintSubsetSum() {
		System.out.println("Testing printSubsetSum: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(printSubsetSum(numSet, 21));
		System.out.println(printSubsetSum(numSet, 22));
		System.out.println(printSubsetSum(numSet, 3));
		System.out.println(printSubsetSum(numSet, 30));
	}

	protected static void testCountSubsetSum() {
		System.out.println("Testing countSubsetSumSolutions: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(countSubsetSumSolutions(numSet, 21));
		System.out.println(countSubsetSumSolutions(numSet, 22));
		System.out.println(countSubsetSumSolutions(numSet, 3));
		System.out.println(countSubsetSumSolutions(numSet, 30));
	}

	/**
	 * Main method that calls testing methods to verify
	 * the functionality of each exercise.
	 */
	public static void main(String[] args) {
		testCannonballs();
		testPalindrome();
		testBalanced();
		testSubsequence();
		testBinary();
		testCanMakeSum();
		testPrintSubsetSum();
		testCountSubsetSum();
	}
}
