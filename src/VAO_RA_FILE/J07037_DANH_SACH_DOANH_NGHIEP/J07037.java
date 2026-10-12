package VAO_RA_FILE.J07037_DANH_SACH_DOANH_NGHIEP;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Company implements Comparable<Company>
{
    private String ID;
    private String name;
    private String num;

    public Company(String ID, String name, String num)
    {
        this.ID = ID;
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString()
    {
        return ID + " " + name + " " + num;
    }

    @Override
    public int compareTo(Company o)
    {
        return this.ID.compareTo(o.ID);
    }
}
public class J07037
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("DN.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Company> a = new ArrayList<>();
        while (t-- > 0)
            a.add(new Company(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        Collections.sort(a);
        for (Company i : a) System.out.println(i);
    }
}