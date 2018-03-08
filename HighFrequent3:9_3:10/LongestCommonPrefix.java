class Solution {
    public String longestCommonPrefix(String[] args) {
        if (args == null || args.length == 0) return "";
        String prefix = args[0];
		for (int i = 1; i < args.length; i++) {
		    int minlens = prefix.length() < args[i].length() ? prefix.length(): args[i].length();
            prefix = prefix.substring(0, minlens); 
		    for (int j = 0; j < minlens; j++) {
		        if (prefix.charAt(j) != args[i].charAt(j)) {
		            prefix = prefix.substring(0, j); // if include?
		            break;
		        }
		    }
		}
		return prefix;
    }
}


public class Solution { 
    public void reverse(char[] chars,int i, int j){
        // int i = 0; j = s.length() - 1; 
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++; j--;
        }
    }
    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +"," ");
        char[] chars = s.toCharArray();
        if (s.trim().equals("")){
            return "";
        }
        reverse(chars,0,chars.length-1);
        // System.out.println(chars);
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' '){
                i++;
                continue;
            }
            int j = i;
            while (j >= i && j <= chars.length) {
                if (j == chars.length || chars[j] == ' '  ){ 
                    reverse(chars, i, j-1);
                    break;
                }
                j++;
            }
            i = j;
        }
        s = new String(chars);
        return s;
    }
}




