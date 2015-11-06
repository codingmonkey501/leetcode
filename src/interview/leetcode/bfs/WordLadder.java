package interview.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import interview.leetcode.Pair;

public class WordLadder {

	
	/**
	 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

		Only one letter can be changed at a time
		Each intermediate word must exist in the dictionary
		For example,
		
		Given:
		start = "hit"
		end = "cog"
		dict = ["hot","dot","dog","lot","log"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.
		
		Note:
		Return 0 if there is no such transformation sequence.
		All words have the same length.
		All words contain only lowercase alphabetic characters.
	 */
	public static void main(String[] args){
		HashSet<String> dict = new HashSet<String>();
		dict.add("hat");
		dict.add("lat");
		dict.add("lot");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("log");
		dict.add("cog");
		
		new WordLadder().ladderLength("hit", "cog", dict);
	}

	//how this is the shortest? all the possible transmission is stored in the queue
	//the queue make sure the first found one must be the shortest one
	public int ladderLength(String start, String end, HashSet<String> dict) {

		LinkedList<Pair<String, Integer>> wordQueue = new LinkedList<Pair<String, Integer>>();

		wordQueue.add(new Pair<String, Integer>(start, 1));

		while (!wordQueue.isEmpty()) {
			Pair<String, Integer> word = wordQueue.pop();
			String currWord = word.getLeft();
			Integer currDistance = word.getRight();

			if (currWord.equals(end)) {
				return currDistance;
			}

			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;

					String newWord = new String(currCharArr);
					if (dict.contains(newWord)) {
						wordQueue.add(new Pair<String, Integer>(newWord, currDistance + 1));
						dict.remove(newWord);
					}
				}
			}
		}

		return 0;
	}
}
