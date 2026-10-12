package MANG_DOI_TUONG.J05032_GIA_NHAT_TRE_NHAT;

import java.util.*;
class date {
    private String name,birth;
    public date(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }
    public String getName() {
        return name;
    }
    public String getBirth() {
        return birth;
    }
}
public class J05032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<date> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String name = sc.next();
            String birth = sc.next();
            list.add(new date(name,birth));
        }
        Collections.sort(list, new Comparator<date>() {
            public int compare(date x, date y) {
                String[] birth1 = x.getBirth().split("/");
                String[] birth2 = y.getBirth().split("/");
                if(birth1[2].equals(birth2[2])) {
                    if(birth1[1].equals(birth2[1])) return birth2[0].compareTo(birth1[0]);
                    else return birth2[1].compareTo(birth1[1]);
                } else return birth2[2].compareTo(birth1[2]);
            }
        });
        System.out.println(list.get(0).getName());
        System.out.println(list.get(list.size() - 1).getName());
        sc.close();
    }
}