package MANG_DOI_TUONG.J05062_HOC_BONG_SINH_VIEN;
import java.util.*;

class SinhVien {
    String ten;
    double tbc;
    int rl;
    String loaiGoc; // Loại học bổng nếu không bị giới hạn số lượng
    public SinhVien(String ten, double tbc, int rl) {
        this.ten = ten;
        this.tbc = tbc;
        this.rl = rl;
        this.loaiGoc = xetHocBongGoc();
    }
    // Xét điều kiện đạt học bổng theo tiêu chí cứng của trường
    private String xetHocBongGoc() {
        if (tbc >= 3.6 && rl >= 90) return "XUATSAC";
        if (tbc >= 3.2 && rl >= 80) return "GIOI";
        if (tbc >= 2.5 && rl >= 70) return "KHA";
        return "KHONG";
    }
}
public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt(),m = sc.nextInt();
        
        ArrayList<SinhVien> list = new ArrayList<>();
        ArrayList<Double> dsTbcHopLe = new ArrayList<>(); // Chỉ lưu điểm TBC của những bạn đủ điều kiện
        
        for (int i = 0; i < n; i++) {
            sc.nextLine(); 
            String ten = sc.nextLine();
            while (ten.trim().isEmpty() && sc.hasNextLine()) ten = sc.nextLine();
            double tbc = sc.nextDouble();
            int rl = sc.nextInt();
            
            SinhVien sv = new SinhVien(ten, tbc, rl);
            list.add(sv);
            
            // Nếu bạn này có cơ hội nhận học bổng (không bị xếp loại KHONG)
            // thì đưa mức điểm TBC vào danh sách để xét duyệt cạnh tranh
            if (!sv.loaiGoc.equals("KHONG")) {
                dsTbcHopLe.add(tbc);
            }
        }
        
        // Sắp xếp các mức điểm TBC hợp lệ theo thứ tự giảm dần
        Collections.sort(dsTbcHopLe, Collections.reverseOrder());
        
        // Xác định "Điểm Chuẩn" để cắt học bổng
        double diemChuan = 0.0;
        if (m == 0) {
            diemChuan = 10.0; // Quỹ bằng 0 thì không ai được nhận
        } else if (dsTbcHopLe.size() > m) {
            // Lấy điểm của bạn đứng ở vị trí chốt sổ M (chỉ số m - 1 trong mảng)
            diemChuan = dsTbcHopLe.get(m - 1);
        } else {
            // Số suất lớn hơn số người đủ điều kiện -> Ai cũng đủ điều kiện đều được nhận
            diemChuan = 0.0; 
        }
        for (SinhVien sv : list) {
            // Phải thỏa mãn 2 điều kiện: Đạt loại gốc và Điểm TBC lớn hơn hoặc bằng Điểm chuẩn
            if (!sv.loaiGoc.equals("KHONG") && sv.tbc >= diemChuan) 
                System.out.println(sv.ten + ": " + sv.loaiGoc);
            else System.out.println(sv.ten + ": KHONG");
        }
        sc.close();
    }
}