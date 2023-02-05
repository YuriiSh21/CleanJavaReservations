package service;

import dao.HallDAO;
import dao.HallDAOImpl;
import entity.CheckDate;
import entity.Hall;
import entity.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class HallServiceImpl implements HallService {

    private HallDAO hallDAO = new HallDAOImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {
        return hallDAO.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public Hall getCheckedHall() {    //
        return hallDAO.getCheckedHall();
    }

    @Override
    public void notification2() {
        hallDAO.notification2();
    }

    @Override
    public Date checkDate() throws ParseException {
        return hallDAO.checkDate();
    }

    @Override
    public  void reservationProcess(List<Reservation> reservationList, Hall hall, CheckDate checkDate) {
        hallDAO.reservationProcess(reservationList, hall, checkDate);
    }

}
