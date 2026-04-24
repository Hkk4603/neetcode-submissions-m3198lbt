class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>(); 
        for ( String str : tokens ) {
            if ( str.equals("+") ) {
                stk.push(stk.pop() + stk.pop()); 
            } else if ( str.equals("-") ) {
                int b = stk.pop(); 
                int a = stk.pop(); 
                stk.push(a - b); 
            } else if ( str.equals("*") ) {
                stk.push(stk.pop() * stk.pop());    
            } else if ( str.equals("/") ) {
                int b = stk.pop(); 
                int a = stk.pop(); 
                stk.push(a / b); 
            } else {
                stk.push(Integer.parseInt(str));
            }
        }


        return stk.pop(); 
    }
}
