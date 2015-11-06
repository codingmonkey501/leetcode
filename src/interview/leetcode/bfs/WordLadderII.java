package interview.leetcode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class WordLadderII {

	
	/**
	 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

		Only one letter can be changed at a time
		Each intermediate word must exist in the dictionary
		For example,
		
		Given:
		start = "hit"
		end = "cog"
		dict = ["hot","dot","dog","lot","log"]
		Return
		  [
		    ["hit","hot","dot","dog","cog"],
		    ["hit","hot","lot","log","cog"]
		  ]
		Note:
		All words have the same length.
		All words contain only lowercase alphabetic characters.
	 */
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {

		List<List<String>> result = new ArrayList<List<String>>();
		if (start == null || end == null)
			return result;

		// start == end , return
		ArrayList<String> path = new ArrayList<String>();
		if (start.equals(end)) {
			path.add(start);
			path.add(end);
			result.add(path);
			return result;
		}

		// hash map store pre of every node
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put(end, new ArrayList<String>());
		map.put(start, new ArrayList<String>());
		for (String str : dict) {
			map.put(str, new ArrayList<String>());
		}

		// BFS
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);

		while (!queue.isEmpty()) {
			ArrayList<String> nextwords = new ArrayList<String>();
			for (int i = 0; i < queue.size(); i++) {
				String top = queue.poll();
				if (dict.contains(top))
					dict.remove(top);
				nextwords.add(top);
			}

			// check char a to z
			for (String currStr : nextwords) {
				for (int i = 0; i < currStr.length(); ++i) {
					for (char c = 'a'; c <= 'z'; ++c) {
						char[] tmpchar = currStr.toCharArray();
						tmpchar[i] = c;
						String nextStr = new String(tmpchar);

						if (!currStr.equals(start) && nextStr.equals(end)) {
							map.get(end).add(currStr);
							queue.add(nextStr);
						} else if (!nextStr.equals(currStr) && dict.contains(nextStr)) {
							if (!queue.contains(nextStr))
								queue.add(nextStr);
							map.get(nextStr).add(currStr);
						}
					}
				}
			}
			if (queue.contains(end))
				break;
		}

		path.add(end);
		this.buildpath(start, end, map, path, result);
		return result;
	}

	private void buildpath(String start, String end, HashMap<String, ArrayList<String>> map, ArrayList<String> path, List<List<String>> result) {

		ArrayList<String> pres = map.get(end);
		if (end.equals(start)) {
			ArrayList<String> reversedPath = new ArrayList<String>(path);
			Collections.reverse(reversedPath);
			result.add(reversedPath);
			return;
		}
		for (String pre : pres) {
			path.add(pre);
			buildpath(start, pre, map, path, result);
			path.remove(path.size() - 1);
		}

	}
}
