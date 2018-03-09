class CountPrime{
    public static void main(String[] argv){
        int input = 10;
        boolean[] flag = new boolean[input+1];
        for(int i =0; i<= input;i++){
            flag[i] = false;
        }
        // flag[2] = true;
        for(int i =2; i< Math.sqrt(input);i++){
            if(flag[i])
                continue;
            int temp = i+i;
            while (temp <= input){
                flag[temp] = true;
                temp += i;
            }
        }
        for(int i =2; i<= input;i++){
            if(!flag[i]){
                System.out.println(i);
            }
        }

    }

    

}