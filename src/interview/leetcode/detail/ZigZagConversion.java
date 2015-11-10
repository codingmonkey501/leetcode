package interview.leetcode.detail;

public class ZigZagConversion {

	
	
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		Write the code that will take a string and make this conversion given a number of rows:
		
		string convert(string text, int nRows);
		convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	
	
	public static void main(String[] args) {
		ZigZagConversion z=new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));
		System.out.println(z.convert("A", 2));
		System.out.println(z.convert("AB", 1));
		System.out.println(z.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4));
	}

	public String convert3(String s, int nRows) {

		if (nRows == 1)
			return s;

		String result = "";
		for (int i = 0; i < nRows; i++) {

			int j = i;
			while (j < s.length()) {

				if (i == 0 || i == nRows - 1) {
					result += s.charAt(j);
					j += 2 * nRows - 2;
				} else {
					result += s.charAt(j);
					j += 2 * nRows - 2;
					int next = j - 2 * i;
					if (next >= s.length())
						break;
					result += s.charAt(next);
				}
			}
		}

		return result;
	}
	/**
	 *  a    g    m    s    y
		b  f h  l n  r t  x z
		c e  i k  o q  u w 
		d    j    p    v  
	 */
	public String convert(String s, int nRows) {
		
		if(s==null || s.length()==0 || nRows==1 || s.length()<=nRows ) return s; //wrong here
        
        String result="";
        for(int r=0,fac=nRows;r<nRows;r++){
            int c=r;
            while(true){
                result+=s.charAt(c);
                if(fac<nRows && fac>1){ 
                    int z=c+(fac-1)*2; //in between zig part
                    if(z>=s.length()) break;
                    result+=s.charAt(z);
                }
                c+=(nRows-1)*2;	// normal distance
                if(c>=s.length()) break;
            }
            fac--;
        }
        return result;
    }
}
