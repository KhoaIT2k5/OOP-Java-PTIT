package MANG_DOI_TUONG.J05015_DUA_XE_DAP;

import java.util.StringTokenizer;

public class courer {
    private String ten, donVi, endTime;

    public courer(String ten, String donVi, String endTime) {
        this.ten = ten;
        this.donVi = donVi;
        this.endTime = endTime;
    }
    public String ma() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(this.donVi);
        while(st2.hasMoreTokens()) sb.append(st2.nextToken().substring(0,1));
        StringTokenizer st = new StringTokenizer(this.ten);
        while(st.hasMoreTokens()) sb.append(st.nextToken().substring(0,1));
        return sb.toString();
    }
    public double thoiGianChay() {
        int start = 6 * 60;
        StringTokenizer st = new StringTokenizer(this.endTime, ":");
        int hour = Integer.parseInt(st.nextToken()), minute = Integer.parseInt(st.nextToken());
        int end = hour * 60 + minute;
        return (end-start)/60.0;
    }
    public double vanToc() {
        return 120/thoiGianChay();
    }
    @Override
    public String toString() {
        return ma() + " " + this.ten + " " + this.donVi + " " + String.format("%.0f",vanToc()) + " Km/h";
    }
}
