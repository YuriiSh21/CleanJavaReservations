import dates.DatesOfReservations;
import entity.*;
import service.Service;
import service.ServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static Service service = new ServiceImpl();

    public static void main(String[] args) throws ParseException {
        DatesOfReservations datesOfReservations = new DatesOfReservations();
        List<Hall> hallList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        /*Table table1 = new Table(1, false, 4);
        Table table2 = new Table(2, true, 4);
        Table table3 = new Table(3, true, 4);
        Hall hall = new Hall(datesOfReservations.date01032023, table1, table2, table3);
        hallList.add(hall);*/

        Date checkDate;
        checkDate = service.checkDate();
        while (!checkDate.equals(datesOfReservations.date12122025)) {
            boolean hallExist = service
                    .checkStatusOfTablesInHall(checkDate, hallList);
            if (!hallExist) {
                service.notification2();
                Table freeTable1 = new Table(1, true, 4);
                Table freeTable2 = new Table(2, true, 4);
                Table freeTable3 = new Table(3, true, 4);
                Hall hallWithAllFreeTables = new Hall(checkDate, freeTable1, freeTable2, freeTable3);
                hallList.add(hallWithAllFreeTables);
                service.reservationProcess(reservationList, hallWithAllFreeTables, checkDate);
            } else {
                service.reservationProcess(reservationList, service.getCheckedHall(), checkDate);
            }
            checkDate = service.checkDate();
        }
    }
}