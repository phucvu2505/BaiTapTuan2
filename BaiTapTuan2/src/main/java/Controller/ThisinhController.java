package Controller;

import Entity.Thisinh;
import Model.ThisinhModel;

import java.util.List;
import java.util.Scanner;

/**
 * Created by phucv on 9/25/2016.
 */
public class ThisinhController {
    public ThisinhModel thisinhModel;
    public ThisinhController(){
        thisinhModel = new ThisinhModel();
    }
    public List<Thisinh> Themthisinh(Thisinh objThisinh){
        return thisinhModel.Themthisinh(objThisinh);
    }
    public List<Thisinh> Themthisinh(int soluong){
        return thisinhModel.Themthisinh(soluong);
    }
    public List<Thisinh> timkiemDiem(double diem, int opt){
        return thisinhModel.timkiemDiem(diem, opt);
    }
    public List<Thisinh> timkiem(String key, int opt){
        return thisinhModel.timkiem(key, opt);
    }
    public List<Thisinh> sapxep(List<Thisinh> list,int opt){
        return thisinhModel.sapxep(list, opt);
    }
    public boolean WriteObjects(String fileName) throws Exception {
        return thisinhModel.WriteListObjectIntoFiles(fileName);
    }
    public List<Thisinh> ReadObjects(String fileName) throws Exception {
        return thisinhModel.ReadListObjectIntoFiles(fileName);
    }
    public List<Thisinh> xoaThongtin(){
        return thisinhModel.xoaThongtin();
    }
    public List<Thisinh> suaThongtin(){
        return thisinhModel.suaThongtin();
    }
    public void Thongke(){
        thisinhModel.Thongke();
    }
    public List<Thisinh> getList(){
        return thisinhModel.getList();
    }
}

