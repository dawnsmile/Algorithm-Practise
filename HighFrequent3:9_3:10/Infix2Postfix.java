import java.util.Stack;


class Infix2Postfix{
    public static void main(String argv[]){
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        Stack<Character> stack = new Stack<Character>();
        String res = "";
        String op = "+-*/^()";
        for (int i = 0; i < s.length(); i++){
            if (op.indexOf(s.charAt(i)) != -1){
                switch(s.charAt(i)){
                    case '+':
                    case '-':
                        while (!stack.empty() && stack.peek()!='('){
                            res = res + stack.pop();
                        }
                        stack.push(s.charAt(i));
                        break;
                    case '*':
                    case '/':
                        while (!stack.empty() &&(stack.peek()=='*' || stack.peek()=='/' || stack.peek()=='^')){
                            res = res + stack.pop();
                        }
                        stack.push(s.charAt(i));
                        break;
                    case '^':
                        while (!stack.empty() && stack.peek()=='^'){
                            res = res + stack.pop();
                        }
                        stack.push(s.charAt(i));
                        break;
                    case '(':
                        stack.push(s.charAt(i));
                        break;
                    case ')':
                        while (!stack.empty() && stack.peek()!='('){
                            res = res + stack.pop();
                        }
                        stack.pop();
                        break;
                } 
            }
            else{
                res = res + s.charAt(i);
            }
        }
        while (!stack.empty()){
            res = res + stack.pop();
        }
        System.out.println(res);
    }
}