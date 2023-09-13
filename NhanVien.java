package BT1;

public class NhanVien {
    String ten, diaChi;
    int tongSoGioLam, tuoi;
    double tienLuong;

    public NhanVien() {
    }

    public NhanVien(String ten, String diaChi, int tongSoGioLam, int tuoi, double tienLuong) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.tongSoGioLam = tongSoGioLam;
        this.tuoi = tuoi;
        this.tienLuong = tienLuong;
    }

    public String getThongTin(){
        return "Họ tên: " + this.ten +"\n"+
                "Tuổi: " + this.tuoi+"\n"+
                "Địa Chỉ: " + this.diaChi+"\n"+
                "Tổng số giờ làm: " + this.tongSoGioLam+"\n"+
                "Tiền lương: " + this.tienLuong+"\n";
    }

    public double tinhThuong(){
        if (tongSoGioLam<100)
            return 0;
        if (tongSoGioLam<200)
            return tienLuong*0.1;
        return tienLuong*0.2;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
