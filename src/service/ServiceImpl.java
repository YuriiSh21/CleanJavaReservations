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
    public boolean checkStatusOfTablesInHall(Date date, List<entity.Hall> list) {
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
    public Date checkDate() throws ParseException {
        return hallAsp.checkDate();
    }

    @Override
    public  void reservationProcess(List<entity.Reservation> reservationList, entity.Hall hall, Date date) {
        reservationAsp.reservationProcess(reservationList, hall, date);
    }

    @Override
    public Hall makeFreeHall(Date checkDate) {
        return hallAsp.makeFreeHall(checkDate);
    }

}
