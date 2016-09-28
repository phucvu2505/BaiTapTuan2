package Entity;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by phucv on 9/25/2016.
 */
public class Thisinh implements Serializable{
    private String hoten;
    private String sbd;
    private String diachi;
    private boolean gioitinh;
    private double[] diemthi;

    public Thisinh() {
        diemthi = new double[3];
    }

    public Thisinh(String hoten, String sbd, String diachi, boolean gioitinh, double[] diemthi) {
        this.hoten = hoten;
        this.sbd = sbd;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.diemthi = diemthi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double[] getDiemthi() {
        return diemthi;
    }

    public void setDiemthi(double[] diemthi) {
        this.diemthi = diemthi;
    }

    public double getTongdiem() {
        return diemthi[0] + diemthi[1] + diemthi[2];
    }

    public void Nhapthongtin() {
        int testGT;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập vào họ tên thí sinh: ");
        setHoten(nhap.nextLine());
        System.out.println("Nhập vào số báo danh của thí sinh: ");
        setSbd(nhap.nextLine());
        System.out.println("Nhập vào địac chỉ của thí sinh: ");
        setDiachi(nhap.nextLine());
        System.out.println("Chọn giới tính thí sinh: ");
        System.out.println("0.Nữ\n1.Nam");
        do {
            System.out.println("Chọn: ");
            testGT = nhap.nextInt();
            if (testGT != 0 && testGT != 1)
                System.out.println("Chọn sai!Chọn lại");
            else
                setGioitinh(testGT == 0 ? true : false);
        } while (testGT != 0 && testGT != 1);
        System.out.println("Nhập điểm 3 môn Toán-Lý-Hóa");
        for (int i = 0; i < 3; i++) {
            diemthi[i] = nhap.nextDouble();
        }
        setDiemthi(diemthi);
    }

    public void Inthongtin() {
        System.out.println("Thông tin của thí sinh");
        System.out.println("Họ tên: " + getHoten());
        System.out.println("Số báo danh: " + getSbd());
        System.out.println("Địa chỉ: " + getDiachi());
        System.out.println("Giới tính: " + (isGioitinh() ? "Nữ" : "Nam"));
        System.out.printf("Điểm thi Toán-Lý-Hóa: %f %f %f", diemthi[0], diemthi[1], diemthi[2]);
        System.out.printf("\n");
    }
    public void edit(){
        System.out.println("Sua thong tin thi sinh: ");
        Scanner nhap = new Scanner(System.in);
        System.out.println("So bao danh: "+getSbd());
        System.out.print("Sua ten thi sinh "+getHoten()+": ");
        setHoten(nhap.nextLine());
        System.out.print("Sua dia chi thi sinh: "+getDiachi()+": ");
        setDiachi(nhap.nextLine());
        System.out.println("Sua gioi tinh thi sinh: ");
        System.out.println("0. Nam\n1. Nu");
        int gioiTinh;
        do {
            System.out.print("Chon: ");
            gioiTinh = nhap.nextInt();
            if(gioiTinh != 0 && gioiTinh != 1){
                System.out.println("Chon sai!!!");
            }else{
                setGioitinh(gioiTinh==0 ? true:false);
            }
        }while (gioiTinh != 0 && gioiTinh != 1);
        System.out.println("Sua diem Toan - Ly - Hoa: ");
        for (int j = 0; j < 3; j++) {
            diemthi[j] = nhap.nextDouble();
        }
        setDiemthi(diemthi);
    }
}
