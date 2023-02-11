package dao;

import entity.Hall;
import entity.Reservation;

import java.util.Date;
import java.util.List;

public interface TableDAO {
    boolean checkStatusOfTablesInHall(Date date, List<Hall> list);
    void changeStatusOfTable(Hall hall, Reservation reservation);
    boolean isTableFree(String command, Hall hall);
}
