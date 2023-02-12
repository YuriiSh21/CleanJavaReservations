package aspect;

import entity.Hall;
import entity.Reservation;

import java.util.Date;
import java.util.List;

public interface TableAsp {
    boolean checkStatusOfTablesInHall(Date date, List<Hall> list);
    void changeStatusOfTable(Hall hall, Reservation reservation);
    boolean isTableFree(String command, Hall hall);
}
