package mbryshten.blockingqueue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommonString {
	
	public String getCommonString(String str1, String str2) {
		
		String res = "";
		
		Map<Character, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < str2.length(); i++) {
			
			Character c = str2.charAt(i);
			
			if(map.containsKey(c)) {
				
				map.get(c).add(i);
				
			} else {
				
				List<Integer> list = new LinkedList<>();
				
				list.add(i);
				
				map.put(c, list);
			}
		}
		
		Iterator it = map.entrySet().iterator();
	    
		while (it.hasNext()) {
	        
			Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
		
		int cur = 0;
		
		for(int i = 0; i < str1.length(); i++) {
			
			Character c = str1.charAt(i);
			
			if(map.containsKey(c)) {
				
				List<Integer> list = map.get(c);
				
				if(list.size() >0) {
					
					Integer ind = list.get(0);
					
					if(ind >= cur) {
						
						cur = ind;
						
						list.remove(0);
						
						res += c;
					}
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {

		CommonString c = new CommonString();
		
		String str1 = "abcdefak";
		String str2 = "hbrcbrtkm";
		
		String res = c.getCommonString(str1, str2);
		
		System.out.println(res);
	}

}
