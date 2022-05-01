
import java.util.Stack;
public class Balancecheck {

    private static boolean checkbalance(String search, int len) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++)
        {
            char x = search.charAt(i);
            if (x == '(' || x == '{' || x == '[')
            {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }

            if ((x == ')' && stack.pop()!= '(') || (x == ']' && stack.pop()!= '[') || (x == '}' && stack.pop()!= '{')  )
            {
                return false;
            }
        }
        return (stack.isEmpty());
    }

    public static void main (String[] args) {
        String input = "([[{}]])";
        int len = input.length();
        System.out.println("String length is "+len);
        // Check if the given string is even to be considered for balance check
        if (len % 2 != 0) {
            System.out.println("The given string is not balanced as the total length is uneven");
        } else {
            // Call the balance check method and check each character for the validation
            Balancecheck chk = new Balancecheck();
            Boolean ret = chk.checkbalance(input, len);
            if (ret) {
                System.out.println("The given string is balanced");
            } else {
                System.out.println("The given string is not balanced");
            }
        }
    }
}

