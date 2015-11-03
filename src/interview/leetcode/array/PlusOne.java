package interview.leetcode.array;

public class PlusOne {

	
	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 */
	public static void main(String[] args) {

	}
	
	
	public int[] plusOne1(int[] digits) {
        
        int overflow =0 ;
        digits[digits.length-1] += 1;
        for(int i=digits.length-1; i>=0; i--){
            
            int n = digits[i] + overflow;
            overflow = n / 10;
            n %= 10;
            digits[i] = n;
        }
        
        if(overflow != 0){
            int[] number =  new int[digits.length+1];
            for(int i=digits.length-1; i>=0; i--){
                number[i+1] = digits[i];
            }
            number[0] = overflow;
            return number;
        }
        return digits;
    }


	public int[] plusOne(int[] digits) {

		this.add(digits, 1);
		return digits;
	}

	private int[] add(int[] digits, int digit) {

		int c = digit;
		for (int i = 0; i != digits.length; ++i) {
			digits[i] += c;
			c = digits[i] / 10;
			digits[i] %= 10;
		}
		if (c > 0) {
			int[] result = new int[digits.length + 1];
			for (int j = digits.length; j > 0; j--) {
				result[j] = digits[j - 1];
			}
			result[0] = 1;
			return result;
		}
		return digits;
	}
	
	public int[] plusOne2(int[] digits) {

		if (digits == null || digits.length == 0)
			return null;
		int i = digits.length - 1;
		boolean overflow = false;
		digits[i] += 1;
		if (digits[i] == 10) {
			overflow = true;
			digits[i] = 0;
		}
		i--;
		while (i > -1) {
			if (overflow) {
				digits[i] += 1;
				overflow = false;
			}
			if (digits[i] == 10) {
				digits[i] = 0;
				overflow = true;
			}
			i--;
		}
		if (overflow) {
			int[] result = new int[digits.length + 1];
			for (int j = digits.length; j > 0; j--) {
				result[j] = digits[j - 1];
			}
			result[0] = 1;
			return result;
		}
		return digits;

	}

}
