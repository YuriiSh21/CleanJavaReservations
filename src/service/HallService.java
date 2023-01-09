package service;

import db.HallDB;
import entity.Hall;

import java.util.Date;
import java.util.List;

public interface HallService {
    public boolean checkStatusOfTablesInHall(Date date, List<HallDB> list);
    public  HallDB getCheckedHall();//
    public void notification1();
    public void notification2();
}
