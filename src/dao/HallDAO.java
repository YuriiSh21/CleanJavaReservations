package dao;

import db.HallDB;
import entity.Hall;

import java.util.Date;
import java.util.List;

public interface HallDAO {
    public boolean checkStatusOfTablesInHall(Date date, List<HallDB> list);
    public  HallDB getCheckedHall();
    public void notification1();
    public void notification2();
}
