import entity.*;
import service.HallService;
import service.HallServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static HallService hallService = new HallServiceImpl();
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello world!");
        DatesOfReservations datesOfReservations = new DatesOfReservations();
        List<Hall> hallList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        Table table1 = new Table(1, false, 4);
        Table table2 = new Table(2, true, 4);
        Table table3 = new Table(3, true, 4);
        Hall hall = new Hall(datesOfReservations.date01032023, table1, table2, table3);
        hallList.add(hall);
        CheckDate checkDate = new CheckDate();
        checkDate.setCheckDate(hallService.checkDate());
        while (!checkDate.getCheckDate().equals(datesOfReservations.date12122025)) {
            boolean hallExist = hallService
                    .checkStatusOfTablesInHall(checkDate.getCheckDate(), hallList);
            if (!hallExist) {
                hallService.notification2();
                Table freeTable1 = new Table(1, true, 4);
                Table freeTable2 = new Table(2, true, 4);
                Table freeTable3 = new Table(3, true, 4);
                Hall hallWithAllFreeTables = new Hall(checkDate.getCheckDate(), freeTable1, freeTable2, freeTable3);
                hallList.add(hallWithAllFreeTables);
                hallService.reservationProcess(reservationList, hallWithAllFreeTables, checkDate);
            } else {
                hallService.reservationProcess(reservationList, hallService.getCheckedHall(), checkDate);
            }
            checkDate.setCheckDate(hallService.checkDate());
        }
    }
}