    package VAO_RA_FILE.J07071_TEN_VIET_TAT;
    import java.util.*;
    import java.io.*;

    public class J07071 {
        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(new File("DANHSACH.in"));
            int n = sc.nextInt(); sc.nextLine();
            LinkedHashMap<String[],String> map = new LinkedHashMap<>();
            while(n-- > 0) {
                String[] s = sc.nextLine().trim().split("\\s+");
                StringBuilder sb = new StringBuilder();
                for(int i=0 ; i<s.length ; i++) sb.append(s[i].substring(0,1));
                map.put(s,sb.toString());   
            }
            int q = sc.nextInt();
            while(q-- > 0) {
                ArrayList<String[]> list = new ArrayList<>();
                String s = sc.next();
                StringBuilder tenVietTat = new StringBuilder();
                for(Character x : s.toCharArray()) if(x != '.') tenVietTat.append(x);
                String tenTat = tenVietTat.toString();

                for(Map.Entry<String[],String> entry: map.entrySet()) {
                    if(entry.getValue().length() != tenTat.length()) continue;
                    else {
                        int cnt = 0;
                        String tmp = entry.getValue();
                        for(int i=0 ; i<tmp.length() ; i++) if(tmp.charAt(i) != tenTat.charAt(i)) cnt++;
                        if(cnt == 1) list.add(entry.getKey());  
                    }    
                }

                Collections.sort(list,(x,y) -> {
                    if(x[x.length-1].equals(y[y.length-1])) return x[0].compareTo(y[0]);
                    return x[x.length-1].compareTo(y[y.length-1]);
                });     
                for(String[] x : list) {
                    for(String y : x) System.out.print(y + " ");
                    System.out.println();
                }
            }
            sc.close();
        }
    }

    //4
    //Nguyen Manh Son
    //Ngo Minh Tuan
    //Nguyen Manh Hung
    //Tran Trung Dung
    //1
    //N.M.*