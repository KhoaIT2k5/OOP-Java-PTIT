package VAO_RA_FILE.J07045_LOAI_PHONG;
import java.util.*;
import java.io.*;
class LoaiPhong implements Comparable<LoaiPhong> {
    private String loai,tenLoai;
    private String donGiaNgay;
    private String phucVu;
    
    public LoaiPhong(String s) {
        String[] arr = s.trim().split("\\s+");
        loai = arr[0];
        tenLoai = arr[1];
        donGiaNgay = arr[2];
        phucVu = arr[3];
    }
    
    @Override
    public int compareTo(LoaiPhong o) {
        return this.tenLoai.compareTo(o.tenLoai);
    }
    
    @Override
    public String toString() {
        return loai + " " + tenLoai + " " + Integer.parseInt(donGiaNgay) 
                + " " + String.format("%.2f",Double.parseDouble(phucVu));
    }
}
public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
        in.close();
    }
}


//2
//C THUONG 150 0.03
//B VIP 200 0.05
