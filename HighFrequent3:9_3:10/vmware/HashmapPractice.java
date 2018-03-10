import java.util.*;

class HashmapPractice{
    public static void main(String[] argv){
        String s = "tree";
        HashMap<Character,Integer> h = new HashMap<Character,Integer>();
        Map<Integer,String> ah = new TreeMap<Integer,String>(Collections.reverseOrder());
        for (int i=0;i<s.length();i++){
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0) +1);
        }
        for (Map.Entry<Character,Integer> entry:h.entrySet()){
            ah.put(entry.getValue(),ah.getOrDefault(entry.getValue(), "")+entry.getKey());
        }
        String res = "";
        // List<Integer> temp = new ArrayList<Integer>(ah.keySet());
        // Collections.sort(temp);
        for (int i:ah.keySet()){
            for (int k=0;k<ah.get(i).length();k++){
                for (int j=0;j<i;j++){
                res = res + ah.get(i).charAt(k);
                }
            }
        }
        System.out.println(res);
        
        

    }
}