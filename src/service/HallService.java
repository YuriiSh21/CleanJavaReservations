package service;

import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface HallService {
    boolean checkStatusOfTablesInHall(Date date, List<Hall> list);

    Hall getCheckedHall();//

    void notification2();

    Date checkDate() throws ParseException;

    void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate);

}
