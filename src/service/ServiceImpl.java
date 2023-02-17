package service;

import aspect.*;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service {

    private HallAsp hallAsp = new HallAspImpl();
    private TableAsp tableAsp = new TableAspImpl();
    private ReservationAsp reservationAsp = new ReservationAspImpl();
    private Communication communication = new HallAspImpl();
    private Admin admin = new AdminImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {
        return tableAsp.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public entity.Hall getCheckedHall() {    //
        return hallAsp.getCheckedHall();
    }

    @Override
    public void notification2() {
        communication.notification2();
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
