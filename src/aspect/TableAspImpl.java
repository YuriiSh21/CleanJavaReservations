package aspect;

import entity.Hall;
import entity.Reservation;

import java.util.Date;
import java.util.List;

public class TableAspImpl implements TableAsp {

    @Override
    public boolean checkStatusOfTablesInHall(Date date, List<Hall> list) {
        for (Hall hall : list) {
            if (date.equals(hall.getDate())) {
                HallAspImpl.checkedHall = hall;
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeStatusOfTable(Hall hall, Reservation reservation) {
        switch (reservation.getNumberOfTable()) {
            case 1:
                hall.getTable_1().setTableStatus(false);
                break;
            case 2:
                hall.getTable_2().setTableStatus(false);
                break;
            case 3:
                hall.getTable_3().setTableStatus(false);
                break;
        }
    }

    @Override
    public boolean isTableFree(String command, Hall hall) {
        switch (Integer.parseInt(command)) {
            case 1:
                if (hall.getTable_1().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            case 2:
                if (hall.getTable_2().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            case 3:
                if (hall.getTable_3().isTableStatus())
                    return true;
                else {
                    System.out.println("This table was reserved");
                    return false;
                }
            default:
                System.out.println("Try again");
                return false;
        }
    }
}