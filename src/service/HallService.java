package service;

import db.HallDB;
import entity.Hall;
import entity.Reservation;
import entity.Table;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface HallService {
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list);
    public Hall getCheckedHall();//
    public void notification1();
    public void notification2();
    public void showHall(Hall hall);
    public String readCommand(String s);
    public Date checkDate() throws ParseException;
    public Reservation madeNewReservation(Date date, String command);
    public List<Reservation> saveReservation(List<Reservation> list, Reservation reservation);
    public void changeStatusOfTable(Hall hall, Reservation reservation);
    public boolean isTableFree(String command, Hall hall);
}
