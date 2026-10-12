package XAU_KY_TU;

import java.util.*;

public class DIA_CHI_EMAIL_J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<String> res = new ArrayList<>();
        while(t-- > 0) {
            String s = sc.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()) list.add(st.nextToken().toLowerCase());
            String tmp = list.get(list.size()-1);
            for(int i=0 ; i< list.size()-1 ; i++) tmp = tmp + list.get(i).charAt(0);
            res.add(tmp);
        }
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i=0 ; i< res.size() ; i++) {
            StringBuilder sb = new StringBuilder();
            if(!map.containsKey(res.get(i))) {
                map.put(res.get(i),1);
                sb.append(res.get(i) + "@ptit.edu.vn");
            } else {
                map.put(res.get(i), map.get(res.get(i)) + 1);
                sb.append(res.get(i) + map.get(res.get(i))  + "@ptit.edu.vn");
            }
            System.out.print(sb.toString());
            System.out.println();
        }
    }
}


