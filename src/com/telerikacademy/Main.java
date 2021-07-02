package com.telerikacademy;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

class WillYouMakeIt {
    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        return fuelLeft * mpg >= distanceToPump;
    }
}

class CalculateBMI {
    public static String bmi(double weight, double height) {
        double bmi = weight / Math.pow(height, 2);
        return bmi <= 18.5 ? "Underweight" : bmi <= 25.0 ? "Normal" : bmi <= 30.0 ? "Overweight" : "Obese";
    }
}

class TakeFirstNElementsOfArray {
    public static int[] take(int[] arr, int n) {
        return n > arr.length ? arr : Arrays.copyOf(arr, n);
    }
}

class TwiceAsOld {
    public static int twiceAsOld(int dadYears, int sonYears) {
        return Math.abs(dadYears - sonYears * 2);
    }

}

class TwoSum {

//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // Outer loop for the first element
            for (int j = i + 1; j < nums.length; j++) { // Inner loop to go through all other elements
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

class ReverseInteger {
//    Given a signed 32-bit integer x, return x with its digits reversed.
//    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    public int reverse(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

class PalindromeNumber {
    public boolean isPalindrome(int x) {
//        // STRING SOLUTION:
//        String rev = new StringBuilder().append(x).reverse().toString();
//        try {
//            return x >= 0 && x == Integer.parseInt(rev);
//        } catch (NumberFormatException e) {
//            return false;
//        }

        // NON-STRING SOLUTION:
        if (x < 0) return false;
        int rev = 0, remainder, original = x;

        while (x != 0) {
            remainder = x % 10; // getting the last digit of x
            rev = rev * 10 + remainder; // multiplying rev by 10 then adding the remainder so it gets stored at next decimal place.
            x /= 10;  //the last digit is removed from num after division by 10.
        }

        return original == rev;
    }
}

class RomanToInteger {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
     * The number 27 is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
     * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * <p>
     * Given a roman numeral, convert it to an integer.
     */

    public int romanToInt(String s) {

        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                sum -= nums[i];
            else
                sum += nums[i];
        }

        return sum + nums[nums.length - 1];
    }
}

class LongestCommonPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    */

    /* MY SOLUTION:

        public String longestCommonPrefix(String[] strs) {

            String[] sArr = strs[0].split("");

            String output = "";

            for (int i = 0; i < strs[0].length(); i++) { // Looping over each letter
                int index = 0;
                for (int j = 0; j < strs.length; j++) { // Looping over each word
                    try {
                        if (Character.toString(strs[j].charAt(i)).matches(sArr[i])) {
                            index++;
                        } else {
                            return output;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        return output;
                    }
                    output = (index == strs.length) ? output.concat(sArr[i]) : "";
                }
            }
            return output;
        }*/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) { // Checking each of the other words in the array
            while (strs[i].indexOf(pre) != 0) { // Each loop iteration cuts out the last letter until a full match is found
                pre = pre.substring(0, pre.length() - 1); // If no common prefix is found output is cut down to "" at which point indexOf("") returns 0
            }
        }
        return pre;
    }
}

class ValidParentheses {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    */

    public boolean isValid(String s) {

        if (s.equals("")) return false;

        while (s.length() > 0) {
            if (s.contains("()") || s.contains("{}") || s.contains("[]")) {
                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
            } else break;
        }

        return s.length() == 0;
    }
}

class CheckAnagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.trim().length() != s2.trim().length()) return false;

        // Purge all whitespaces, convert to lower case, feed into char array, and sort arrays:
        char[] arr1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return (Arrays.equals(arr1, arr2));
    }
}

class LongestNonMatching {
    public int longestNonMatching(String input) {

        String[] inputArr = input.split("");

        int longest = 1;
        int temp = 1;

        for (int i = 1; i < inputArr.length; i++) { // Iterate over all input chars
            if (inputArr[i - 1].matches("[^a-zA-Z.0-9\\s]")) { // Check only those that don't match the regex
                if (inputArr[i].matches("[^a-zA-Z.0-9\\s]")) { // If tested char is also a forbidden one - increase temp
                    temp++;
                } else {
                    longest = Math.max(longest, temp);
                    temp = 1;
                }
            }
        }

        if (longest == 1) {
            if (input.matches("[^a-zA-Z.0-9\\s]")) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return longest;
        }
    }
}

class MirrorPinCode {
    public int mirrorPinCode(String input) {

        // Creating StringBuilder for easy reversal and splitting input in the two values:
        StringBuilder sb = new StringBuilder();
        String[] inputArr = input.split(" ");

        // Initializing first temp variable to the reversed value of the first element in the array:
        int tempA = Integer.parseInt(String.valueOf(sb.append(inputArr[0]).reverse()));

        // Deleting stored value and replacing it with the second reversed value:
        sb.delete(0, 3);
        int tempB = Integer.parseInt(String.valueOf(sb.append(inputArr[1]).reverse()));

        return Math.max(tempA, tempB);
    }
}

