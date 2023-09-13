package BT1;

public class MainBT1 {
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("Tinh", "Nha Trang", 100, 20, 13000000);
        NhanVien nv2 = new NhanVien("Linh", "Nha Trang", 100, 19, 13000000);
        System.out.println(nv1.getThongTin());
    }
}
