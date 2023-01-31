package service;

import dao.HallDAO;
import dao.HallDAOImpl;
import db.HallDB;
import entity.CheckDate;
import entity.Hall;
import entity.Reservation;
import entity.Table;

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
    public void notification1() {
        hallDAO.notification1();
    }

    @Override
    public void notification2() {
        hallDAO.notification2();
    }

    @Override
    public void showHall(Hall hall) {
        hallDAO.showHall(hall);
    }

    @Override
    public String readCommand(String s) {
        return hallDAO.readCommand(s);
    }

    @Override
    public Date checkDate() throws ParseException {
        return hallDAO.checkDate();
    }

    @Override
    public Reservation madeNewReservation(Date date, String command) {
        return hallDAO.madeNewReservation(date, command);
    }

    @Override
    public List<Reservation> saveReservation(List<Reservation> list, Reservation reservation) {
        return hallDAO.saveReservation(list, reservation);
    }

    @Override
    public void changeStatusOfTable(Hall hall, Reservation reservation) {
        hallDAO.changeStatusOfTable(hall, reservation);
    }

    @Override
    public boolean isTableFree(String command, Hall hall) {
        return hallDAO.isTableFree(command, hall);
    }

   /* @Override
    public void comboReservation(List<Reservation> reservationList, Hall hall, CheckDate checkDate) {
        hallDAO.comboReservation(reservationList, hall, checkDate);
    }*/

}