class SortOrder {
    public String order(String input) {
        String[] inputArrStr = input.split(" ");
        int[] inputArrInt = new int[inputArrStr.length];

        for (int i = 0; i < inputArrStr.length; i++) {
            inputArrInt[i] = Integer.parseInt(inputArrStr[i]);
        }

        if (inputArrInt[0] > inputArrInt[1] && inputArrInt[1] > inputArrInt[2] && inputArrInt[2] > inputArrInt[3]) {
            return "Descending";
        } else if (inputArrInt[0] < inputArrInt[1] && inputArrInt[1] < inputArrInt[2] && inputArrInt[2] < inputArrInt[3]) {
            return "Ascending";
        } else {
            return "Mixed";
        }
    }
}

class ValidCardSign {
    public static String checkCard(String input) {
        String[] validCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String s : validCards) {
            if (input.equals(s)) {
                return "yes " + input;
            }
        }
        return "no " + input;
    }
}

class SumAndMultiplyThreeDigits {
    public static int calculate(int n) {
        String[] nArray = String.valueOf(n).split("");

        int a = Integer.parseInt(nArray[0]);
        int b = Integer.parseInt(nArray[1]);
        int c = Integer.parseInt(nArray[2]);

        // Calculating the biggest possible product of the three digits:
        int product = a * b * c;

        // Calculating the sum:
        int sum = a + b + c;

        // Calculating biggest possible sum and product combo from the digits in that order
        int sumProduct = a + (b * c);

        int output = Math.max(product, sum);

        return Math.max(output, sumProduct);
    }
}

class ForestRoad {

    public static void printPath(int n) {
        final int height = 2 * n - 1;
        String[][] forest2D = new String[height][n];

        // Filling the map with trees:
        for (String[] strings : forest2D) {
            Arrays.fill(strings, ".");
        }

        int p = 0;
        for (int i = 0; i < forest2D.length; i++) { // Iterating through each row
            forest2D[i][p] = "*"; // Setting the tree to an asterisk
            if (i < n - 1) { // Filling with asterisks until we reach the right border
                p++;
            } else { // Returning back
                p--;
            }
        }

        for (int i = 0; i < forest2D.length; i++) {
            for (int k = 0; k < forest2D[i].length; k++) {
                System.out.print(forest2D[i][k]);
            }
            if (i == forest2D.length - 1) {
                break;
            } else {
                System.out.println();
            }
        }
    }
}

class LeastMajorityMultiple {
    /*
    Given five positive integers, their least majority multiple is
    the smallest positive integer that is divisible by at least three of them.
    
    Your task is to write a program that for given distinct integers a, b, c, d and e,
    returns their least majority multiple.
    
    For example if we have 1, 2, 3, 4 and 5 the majority multiple of the given five numbers is 4
    because it is divisible by 1, 2, and 4.
    
    Another example: if we have 30, 42, 70, 35 and 90 the answer will be 210,
    because it is divisible by 30, 42, 70, and 35 - four out of five numbers, which is a majority.
    
    Input
    Read from the standard input
    The input data will consist of 5 lines.
    The numbers a, b, c, d and e will each be on a single line.
    The input data will always be valid and in the format described. There is no need to check it explicitly.
    
    Output
    Print on the standard output
    On the only output line you must print the least majority multiple of the given numbers.
    */

    public static void calculate(int[] input) {

        // Sorting input array to get the smallest value for temp:
        Arrays.sort(input);

        // Initializing final variable, intermediate counter to mark hits, and temp to test against:
        int lmm;
        int count = 0;
        int temp = input[0];

        // Looping until we get at least 3 hits:
        while (true) {
            count = 0; // Resetting count for every iteration
            for (int i : input) {
                if (temp % i == 0) { // If temp is divided by any of the input vars, increase count
                    count++;
                }
            }
            if (count >= 3) { // If we get 3 or more hits, assign the output var to temp and break out
                lmm = temp;
                System.out.print(lmm);
                break;
            }
            temp++; // Increase temp by 1 until we get the smallest number divisible by at least 3 of the input vars
        }
    }
}

class SignalFromSpace {
    /*
    Signal from Space
    One day a signal from space was registered. Scientists managed to record the signal as a sequence of N symbols.
    It turned out that due to a technical difficulty some symbols have been repeated.
    Help the scientists by writing a program which removes consecutive repetitions of symbols, decoding the message.

    Input:
    Input data is read from the standard input
    On the only input line, a message is given

    Output:
    Print to the standard output
    Print the decoded message

    Constraints:
    The length of the message will be no more than 10000 symbols
    Message consists of digits and Latin letters (upper and lower case)
    */

