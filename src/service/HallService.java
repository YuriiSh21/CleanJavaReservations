package service;

import db.HallDB;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface HallService {
    public boolean checkStatusOfTablesInHall(Date date, List<HallDB> list);
    public  HallDB getCheckedHall();//
    public void notification1();
    public void notification2();
    public void showHall(HallDB hallDB);
    public String readCommand(String s);
    public Date checkDate() throws ParseException;
    public Reservation madeNewReservation(Date date, String command);
}
