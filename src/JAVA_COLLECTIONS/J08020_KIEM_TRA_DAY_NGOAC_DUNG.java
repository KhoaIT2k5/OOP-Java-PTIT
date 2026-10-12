/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_COLLECTIONS;
import java.util.*;
public class J08020_KIEM_TRA_DAY_NGOAC_DUNG {
    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') st.push(c); 
            else {
                if(st.isEmpty()) return false;
                if( (st.peek()=='(' && c==')' ) || (st.peek()=='[' && c==']') || (st.peek()=='{' && c=='}') ) st.pop();
		else return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0) {
            String s = sc.next();
            System.out.println(check(s) ? "YES" : "NO");
        }
        sc.close();
    }
}
