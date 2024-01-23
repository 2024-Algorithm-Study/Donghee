import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					stack.push(s.charAt(j));
				}else {
					if(stack.empty()) {
						stack.push(s.charAt(j));
						break;
					}else {
						stack.pop();
					}
				}
			}
      if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
