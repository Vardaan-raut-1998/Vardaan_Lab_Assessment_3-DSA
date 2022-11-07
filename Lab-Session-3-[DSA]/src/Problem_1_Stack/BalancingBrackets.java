package Problem_1_Stack;

import java.util.Stack;

public class BalancingBrackets 

{
	// Main method-To check whether a given string has Equation balanced braces
	public static void main(String[] args)
	{
		//hardCoded input as instructed in Question
		//We never start a equation with close brace 
		String input = "([[{}]])";
		boolean result = isBalancedStringExp(input);
		if (result) {
			System.out.println("Yes-Entered String has Equationally Balanced Brackets :");
		} 
		else {
			System.out.println("Entered String has 'not' Equationally Balanced Brackets :");
		}
		System.out.println("\n----Program Completed Successfully----");
	}

	private static boolean isBalancedStringExp(String input) 
	{
		Stack<Character> stack = new Stack<Character>();
		// char ch: input.toCharArray

		for (int i = 0; i < input.length(); ++i) {
			char ch = input.charAt(i);
			
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
				continue;
			}
			// If we are encountering close braces and stack is empty
			// That implies that String is Unbalanced
			if (stack.isEmpty())
				return false;
			
			char match = stack.pop();
			
			switch (ch) 
			{
			case ')':
				if (match != '(') {
					return false;
				}
				break;
			case ']':
				if (match != '[') {
					return false;
				}
				break;
			case '}':
				if (match != '{') {
					return false;
				}
				break;
			}
			
		}
		
	  return stack.isEmpty();
	}
}
