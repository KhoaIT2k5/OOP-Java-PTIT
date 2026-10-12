package XAU_KY_TU;

import java.util.*;

public class DANH_DAU_CHU_CAI_J03038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++) map.put(s.charAt(i), 1);
        System.out.println(map.size());
    }
}