    public static StringBuilder decode(String input) {

        // Initializing ArrayList to store our broken down input string:
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("")));

        int i = 1;
        do {
            // If current element matches the one after it,
            // remove the current and decrease iterator by 1 to make up for the changing list size:
            if (inputList.get(i - 1).equals(inputList.get(i))) {
                inputList.remove(i - 1);
                i--;
            }
            // If we decreased the iterator before this line, we continue from the same index:
            i++;

            // Looping until we reach the end of the list
        } while (i != inputList.size());

        // Initializing an SB variable for output and appending the edited list values to it:
        StringBuilder output = new StringBuilder();
        for (String s : inputList) {
            output.append(s);
        }

        return output;
    }
}

class GoodNumbers {
    /*
    Добри числа
    Иванчо нарича едно число добро, ако то се дели на всяка негова цифра различна от 0.
    Например: - 13 не е добро - не се дели на 3 - 36 е добро - дели се на 3 и на 6 - 102 e добро - дели се на 1 и на 2 - 103 не е добро - не се дели на 3
    Помогнете на Иванчо като напишете програма, която намира броя на всички добри числа между дадени A и B (включително).
    
    Вход
    От първия ред се въвеждат числата A и B.
    
    Изход
    Изведете броя на добрите числа на единствен ред.
    */

    public static int count(String input) {

        // Initializing an integer array that contains both numbers by taking them from a String array that splits the input:
        String[] inputStr = input.split(" ");
        int[] inputArr = {Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1])};

        // If first number is 1, the good numbers count is always equal to the count of numbers between A and B:
        if (inputArr[0] == 1) return inputArr[1];

        boolean isGood;
        int count = 0;

        // Declaring temp String array to split the digits of the current iterator and
        // ArrayList to contain all digits without the 0s
        String[] tempArr;
        ArrayList<Integer> list = new ArrayList<>();

        // Iterator starts from the first number and goes up until it reaches the second number
        int ite = inputArr[0];

        while (ite <= inputArr[1]) {
            isGood = false;

            // Splitting ite into separate digits and adding them to list:
            tempArr = String.valueOf(ite).split("");
            for (String s : tempArr) {
                if (!s.equals("0")) list.add(Integer.parseInt(s));
            }

            // Iterating through each digit from ite and checking if it divides ite with no remainder
            // If it does - set isGood to true
            // If it doesn't - set it to false and break out of the loop
            for (int digit : list) {
                if (ite % digit == 0) {
                    isGood = true;
                } else {
                    isGood = false;
                    break;
                }
            }

            if (isGood) count++;

            // Clearing list for next number in the loop and increasing that number by 1
            list.clear();
            ite++;
        }

        return count;
    }
}

class BiggestPrimeNumber {
    /*
    Write a program that finds all prime numbers in the range 1 ... N. Use the Sieve of Eratosthenes algorithm.
    The program should print the biggest prime number which is <= N.
    
    Input
    On the first line you will receive the number N
    
    Output
    Print the biggest prime number which is <= N
    
    SIEVE PSEUDOCODE:
    input: an integer n > 1.
    output: all prime numbers from 2 through n.
    
    let A be an array of Boolean values, indexed by integers 2 to n, initially all set to true.
        for i = 2, 3, 4, ..., not exceeding √n do
            if A[i] is true
                for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n do
                    A[j] := false
    
    return all i such that A[i] is true.
    */

    public static int sieveOfEratosthenes(int n) {
        // Initializing the array and setting all values to true:
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            // If primes[i] is not changed to false, then it is a prime:
            if (primes[i]) {
                // Update all multiples of p to false:
                for (int j = i * i; j <= n; j += i)
                    primes[j] = false;
            }
        }

        for (int i = primes.length - 1; i >= 0; i--) {
            if (primes[i]) return i;
        }

        return 1;
    }
}

class ArraySearch {
    /*
    Array Search
    Given an array of integers, some elements appear twice and others appear once.
    Each integer is in the range of 1, N, where N is the number of elements in the array.

    Find all the integers of 1, N inclusive that do NOT appear in this array.

    Input
    Read from the standard input:
    There is one line of input, containing N amount of integers, seperated by a comma (",")

    Output
    Print to the standard output:
    There is one line of output, containing the sorted integers, seperated by a comma (",")
    */

