package dao;

import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface HallDAO {
    boolean checkStatusOfTablesInHall(Date date, List<Hall> list);

    Hall getCheckedHall();

    void notification2();

    String notification3();

    void showHall(Hall hall);

    String readCommand(String s);

    Date checkDate() throws ParseException;

    Reservation madeNewReservation(Date date, String command);

    List<Reservation> saveReservation(List<Reservation> list, Reservation reservation);

    void changeStatusOfTable(Hall hall, Reservation reservation);

    boolean isTableFree(String command, Hall hall);

    void readName(Reservation reservation, Scanner scanner);

    void readSurname(Reservation reservation, Scanner scanner);

    void readPhoneNumber(Reservation reservation, Scanner scanner);

    void readNumberOfPersons(Reservation reservation, Scanner scanner);

    void readRemark(Reservation reservation, Scanner scanner);

    void displayMessage(String s);

    void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate);
}
