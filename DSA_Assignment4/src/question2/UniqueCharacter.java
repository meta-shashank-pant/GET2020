package question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueCharacter {

	private static HashMap<String, Integer> stringDB = new HashMap<>();
	
	static int getUniqueChar(String strInput) {
		int answer = 0;
		if(stringDB.containsKey(strInput)) {
			System.out.println("Value found in DB");
			answer = stringDB.get(strInput);
		}
		else {
			List<Character> strList = new ArrayList<Character>();
			for(int i = 0; i < strInput.length(); i++)
				strList.add(strInput.charAt(i));
			Set<Character> uniqueChar = new HashSet<Character>(strList);
			answer = uniqueChar.size();
			stringDB.put(strInput, answer);
		}
		return answer;
	}
}
