package dao;

import db.HallDB;
import entity.Hall;

import java.util.Date;
import java.util.List;

public class HallDAOImpl implements HallDAO {

    public static HallDB checkedHall;

    public  HallDB getCheckedHall() {
        return checkedHall;
    }

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<HallDB> list) {

        for (HallDB hallDB : list) {
            if (date.equals(hallDB.getDate())) {
                checkedHall = hallDB;
                System.out.println(true); //for visible valid
                return true;
            }
        }
        System.out.println(false); //for visible valid
        return false;
    }

    @Override
    public void notification1() {
        System.out.println("Select free table");
    }

    @Override
    public void notification2() {
        System.out.println("This date don't have reservations");
    }
}
