
package proyecto2;

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
    
}
