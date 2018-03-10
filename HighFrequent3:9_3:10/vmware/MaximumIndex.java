import java.util.Arrays;

class MaximumIndex{
    public static void main(String[] argv){
        int[] input = {3,5,4,2};
        int[] minarr = new int[input.length];
        int[] maxarr = new int[input.length];
        minarr[0] = input[0];
        maxarr[input.length-1] =  input[input.length-1];
        for(int i=1; i<input.length;i++){
            minarr[i] = Math.min( minarr[i-1],input[i]);
        }
        for(int i=input.length-2; i>=0;i--){
            maxarr[i] = Math.max( maxarr[i+1],input[i]);
        }
        int i = 0, j = 0 , res = -1;
        while(i<input.length && j<input.length){
            if (minarr[i] <= maxarr[j]){
                res = Math.max(res, j - i);
                j++;
            }
            else{
                i++;
            }
        }
        System.out.println(res);

    }
}