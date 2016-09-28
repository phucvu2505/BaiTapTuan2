package Model;

import Entity.Thisinh;

import java.io.*;
import java.util.*;

/**
 * Created by phucv on 9/25/2016.
 */
public class ThisinhModel {
    Scanner nhap = new Scanner(System.in);
    List<Thisinh> list = new ArrayList<Thisinh>();

    public ThisinhModel() {
    }
    public ThisinhModel(Scanner nhap) {
        this.list = new ArrayList<Thisinh>();
        this.nhap = nhap;
    }
    public List<Thisinh> Themthisinh(Thisinh thisinh) {
        list.add(thisinh);
        return list;
    }
    public List<Thisinh> Themthisinh(int soluong){
        Thisinh thisinh;
        for (int i = 0; i < soluong; i++) {
            thisinh = new Thisinh();
            System.out.println("Nhap thi sinh "+(i+1));
            thisinh.Nhapthongtin();
            list.add(thisinh);
        }
        return list;
    }
    public List<Thisinh> timkiemDiem(double diem, int opt) {
        List<Thisinh> listKQ = new ArrayList<Thisinh>();
        if (opt == 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTongdiem() == diem)
                    listKQ.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                for (double cdiem : list.get(i).getDiemthi()) {
                    if (diem == cdiem)
                        listKQ.add(list.get(i));
                }
            }
        }
        return listKQ;
    }
    public List<Thisinh> timkiem(String key, int opt) {
        List<Thisinh> listKQ = new ArrayList<Thisinh>();
        if (opt == 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSbd().equals(key))
                    listKQ.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHoten().equals(key))
                    listKQ.add(list.get(i));
            }
        }
        return listKQ;
    }
    public List<Thisinh> sapxep(List<Thisinh> list,int opt) {
        if (opt == 0) {
            Collections.sort(list, new Comparator<Thisinh>() {
                public int compare(Thisinh o1, Thisinh o2) {
                    return o1.getSbd().compareTo(o2.getSbd());
                }
            });
        }else if(opt==1) {
            Collections.sort(list, new Comparator<Thisinh>() {
                public int compare(Thisinh o1, Thisinh o2) {
                    return o1.getHoten().compareTo(o2.getHoten());
                }
            });
        } else {
            Collections.sort(list, new Comparator<Thisinh>() {
                public int compare(Thisinh o1, Thisinh o2) {
                    if (o1.getTongdiem() < o1.getTongdiem())
                        return 1;
                    else if (o1.getTongdiem() == o2.getTongdiem())
                        return 0;
                    else
                        return -1;
                }
            });
        }
        return list;
    }
    public boolean WriteListObjectIntoFiles(String fileName) throws Exception {
        try {

            File objFile = new File(fileName);

            FileOutputStream objOutFile = new FileOutputStream(objFile);
            ObjectOutputStream objOut = new ObjectOutputStream(objOutFile);
            objOut.writeObject(list);
            objOut.flush();
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    public List<Thisinh> ReadListObjectIntoFiles(String fileName) throws Exception {
        try {
            File objFile = new File(fileName);
            ObjectInputStream objObjectIn = new ObjectInputStream(new FileInputStream(objFile));
            list = (List<Thisinh>) objObjectIn.readObject();
            objObjectIn.close();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public List<Thisinh> suaThongtin(){
        System.out.println("Nhập số báo danh cần sửa: ");
        nhap.nextLine();
        String soBaoDanh = nhap.nextLine();
        Thisinh thiSinh = timkiem(soBaoDanh, 1).get(0);
        int indexThiSinh = list.indexOf(thiSinh);
        thiSinh.edit();
        list.add(indexThiSinh, thiSinh);
        list.remove(indexThiSinh+1);
        return list;
    }
    public List<Thisinh> xoaThongtin(){
        System.out.print("Nhập số báo danh cần xóa: ");
        String soBaoDanh = nhap.next();
        Thisinh thiSinh = timkiem(soBaoDanh, 1).get(0);
        list.remove(thiSinh);
        return list;
    }
    public void Thongke(){
        int[] thongke = new int[]{0, 0, 0, 0};
        System.out.println("Tong so thi sinh du thi: "+list.size());
        for (Thisinh thisinh : list) {
            if(thisinh.getTongdiem()<15)
                thongke[0]++;
            else if(thisinh.getTongdiem()>=15 && thisinh.getTongdiem()<20)
                thongke[1]++;
            else if(thisinh.getTongdiem()>=20 && thisinh.getTongdiem()<25)
                thongke[2]++;
            else
                thongke[3]++;
        }
        int mucDiem = 0;
        for (int tongSV : thongke){
            if(mucDiem == 0) {
                System.out.println("Muc diem tu 0 den 15: " + tongSV +" thi sinh");
                mucDiem += 15;
            }else{
                System.out.println("Muc diem tu "+mucDiem+" den "+(mucDiem+5)+": " + tongSV + "thi sinh");
                mucDiem += 5;
            }
        }
    }
    public List<Thisinh> getList() {
        return list;
    }

}


