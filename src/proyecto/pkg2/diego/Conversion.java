
package proyecto.pkg2.diego;

public class Conversion {
    
    public boolean checkIfOperand(char ch)
    {
        return Character.isLetterOrDigit(ch);
    }

    // Function to compare precedence
    // If we return larger value means higher precedence
    public int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


    public String covertInfixToPostfix(String expr)
    {
        int i;
        myStack s = new myStack();
        StringBuilder result = new StringBuilder(new String(""));

        for (i = 0; i < expr.length(); ++i)
        {
            // Here we are checking is the character we scanned is operand or not
            // and this adding to output.
            if (checkIfOperand(expr.charAt(i)))
                result.append(expr.charAt(i));

                // Here, if we scan the character ‘(‘, '[', '{' we need to push it to the stack.
            else if (expr.charAt(i) == '(' || expr.charAt(i) == '[' || expr.charAt(i) == '{')
                s.push(expr.charAt(i));

                // Here, if we scan character is an ‘)’, we need to pop and print from the stack
                // do this until an ‘(‘ is encountered in the stack.
            else if (expr.charAt(i) == ')' || expr.charAt(i) == ']' || expr.charAt(i) == '}')
            {
                if(expr.charAt(i) == ')'){
                    while (!s.isEmpty() && s.peek() != '('){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }

                if(expr.charAt(i) == ']'){
                    while (!s.isEmpty() && s.peek() != '['){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }
                if(expr.charAt(i) == '}'){
                    while (!s.isEmpty() && s.peek() != '{'){
                        result.append(s.peek());
                        s.pop();
                    }

                    s.pop();
                }
            }
            else // if an operator
            {
                while (!s.isEmpty() && precedence(expr.charAt(i)) <= precedence(s.peek())){
                    result.append(s.peek());
                    s.pop();
                }
                s.push(expr.charAt(i));
            }

        }

        // Once all initial expression characters are traversed
        // adding all left elements from stack to exp
        while (!s.isEmpty()){
            result.append(s.peek());
            s.pop();
        }
        
        return String.valueOf(result);

    }
    
    public boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z')
                && !(c >= '0' && c <= '9')
                && !(c >= 'A' && c <= 'Z'));
    }

// Function to find priority
// of given operator.
    public int getPriority(char C) {
        if (C == '-' || C == '+') {
            return 1;
        } else if (C == '*' || C == '/') {
            return 2;
        } else if (C == '^') {
            return 3;
        }
        return 0;
    }

// Function that converts infix
// expression to prefix expression.
    public String infixToPrefix(String infix) {
        // stack for operators.
        Pila operators = new Pila();

        // stack for operands.
        Pila operands = new Pila();

        for (int i = 0; i < infix.length(); i++) {

            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == '(') {
                operators.push(infix.charAt(i));
            } // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')') {
                while (!operators.IsEmpty()
                        && (char)operators.peek() != '(') {

                    // operand 1
                    String op1 = String.valueOf(operands.peek());
                    operands.pop();

                    // operand 2
                    String op2 = String.valueOf(operands.peek());
                    operands.pop();

                    // operator
                    char op = (char)operators.peek();
                    operators.pop();

                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                // Pop opening bracket
                // from stack.
                operators.pop();
            } // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperator(infix.charAt(i))) {
                operands.push(infix.charAt(i) + "");
            } // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else {
                while (!operators.IsEmpty()
                        && getPriority(infix.charAt(i))
                        <= getPriority((char)operators.peek())) {

                    String op1 = String.valueOf(operands.peek());
                    operands.pop();

                    String op2 = String.valueOf(operands.peek());
                    operands.pop();

                    char op = (char)operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.IsEmpty()) {
            String op1 = String.valueOf(operands.peek());
            operands.pop();

            String op2 = String.valueOf(operands.peek());
            operands.pop();

            char op = (char)operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is
        // present in operands stack.
        return String.valueOf(operands.peek());
    }
    
    
//    public String convertInfixToPrefix(String expr){
//        String result = "";
//        String aux = "";
//        
//        for (int i = expr.length() - 1; i >= 0; i--) {
//            aux += expr.charAt(i);
//        }
//        
//        
//        String aux2 = aux.replace('(', ',').replace(')', '.');
//        String aux3 = aux2.replace(',', ')').replace('.', '(');
//        
//        System.out.println(aux3);
//        String temp = covertInfixToPostfix(aux3);
//
//        for (int i = temp.length() - 1; i >= 0; i--) {
//            result += temp.charAt(i);
//        }
//        
//        return result;
//        
//    }
     
}
