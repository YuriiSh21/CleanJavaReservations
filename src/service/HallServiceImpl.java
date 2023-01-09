package service;

import dao.HallDAO;
import dao.HallDAOImpl;
import db.HallDB;
import entity.Hall;

import java.util.Date;
import java.util.List;

public class HallServiceImpl implements HallService {

    private HallDAO hallDAO = new HallDAOImpl();

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<HallDB> list) {
        return hallDAO.checkStatusOfTablesInHall(date, list);
    }

    @Override
    public HallDB getCheckedHall() {    //
        return hallDAO.getCheckedHall();
    }

    @Override
    public void notification1() {
        hallDAO.notification1();
    }

    @Override
    public void notification2() {

    }
}
