import java.util.Scanner;
import java.util.Stack;

public class THU_GON_DAY_SO_J02017
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        while(t-- > 0) {
            int x = sc.nextInt();
            if(!st.empty() && (st.peek() + x)%2 == 0) st.pop();
            else st.push(x);
        }
        System.out.println(st.size());
        sc.close();
    }
}