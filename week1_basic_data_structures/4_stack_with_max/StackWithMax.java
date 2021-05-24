import java.util.*;
import java.io.*;

public class StackWithMax {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int queries = scanner.nextInt();
		Stack<Integer> stack = new Stack<Integer>();

		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
		
				if (stack.empty()) {
					stack.push(value);
					stack.push(value);
				} else {
					int num = stack.peek();
					
					if(num >= value) {
						stack.push(value);
						stack.push(num);
					}
					else if(num < value) {
						stack.push(value);
						stack.push(value);
					}
				}
				
			} else if ("pop".equals(operation)) {		
				if(!stack.empty()) {
					stack.pop();
					stack.pop();	
				}

			} else if ("max".equals(operation)) {
//                System.out.println(Collections.max(stack));
				if(!stack.empty()) { System.out.println(stack.peek()); }
			
			}
		}
	}

	static public void main(String[] args) throws IOException {
		new StackWithMax().solve();
	}
}
