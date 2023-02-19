package service;

import aspect.*;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service {

    private final HallAsp hallAsp = new HallAspImpl();
    private final TableAsp tableAsp = new TableAspImpl();
    private final ReservationAsp reservationAsp = new ReservationAspImpl();
    private final Communication communication = new HallAspImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {
        return tableAsp.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public entity.Hall getCheckedHall() {    //
        return hallAsp.getCheckedHall();
    }

    @Override
    public String notification2() {
        return communication.notification2();
    }

    @Override
    public Date inputAndCheckingDate() throws ParseException {
        return hallAsp.inputAndCheckingDate();
    }

    @Override
    public void reservationProcess(List<Reservation> reservationList, Hall hall, Date date) {
        reservationAsp.reservationProcess(reservationList, hall, date);
    }

    @Override
    public Hall makeFreeHall(Date checkDate) {
        return hallAsp.makeFreeHall(checkDate);
    }

}
