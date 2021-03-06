import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {

	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		int c = 0;
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);

			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here
				opening_brackets_stack.push(new Bracket(next, position));
			}

			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here
				if (opening_brackets_stack.empty()) {
					c = position + 1;
					position = text.length();
					break;
				} else {
					if (opening_brackets_stack.peek().Match(next)) {
						opening_brackets_stack.pop();
						c = 0;
					} else {
						c = position + 1;
						position = text.length();
						break;
					}
				}
			}
		}
		if (opening_brackets_stack.empty()) {
			if (text.length() > 1 && c == 0) {
				System.out.println("Success");
			} else {
				System.out.println(c);
			}
		} else {
			if (c == 0) {
				System.out.println(opening_brackets_stack.peek().position + 1);
			} else {
				System.out.println(c);
			}

		}
	}
}
