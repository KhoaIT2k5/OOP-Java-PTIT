package VAO_RA_FILE.J07040_LIET_KE_THEO_THU_TU_XUAT_HIEN;
import java.util.*;
import java.io.*;
public class J07040 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> a = (ArrayList<String>) ois1.readObject(); 
        TreeSet<String> b = new TreeSet<>();
        for(String x : a) {
            String[] arr = x.trim().toLowerCase().split("\\s+");
            b.addAll(Arrays.asList(arr));
        }   
        Scanner sc = new Scanner(new File("VANBAN.in"));
        while(sc.hasNext()) {
            String s = sc.next().toLowerCase();
            if(b.contains(s)) {
                System.out.println(s);
                b.remove(s);
            }
        }
        sc.close();
        ois1.close();
    }
}
