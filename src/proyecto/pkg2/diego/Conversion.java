
package proyecto.pkg2.diego;

public class Conversion {
    
    public boolean checkIfOperand(char ch)
    {
        return Character.isLetterOrDigit(ch);
    }

    // Funcion para obetner la prioridad de los operadores//
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

    //Algoritmo para convertir de infijo a postfijo//
    public String covertInfixToPostfix(String expr)
    {
        int i;
        myStack s = new myStack();
        StringBuilder result = new StringBuilder(new String(""));

        for (i = 0; i < expr.length(); ++i)
        {
            // Verificamos si el carcter es operador 
            if (checkIfOperand(expr.charAt(i)))
                result.append(expr.charAt(i));

            else if (expr.charAt(i) == '(' || expr.charAt(i) == '[' || expr.charAt(i) == '{')
                s.push(expr.charAt(i));

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
            else 
            {
                while (!s.isEmpty() && precedence(expr.charAt(i)) <= precedence(s.peek())){
                    result.append(s.peek());
                    s.pop();
                }
                s.push(expr.charAt(i));
            }

        }

        // Vaciamos el resto de la pila
        while (!s.isEmpty()){
            result.append(s.peek());
            s.pop();
        }
        
        return String.valueOf(result);

    }
    

    
    public boolean IsOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    
    //Algoritmo para convertir de prefijo a infijo//
    public String convertPrefixToInfix(String str) {
        Pila stack = new Pila();

        // Longitud de la expresion
        int l = str.length();

        // Leemos de derecha a izquierda
        for (int i = l - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (IsOperator(c)) {
                String op1 = String.valueOf(stack.pop());
                String op2 = String.valueOf(stack.pop());

                // Concatenamos
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            } else {

                // Convertimos a String
                stack.push(c + "");
            }
        }
        return String.valueOf(stack.pop());
    }
    
     
    
    
    
    
    //    public boolean isOperator(char c) {
//        return (!(c >= 'a' && c <= 'z')
//                && !(c >= '0' && c <= '9')
//                && !(c >= 'A' && c <= 'Z'));
//    }
//
//// Function to find priority
//// of given operator.
//    public int getPriority(char C) {
//        if (C == '-' || C == '+') {
//            return 1;
//        } else if (C == '*' || C == '/') {
//            return 2;
//        } else if (C == '^') {
//            return 3;
//        }
//        return 0;
//    }
//
//// Function that converts infix
//// expression to prefix expression.
//    public String infixToPrefix(String infix) {
//        // stack for operators.
//        Pila operators = new Pila();
//
//        // stack for operands.
//        Pila operands = new Pila();
//
//        for (int i = 0; i < infix.length(); i++) {
//
//            // If current character is an
//            // opening bracket, then
//            // push into the operators stack.
//            if (infix.charAt(i) == '(') {
//                operators.push(infix.charAt(i));
//            } // If current character is a
//            // closing bracket, then pop from
//            // both stacks and push result
//            // in operands stack until
//            // matching opening bracket is
//            // not found.
//            else if (infix.charAt(i) == ')') {
//                while (!operators.IsEmpty()
//                        && (char)operators.peek() != '(') {
//
//                    // operand 1
//                    String op1 = String.valueOf(operands.peek());
//                    operands.pop();
//
//                    // operand 2
//                    String op2 = String.valueOf(operands.peek());
//                    operands.pop();
//
//                    // operator
//                    char op = (char)operators.peek();
//                    operators.pop();
//
//                    // Add operands and operator
//                    // in form operator +
//                    // operand1 + operand2.
//                    String tmp = op + op2 + op1;
//                    operands.push(tmp);
//                }
//
//                // Pop opening bracket
//                // from stack.
//                operators.pop();
//            } // If current character is an
//            // operand then push it into
//            // operands stack.
//            else if (!isOperator(infix.charAt(i))) {
//                operands.push(infix.charAt(i) + "");
//            } // If current character is an
//            // operator, then push it into
//            // operators stack after popping
//            // high priority operators from
//            // operators stack and pushing
//            // result in operands stack.
//            else {
//                while (!operators.IsEmpty()
//                        && getPriority(infix.charAt(i))
//                        <= getPriority((char)operators.peek())) {
//
//                    String op1 = String.valueOf(operands.peek());
//                    operands.pop();
//
//                    String op2 = String.valueOf(operands.peek());
//                    operands.pop();
//
//                    char op = (char)operators.peek();
//                    operators.pop();
//
//                    String tmp = op + op2 + op1;
//                    operands.push(tmp);
//                }
//
//                operators.push(infix.charAt(i));
//            }
//        }
//
//        // Pop operators from operators
//        // stack until it is empty and
//        // operation in add result of
//        // each pop operands stack.
//        while (!operators.IsEmpty()) {
//            String op1 = String.valueOf(operands.peek());
//            operands.pop();
//
//            String op2 = String.valueOf(operands.peek());
//            operands.pop();
//
//            char op = (char)operators.peek();
//            operators.pop();
//
//            String tmp = op + op2 + op1;
//            operands.push(tmp);
//        }
//
//        // Final prefix expression is
//        // present in operands stack.
//        return String.valueOf(operands.peek());
//    }
}