    public static String missingSortedInts(String input) {

        // Splitting input string into String array and transferring that into an int array:
        String[] tempArr = input.split(",");
        int[] inputArr = new int[tempArr.length];

        for (int i = 0; i < tempArr.length; i++) {
            inputArr[i] = Integer.parseInt(tempArr[i]);
        }

        // Declaring an ArrayList variable to construct the output out of and a temp counter for matches:
        ArrayList<Integer> list = new ArrayList<>();
        int temp;

        // Iterating from 1 to N
        for (int i = 1; i <= inputArr.length; i++) {
            temp = 0;
            // Iterating through all input numbers and checking if i is in them:
            for (int k : inputArr) {
                if (k == i) {
                    temp++;
                }
            }
            // If i is not found, add it to the output list:
            if (temp == 0) list.add(i);
        }

        // Sorting the output list, declaring a SB variable and transferring the output to it for printing:
        Arrays.sort(list.toArray());
        StringBuilder output = new StringBuilder();

        for (int k : list) {
            output.append(k).append(",");
        }

        return output.length() > 0 ? output.substring(0, output.length() - 1) : "";
    }
}

class AboveTheMainDiagonal {
    /*
    You are given a square matrix of numbers, formed by powers of 2.

    Example: N = 4
    1  2  4  8
    2  4  8 16
    4  8 16 32
    8 16 32 64

    You task is to find the sum above the main diagonal.
    The result is: 2 + 4 + 8 + 8 + 16 + 32 = 70

    Input
    Read from the standard input
    On the first line, read the number N as the number of rows and columns

    Output
    Print to the standard output
    On the first line, print the sum of the numbers above the main diagonal except the diagonal
    */

    public static long calculateSum(int size) {
        if (size < 2) return 0;

        // Initializing variables:
        long[][] matrix = new long[size][size];
        long temp = 1;
        long sum = 0;

        // The rows loop starts at 1 instead of 0 because this provides for easier temp resetting and summing:
        for (int i = 1; i <= size; i++) {                           // Looping over the rows
            for (int j = 0; j < matrix[i - 1].length; j++) {        // Looping over the columns:
                matrix[i - 1][j] = temp;                            // Populating the matrix
                if (j >= i) sum += temp;                            // Summing up all values beyond the diagonal
                temp *= 2;                                          // Incrementing temp for the next column iteration
            }
            temp = (i == size) ? matrix[0][i - 1] : matrix[0][i];   // Resetting temp to the next power of 2
        }

        return sum;
    }
}

class CombineLists {
    /*
    Write a program that reads two lists of numbers and combines them by alternatingly taking elements:
    combine 1,2,3 and 7,8,9 -> 1,7,2,8,3,9
    you can assume that the input lists will have the same length.
    Print the resulting combined list to the output, separating elements with a comma.

    Input
    On the first line you will receive the first list.
    On the second line -> 2nd list.

    Output
    On the only line of output, print all the numbers in format n1,n2,n3,..n
    */

    public static StringBuilder merge(String a, String b) {

        // Initializing variables:
        String[] arr1 = a.split(",");
        String[] arr2 = b.split(",");
        StringBuilder output = new StringBuilder();

        // Appending each array element to the output SB:
        for (int i = 0; i < arr1.length; i++) {
            output.append(arr1[i]).append(",");
            output.append(arr2[i]).append(",");
        }

        // Deleting the last comma and returning the final SB:
        return output.delete(output.length() - 1, output.length());
    }
}

class MostFrequentArrayNumber {
    /*
    Write a program that finds the most frequent number in an array of N elements.

    Input
    On the first line you will receive the number N
    On the next N lines the numbers of the array will be given

    Output
    Print the most frequent number and how many time it is repeated
    Output should be REPEATING_NUMBER (REPEATED_TIMES times)

    Constraints
    1 <= N <= 1024
    0 <= each number in the array <= 10000
    There will be only one most frequent number
    */

    public static void find(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();

        // Initializing all unique keys with a value of 0:
        for (int i : input) {
            map.put(i, 0);
        }

        // Incrementing the value by 1 every time it's found:
        for (int i : input) {
            map.put(i, map.get(i) + 1);
        }

        // Initializing the max value and its key
        int maxValueKey = 0;
        int maxValue = Collections.max(map.values());

        // Iterating over each entry and comapring the value of each key with the max value
        // When the value matches we get the key and put it in maxValueKey for output purposes
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) maxValueKey = entry.getKey();
        }

        System.out.println(maxValueKey + " (" + maxValue + " times)");
    }
}

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] inputArr = s.split(" ");
        return (inputArr.length > 0) ? inputArr[inputArr.length - 1].length() : 0;
    }
}

class JumpGame {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
    */

    public boolean canJump(int[] nums) {
        if (nums[0] == 0) return false;
        if (nums.length == 1) return true;

        for (int i = 0; i < nums.length; i += nums[i]) {
            if (nums[i] >= nums.length) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{4, 3, 1, 1, 4}));
        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}

