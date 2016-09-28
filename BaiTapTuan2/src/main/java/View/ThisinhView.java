package View;

import Controller.ThisinhController;
import Entity.Thisinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by phucv on 9/26/2016.
 */
public class ThisinhView {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        Menu menu = new Menu();
        ThisinhController thisinhController = new ThisinhController();
        int chon;
        do {
            menu.modau();
            System.out.println("Bạn chọn: ");
            chon = nhap.nextInt();
            switch (chon) {
                case 1: {
                    do {
                        menu.nhaptheocach();
                        chon = nhap.nextInt();
                        switch (chon) {
                            case 1: {
                                int n;
                                System.out.println("Nhập vào số lượng sinh viên: ");
                                n = nhap.nextInt();
                                thisinhController.Themthisinh(n);
                                System.out.println("Nhập tên file:");
                                String filename=nhap.next();
                                try {
                                    thisinhController.WriteObjects(filename);
                                }catch (Exception e){
                                    System.out.println(""+e.toString());
                                }
                            }
                            break;
                            case 2:{
                                System.out.println("Nhập tên file: ");
                                String filename = nhap.next();
                                try {
                                    thisinhController.ReadObjects(filename);
                                }catch (Exception e){
                                    System.out.println(""+e.toString());
                                }
                            }break;
                            case 3:{
                                System.out.println("Ấn phím bất kỳ để quay lại");
                            }break;
                        }
                    } while (chon !=3);
                }
                break;
                case 2: {
                    do{
                        menu.edit();
                        chon = nhap.nextInt();
                        switch (chon){
                            case 1:{
                                Thisinh thisinh = new Thisinh();
                                thisinh.Nhapthongtin();
                                thisinhController.Themthisinh(thisinh);
                            }break;
                            case 2:{
                                thisinhController.suaThongtin();
                                String filename;
                                System.out.println("Nhập tên file:");
                                filename = nhap.next();
                                try {
                                    thisinhController.WriteObjects(filename);
                                }catch (Exception e){
                                    System.out.println(""+e.toString());
                                }
                            }break;
                            case 3:{
                                thisinhController.xoaThongtin();
                            }break;
                            case 4:{
                                System.out.printf("Ấn phím bất kỳ để quay lại");
                            }break;
                        }
                    }while(chon!=4);
                }
                break;
                case 3: {
                    List<Thisinh> list = new ArrayList<Thisinh>();
                    do{
                        menu.timkiem();
                        chon = nhap.nextInt();
                        switch (chon){
                            case 1:{
                                double tong;
                                System.out.println("Nhập tổng điểm cần tìm kiếm: ");
                                tong = nhap.nextDouble();
                                list=thisinhController.timkiemDiem(tong, 0);
                            }break;
                            case 2:{
                                String SBD;
                                System.out.println("Nhập số báo danh cần tìm kiếm: ");
                                SBD = nhap.next();
                                list=thisinhController.timkiem(SBD, 0);
                            }break;
                            case 3:{
                                String Hoten;
                                System.out.println("Nhập họ tên thí sinh cần tìm kiếm: ");
                                Hoten = nhap.next();
                                list=thisinhController.timkiem(Hoten, 1);
                            }break;
                            case 4:{
                                double diemmon;
                                System.out.println("Nhập vào điểm môn cần phải tìm");
                                diemmon = nhap.nextDouble();
                                list = thisinhController.timkiemDiem(diemmon, 1);
                            }break;
                            case 5:{
                                System.out.println("Ấn phím bất kỳ để quay lại");
                            }break;
                        }
                        if(chon<6){
                            System.out.println("Danh sách kết quả tìm kiếm: ");
                            for (Thisinh thisinh : list){
                                thisinh.Inthongtin();
                            }
                            String filename;
                            System.out.println("Nhập tên file cần xuất: ");
                            nhap.nextLine();
                            filename = nhap.nextLine();

                            try {
                                thisinhController.WriteObjects(filename);
                                System.out.println("Ghi file thành công");
                            }catch (Exception e){
                                System.out.println(""+e.toString());
                            }
                        }
                    }while(chon!=6);
                }
                break;
                case 4: {
                    List<Thisinh> list = new ArrayList<Thisinh>();
                    do{
                        menu.sapxep();
                        chon = nhap.nextInt();
                        switch (chon){
                            case 1:{
                                list = thisinhController.sapxep(thisinhController.getList(), 0);
                            }break;
                            case 2:{
                                list = thisinhController.sapxep(thisinhController.getList(), 1);
                            }break;
                            case 3:{
                                list = thisinhController.sapxep(thisinhController.getList(), 2);
                            }break;
                            case 4:{
                                System.out.println("Ấn phím bất kỳ để quay lại.");
                            }break;
                        }
                        System.out.println("Danh sách sau khi sắp xếp: ");
                        for (Thisinh thisinh:list){
                            thisinh.Inthongtin();
                        }
                    }while (chon!=5);
                }
                break;
                case 5: {
                    thisinhController.Thongke();
                }
                break;
                case 6: {
                    System.out.println("Ấn phím bất kỳ để thoát......");
                }
                break;
            }
        } while (chon!=7);
    }
}
