package dao;

import db.HallDB;
import entity.CheckDate;
import entity.Hall;
import entity.Reservation;
import entity.Table;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface HallDAO {
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list);
    public Hall getCheckedHall();
    public void notification1();
    public void notification2();
    public void showHall(Hall hall);
    public String readCommand(String s);
    public Date checkDate() throws ParseException;
    public Reservation madeNewReservation(Date date, String command);
    public List<Reservation> saveReservation(List<Reservation> list, Reservation reservation);
    public void changeStatusOfTable(Hall hall, Reservation reservation);
    boolean isTableFree(String command, Hall hall);
    public void readName(Reservation reservation, Scanner scanner);
    public void readSurname(Reservation reservation, Scanner scanner);
    public void readPhoneNumber(Reservation reservation, Scanner scanner);
    public void readNumberOfPersons(Reservation reservation, Scanner scanner);
    public void readRemark(Reservation reservation, Scanner scanner);
}
