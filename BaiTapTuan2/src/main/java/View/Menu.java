package View;

import Entity.Thisinh;

import java.util.List;
import java.util.Scanner;

/**
 * Created by phucv on 9/26/2016.
 */
public class Menu {
    public static void modau() {
        System.out.println("1.Nhập thông tin thí sinh");
        System.out.println("2.Thêm, sửa, xóa thông tin thí sinh");
        System.out.println("3.Tìm kiếm thí sinh theo các chức năng sau");
        System.out.println("4.Sắp xếp thí sinh theo các chức năng sau");
        System.out.println("5.Thống kê");
        System.out.println("6.Thoát");
    }

    public static void timkiem() {
        System.out.println("1.Tìm kiếm theo tổng số điểm: ");
        System.out.println("2.Tìm kiếm theo số báo danh:");
        System.out.println("3.Tìm kiếm theo họ và tên: ");
        System.out.println("4.Tìm kiếm điểm từng môn");
        System.out.println("5.Quay lại");
    }

    public static void sapxep() {
        System.out.println("1.Sắp xếp theo số báo danh");
        System.out.println("2.Sắp xếp theo họ tên");
        System.out.println("3.Sắp xếp theo tổng điểm");
        System.out.println("4.Quay lại");
    }

    public static void edit() {
        System.out.println("1.Thêm thông tin thí sinh");
        System.out.println("2.Sửa thông tin thí sinh");
        System.out.println("3.Xóa thông tin thí sinh");
        System.out.println("4.Quay lại");
    }

    public static void nhaptheocach() {
        System.out.println("1.Nhập từ bàn phím");
        System.out.println("2.Nhập từ file");
        System.out.println("3.Quay lại");
    }
}

