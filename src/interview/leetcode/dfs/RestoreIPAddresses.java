package interview.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	
	/**
	 * Given a string containing only digits, restore it by returning all possible 
	 * valid IP address combinations.

		For example:
		Given "25525511135",
		
		return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public static void main(String[] args) {
		RestoreIPAddresses r=new RestoreIPAddresses();
		r.restoreIpAddresses("0000");
		r.restoreIpAddresses("111111111111111111111111111");
		r.restoreIpAddresses("010010");
		r.restoreIpAddresses("00");
		
	}
	
	
	
	
    public List<String> restoreIpAddresses(String s) {
        
        List<String> list = new ArrayList<String>();
        if(s.length()>12)
            return list;
        restoreIpAddresses(s, 0, 0, "", list);
        return list;
    }
    
    
    public void restoreIpAddresses(String s, int start, int n, String ip, List<String> list) {
        
        if(n==4){
            if(start==s.length())
                list.add(ip.substring(0, ip.length()-1));
            return;
        }
        for(int i=start+1; i<=s.length(); i++){
            String numstr = s.substring(start, i);
            if(isValid(numstr)){
            	restoreIpAddresses(s, i, n+1, ip + numstr + ".", list);
            }
            
        }
    }

	private boolean isValid(String numstr) {

		try {
			int num = Integer.valueOf(numstr);
			if (numstr.length() > 1 && numstr.startsWith("0"))
				return false;
			if (0 <= num && num <= 255) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}
    
}
