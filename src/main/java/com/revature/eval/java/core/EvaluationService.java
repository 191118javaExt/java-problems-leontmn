package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		/*Logic:
			- Input: "robot" as parameter
			- Analysis: inputs a word, need to output the word in reverse order
			- Action:
				1) convert input string to array of characters ['r','o','b','o','t']
				2) use a for loop backwards
					for (int i = 5; i > 0; i--)
				3) String newString = 't' 'o' 'b' 'o' 'r'
					newString "tobor"
				4) return newString
	
			- Output: "tobor"
		*/
		
		//System.out.println(string); // input string is "robot"
		//String inputValue = string;
		String outputStr = "";
		
		if (string.isEmpty()) { return "";}
		else {	
			// first create a character array of the input string "robot"
			char[] arr = string.toCharArray(); // ['r','o','b','o','t']
			
			for (int i = arr.length; i > 0; i--) {
				char newChar = arr[i-1];
				//System.out.println(cVal);
				outputStr += newChar;				
			}
			
		}
		//System.out.println(outputStr);
		return outputStr;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		/*Logic:
			- Input: phrase = "Portable Network Graphics";
			- Analysis: inputs a phrase, need to grab the first character of each word 
							  and output it
			- Action:
				1) use String.split to put the words into an array of Strings
				2) loop through the array and grab the first character of each word
				   using String.CharAt()
				3) assign the characters into into StringBuilder and return the value
		
			- Output: expected = "PNG"
		*/
		
		StringBuilder sb = new StringBuilder();
		
		String[] arrStr = phrase.split(" "); //split by space char to separate the words
		
		//use for loop to grab the first character of each word
		for (int i = 0; i < arrStr.length; i++) {
			String word = arrStr[i];
			
			//check if it is a compound word using hyphen, split by hyphen
			//then loop through the inner words and grab first character
			if (word.contains("-")) {
				String[] innerWords = word.split("-");
				for (int j = 0; j < innerWords.length; j++) {
					sb.append(innerWords[j].charAt(0));
				}
				
			}else {
				sb.append(arrStr[i].charAt(0));
			}
		}
		//System.out.println(output.toUpperCase());
		
		// make sure to return the results in upper case!
		return sb.toString().toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		/*Logic:
			- Input: three doubles 5, 4, 6
			- Analysis: 
				- we want to check 3 sides if they are all equal.
				- we want to check 3 sides if they are all not equal
				- now check if only 2 sides are equal
			- Action:
				1) check if isEquilateral: side1 == side2 == side3
				2) check if isScalene: side1 != side2 != side3
				3) check if isIsosceles: 
					((sideOne == sideTwo) || 
					(sideOne == sideThree) || 
					(sideTwo == sideThree))
			- Output: To check if the sides are isEquilateral, isScalene, isIsosceles
		*/
		
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if ((sideOne == sideTwo) && (sideTwo == sideThree)) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if (!isEquilateral() && !isScalene()) {
				//System.out.println("Is not equilateral or scalene");
				if ((sideOne == sideTwo) || (sideOne == sideThree) || (sideTwo == sideThree)) {
					return true;
				}
			}
			return false;
		}

		public boolean isScalene() {
			if ((sideOne != sideTwo) && 
				(sideTwo != sideThree) &&
				(sideThree != sideOne)) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		/*Logic: Not so efficient, but can simplify or refactor further
			- Input: a word
			- Analysis:
						- need to determine the points for each letter and add it up
			- Action:
						- declare groups of character array
						- declare a HashMap
						- create a for loop for the groups of character array and populate the HashMap
						- loop through each letter of the word and look up the letter in the HashMap
						- Then get the point of how much that letter is worth
						- Add up the points and return the total
			- Output: total points for the input word
		
		*/
		
		int totalPoints = 0;
		// populate char arrays of the letter groups
		char[] arrOne = {'A','E','I','O','U','L','N','R','S','T'};
		char[] arrTwo = {'D','G'};
		char[] arrThree = {'B','C','M','P'};
		char[] arrFour = {'F','H','V','W','Y'};
		char[] arrFive = {'K'};
		char[] arrEight = {'J','X'};
		char[] arrTen = {'Q','Z'};		
		
		// create a HashMap for lookup
		Map<Character, Byte> charMap = new HashMap<Character, Byte>();
		
		// populate charMap and assign corresponding values for each letter groups
		for (int i = 0; i < arrOne.length; i++) {
			charMap.put(arrOne[i], (byte) 1);
		}
		for (int i = 0; i < arrTwo.length; i++) {
			charMap.put(arrTwo[i], (byte) 2);
		}
		for (int i = 0; i < arrThree.length; i++) {
			charMap.put(arrThree[i], (byte) 3);
		}
		for (int i = 0; i < arrFour.length; i++) {
			charMap.put(arrFour[i], (byte) 4);
		}
		for (int i = 0; i < arrFive.length; i++) {
			charMap.put(arrFive[i], (byte) 5);
		}
		for (int i = 0; i < arrEight.length; i++) {
			charMap.put(arrEight[i], (byte) 8);
		}
		for (int i = 0; i < arrTen.length; i++) {
			charMap.put(arrTen[i], (byte) 10);
		}
		
		//System.out.println(string);
		for (int i = 0; i < string.length(); i++) {
			if (charMap.get(string.toUpperCase().charAt(i)) != null) {
				byte point = charMap.get(string.toUpperCase().charAt(i));
				totalPoints += point;				
			}			
		}
		//System.out.println(totalPoints);
		return totalPoints;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		/*Logic:
			- Input: various phone number format
			- Analysis: need to clean up the phone number to get digits only 
						and check if there are only 10 numbers
			- Action: 
						- create a StringBuilder local variable to return final values
						- loop through each character of the input string
						- use isDigit in Character class to check if the char is a number
						- if is a number append the character into StringBuilder local variable
			- Output: return 10 digit numerical phone numbers
		*/
		
		StringBuilder cleanedNumber = new StringBuilder();
		
		// parsing the input value string into a Char array
		// then loop through it and check if the character is a number
		// if is a number append the chars back into a string
		for (char c : string.toCharArray()) {
			if(Character.isDigit(c)) {
				cleanedNumber.append(c);
			}
		}
		
		// check if the cleaned number is not exactly 10 digits, throw exception error
		// otherwise return cleanedNumber
		if (cleanedNumber.length() != 10) {
			throw new IllegalArgumentException();
		}
		
		//System.out.println(cleanedNumbers);
		return cleanedNumber.toString();
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		/*Logic:
			- Input: a string phrase
			- Analysis:
						- get unique list of word from the phrase
						- count occurrences of each word
						- put the word and number of occurrences into a HashMap
						- return the HashMap
			- Action:
						- Split the string into a String array
						- add unique words into a HashSet with value of 1 if not exist
						- if exists get the value of the word and increment it, then update the key value
						- loop through the String array and count the words
			- Output: return a HashMap with key (word), and value (number of occurrences)
		*/
		//System.out.println("========" + string.replace("\n", "") + "========");
				
		Map<String, Integer> output = new HashMap<String, Integer>();
		
		String[] words = string.replace("\n", "").split(" |,");
		for (String word : words) {
			if (output.containsKey(word)) {
				int value = output.get(word);
				output.replace(word, ++value);
			}else {
				output.put(word, 1);
			}
		}
		
		/*
		Iterator iter = output.entrySet().iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		*/
		
		return output;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// create a list of vowels
		List<String> vowelsArr = Arrays("aeiou".toCharArray());
		// is the output to return string variable
		String output = ""; 
		
		// Separates the input string into words by space char if we get phrases
		String[] words = string.split(" ");	
		String prevChar = "";
		
		// if only one word
		if (words.length == 1) {
			//System.out.println(words[0]);
			StringBuilder sb = new StringBuilder(words[0]);
			
			// puts the word characters into a String array
			List<String> charArr = Arrays(words[0].toCharArray());
			
			// loops through the array			
			for (String i:charArr) {	
				// if char is a vowel break the loop and add "ay" to the end of sb
				if (vowelsArr.contains(i)) {
					// special conditional check, sometimes in pigLatin u goes with q
					if (i.equals("u") && prevChar.equals("q")) {
						sb.insert(sb.length(), "qu");
					}else {
						output = (sb.toString() + "ay");
					}
					break;
				}
				else { // if char is not a vowel, append char to the end of the current sb, delete at index 0
					//System.out.println(i);
					sb.insert(sb.length(), i);
					sb.deleteCharAt(0);
				}
				prevChar = i;
			}
		}else { // if more than one word
			int wordCount = 0;
			for (String word: words) {	
				wordCount++;
				StringBuilder sb = new StringBuilder(word);
				List<String> charArr = Arrays(word.toCharArray());
				//System.out.println(word);
				for (String i:charArr) {
					// special conditional check, sometimes in pigLatin u goes with q
					if (i.equals("u") && prevChar.equals("q")) {
						// deletes first index and last index "q"
						sb.deleteCharAt(0);						
						sb.deleteCharAt(sb.length()-1);
						sb.append("qu");
						//System.out.println(sb);
					}else if (vowelsArr.contains(i)) {
						// trim the last space for the last word in loop
						if (wordCount == words.length) {
							sb.append("ay");
						}else {
							sb.append("ay ");
						}
						
						output += (sb.toString());
						break;
					}
					else {
						//System.out.println(i);
						sb.append(i);
						sb.deleteCharAt(0);
					}
					prevChar = i;
				}
			}
		}
		
		//System.out.println(output);
		
		return output;
	}

	private List<String> Arrays (char[] charArray) {
		List<String> outputArr = new ArrayList<>();
		for(Character c:charArray) {
			outputArr.add(c.toString());
		}
		return outputArr;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//System.out.println(input);
		// add input string into char array
		char[] charArr = Integer.toString(input).toCharArray();
		
		// set power or exponent to the length of the num of digits
		int power = String.valueOf(input).length();
		int sum = 0;
		
		// loop through the char array
		for(Character c:charArr) {
			// parse the c into an integer
			int x = Integer.parseInt(c.toString());
			// use Math power method and sum up the result
			sum += Math.pow(x, power);
		}
		//System.out.println(sum);
		if (sum == input) {
			return true;
		}
		
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long numL = l;
		List<Long> factors = new ArrayList<>();
		//System.out.println("Input: " + l);
		
		// start a for loop with the lowest prime number of 2
		// loop until 
		for(long factor = 2; factor<=numL; factor++) {
			while(numL % factor == 0) {
				// found a factor that is divisible without remainder
				// add to the factors list
				factors.add(factor);
				
				// here we want to check only on the second factor and keep simplying down
				// 901255 / 5 = 180251
				// 180251 / 17 = 10603
				// 10603 / 23 = 461
				// 461 cannot be further simply, so that's the lowest prime factor
				numL /= factor;
			}
		}
		
//		for(Long i: factors) {
//			System.out.println(i);
//		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		String letters = "abcdefghijklmnopqrstuvwxyz";
		boolean isLowerCase = false;
		
		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuilder sbWords = new StringBuilder();			
			sbWords.append(GetCipher(string));
			//System.out.println(sbWords.toString());
			return sbWords.toString();			
		}
		
		// added a private method to keep code clean and re-usable
		// input the word, loops through each character
		// get index of the character in the letters array
		// use a for loop for the length of "key" and increment the index
		// if index equals 26, reset index to 0 and continue incrementing until loop exists
		// then grab the character from the letters array by the final index
		
		private String GetCipher(String word) {
			StringBuilder sbChars = new StringBuilder();
			for(Character c : word.toCharArray()) {
				String cLower = c.toString().toLowerCase();
				
				isLowerCase = c.toString().equals(cLower) ? true : false;
				int index = letters.indexOf(cLower);
				if (index !=-1) {
					for (int i = 0; i < key; i++) {
						index++;
						if (index == 26) {
							index = 0;
						}				
					}
					//System.out.println(letters.charAt(index));
					if (isLowerCase) {
						sbChars.append(letters.charAt(index));
					}else {
						sbChars.append(letters.toUpperCase().charAt(index));
					}
				}else {
					sbChars.append(c);
				}
			}
			return sbChars.toString();
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// check if input is less than or equals zero, throw exception
		if (i <= 0) {
			throw new IllegalArgumentException();
		}
		
		int numToLoop = i;
		int output = 0;

        int countPrime = 0;
        int x;
        
        // loops nth time
        // if output is not a prime number, keep looping until it
        // reaches the nth prime number
        while (countPrime < numToLoop){
        	output+=1;
        	for (x = 2; x <= output; x++){
        		if (output % x == 0) {
        			break;
        		}
        	}
        	// checks of x equals output, then increment
        	if (x == output){
        		countPrime = countPrime+1;
        	}
        }
        //System.out.println(String.format("%s prime is: %s", numToLoop, output));

		return output;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		
		public static String encode(String string) {
			String plainArr = "abcdefghijklmnopqrstuvwxyz";
			char[] cipArr = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
			//clean up input string, removing all punctuation and spaces
			String input = string
					.replaceAll("[^a-zA-Z0-9\\s]", "")
					.replace(" ", "")
					.toLowerCase();
			
			//System.out.println(input);
			StringBuilder outSB = new StringBuilder();
			int counter = 0;
			
			// loop through each character of the input string
			// get the index of the character in the plain letter arrays
			// get the cipher letter using the index
			// append character to SB

			for(Character c: input.toLowerCase().toCharArray()) {
				int index = plainArr.indexOf(c);
				if (index !=-1) {
					char tempC = cipArr[index];
					
					if (counter >= 5) {					
						outSB.append(" " + tempC);
						counter = 1;
					}else {					
						outSB.append(tempC);
						counter++;
					}
				}else {
					outSB.append(c);
					counter++;
				}
			}
			//System.out.println(outSB.toString());
			return outSB.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			char[] plainArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			String cipArr = "zyxwvutsrqponmlkjihgfedcba";
			
			String input = string.replace(" ", "");
			//System.out.println(input);
			StringBuilder outSB = new StringBuilder();
			
			// loop through each character of the input string
			// get the index of the character in the cipher letter arrays
			// get the plain letter using the index
			// append character to SB
			for(Character c: input.toLowerCase().toCharArray()) {				
				int index = cipArr.indexOf(c);
				if (index != -1) {
					char tempC = plainArr[index];
					outSB.append(tempC);
				}else {
					outSB.append(c);
				}
			}
			//System.out.println(outSB.toString());
			return outSB.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String input = string;
		
		// get numbers only and last char and store in char arrays
		char[] numChars = input.replaceAll("[^0-9\\s]", "").toCharArray();
		char lastChar = input.toLowerCase().charAt(string.length()-1);
		int sum = 0;
		
		// if not 10 digits or 9 digits and lastchar is not X, return false
		if (numChars.length !=10 && (numChars.length == 9 && lastChar != 'x')){
			return false;
		}
		
		// loop through the numbers and multiply each number by counter from 10 to 1
		// add the result to sum
		for (int i = 0; i < numChars.length; i++) {
			int num = Character.getNumericValue(numChars[i]);
			sum += num * (10 - i);
			//System.out.println(String.format("%s * %s = %s", num, 10 - i, num * (10 - i)));
		}
		
		// check if the last char is X, then add 10
		if (lastChar == 'x') {
			sum += 10;
		}
		//System.out.println(sum);
		//System.out.println(sum % 11);

		// divide the sum by 11 modulus and return true if no remainders
		if (sum % 11 == 0){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// create two set collection to hold the 26 letters and the unique input
		// string characters. Later we want to compare the two sets
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Set<Character> setLetters = new HashSet<>();
		Set<Character> inputSet = new HashSet<>();
		
		// get only alpha characters
		String input = string.replaceAll("[^a-zA-Z]+", "");
		//System.out.println(input);
		
		// base check if string is empty, return false
		if (string.isEmpty()) {
			return false;
		}
				
		// add the string letters into the letters set
		for(Character c: letters) {
			setLetters.add(c);
		}
		
		// add the characters of the input string into the input set
		for(Character c: input.toLowerCase().toCharArray()) {
			inputSet.add(c);
		}
		
		//System.out.println(setChar);
		//System.out.println(inputSet);
		//System.out.println(setChar.equals(inputSet));
		
		return setLetters.equals(inputSet);
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// Can exclude
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int maxValue = i;
		int[] setNums = set;
		
		// create a set of integer to store the unique multiples
		Set<Integer> multiples = new HashSet<>();
		int total = 0;
		
		// loop through the set of input integers
		// multiply each factor by 1,2,3,4...not over the maxValue
		for (int j = 0; j < setNums.length; j++) {
			int currNum = setNums[j];
			for (int j2 = 1; currNum * j2 < maxValue; j2++) {
				int sum = currNum * j2;
				multiples.add(sum);
				//System.out.println(String.format("%s * %s = %s", currNum, j2, sum));
			}
		}
		
		// add up the multiples
		for(Integer num: multiples) {
			total += num;
		}
		
		//System.out.println(total);
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		// check if string contains non-digit characters, return false
		String checkPunct = string.replaceAll("[0-9\\s]", "");		
		if (checkPunct.length() != 0) {
			//System.out.println(string);
			return false;
		}
		
		String clean = string.replaceAll("[^0-9]+", "");
		//List<Integer> nums = new ArrayList<>();
		int total = 0;
		
		// loops through the input string and grab every other number starting
		// at the 2nd number from the right store into Num2
		// grab every other number starting at the 1st number from the right
		// and store into Num1
		
		for (int i = clean.length() - 1; i > 0 ; i-=2) {
			int num1 = Character.getNumericValue(clean.charAt(i));
			int num2 = Character.getNumericValue(clean.charAt(i - 1));
			
			// double the num2 value
			num2 *= 2;
			
			// if after doubling the num2 value and is greater than 9, subtract 9
			if (num2 > 9) {
				num2 -= 9;
			}
			
			// add up the two numbers
			total += (num1 + num2);
			//System.out.println(num + "," + num2);
			//nums.add(num);
			//nums.add(num2);
		}
		//Collections.reverse(nums);
		//System.out.println(nums);
		if (total % 10 == 0) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		// create constant string values for the 4 math operators
		final String PLUS = "PLUS";
		final String MINUS = "MINUS";
		final String MULTIPLIED = "MULTIPLIED";
		final String DIVIDED = "DIVIDED";
		
		String operater = "";
		String input = string.toUpperCase();
		String[] parts = new String[0];
		
		int total = 0;
		
		// check for the string word for each operators
		if (input.toUpperCase().contains(PLUS)) {
			parts = input.split(PLUS);
			operater = PLUS;
		}else if (input.contains(MINUS)) {
			parts = input.split(MINUS);
			operater = MINUS;
		}else if (input.contains(MULTIPLIED)) {
			parts = input.split(MULTIPLIED);
			operater = MULTIPLIED;
		}else if (input.contains(DIVIDED)) {
			parts = input.split(DIVIDED);
			operater = DIVIDED;
		}
		
		// get just the integer values from the string
		int num1 = Integer.parseInt(parts[0].replaceAll("[^0-9\\-]", ""));
		int num2 = Integer.parseInt(parts[1].replaceAll("[^0-9\\-]", ""));
		//System.out.println(String.format("%s %s %s", num1, operater, num2));
		
		// use a switch statement on the operator variable to determine
		// which operator to use for the two numbers and do the calculation
		switch(operater) {
			case PLUS:
				total = num1 + num2;
				break;
			case MINUS:
				total = num1 - num2;
				break;
			case MULTIPLIED:
				total = num1 * num2;
				break;
			case DIVIDED:
				total = num1 / num2;
				break;				
		}
		
		//System.out.println(total);
		return total;
	}

}
