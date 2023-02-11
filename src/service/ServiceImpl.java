package service;

import dao.*;
import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service {

    private HallDAO hallDAO = new HallDAOImpl();
    private TableDAO tableDAO = new TableDAOImpl();
    private ReservationDAO reservationDAO = new ReservationDAOImpl();
    private Communication communication = new HallDAOImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {
        return tableDAO.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public Hall getCheckedHall() {    //
        return hallDAO.getCheckedHall();
    }

    @Override
    public void notification2() {
        communication.notification2();
    }

    @Override
    public Date checkDate() throws ParseException {
        return hallDAO.checkDate();
    }

    @Override
    public  void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate) {
        reservationDAO.reservationProcess(reservationList, hall, checkDate);
    }

}
