package service;

import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface Service {
    boolean checkStatusOfTablesInHall(Date date, List<Hall> list);

    Hall getCheckedHall();

    void notification2();

    Date inputAndCheckingDate() throws ParseException;

    void reservationProcess(List<Reservation> reservationList, Hall hall, Date date);

    Hall makeFreeHall(Date checkDate);
}
