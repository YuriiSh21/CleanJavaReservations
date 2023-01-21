import db.HallDB;
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
        do {
            checkDate.setCheckDate(hallService.checkDate());
            boolean hallExist = hallService
                    .checkStatusOfTablesInHall(checkDate.getCheckDate(), hallList);
            if (hallExist) {
                hallService.showHall(hallService.getCheckedHall());
                String choiceTable = hallService.readCommand("Select free table and \n" +
                        "enter number of table for your reservation ");
                while (!hallService.isTableFree(choiceTable, hall)) {
                    choiceTable = hallService.readCommand("Select free table and \n" +
                            "enter number of table for your reservation ");
                }
                Reservation reservation = hallService.madeNewReservation(checkDate.getCheckDate(), choiceTable);
                hallService.saveReservation(reservationList, reservation);
                // System.out.println(reservationList);
                hallService.changeStatusOfTable(hall, reservation);
                hallService.showHall(hallService.getCheckedHall());
            } else {
                hallService.notification2();
                Table freeTable1 = new Table(1, true, 4);
                Table freeTable2 = new Table(2, true, 4);
                Table freeTable3 = new Table(3, true, 4);
                Hall hallWithAllFreeTables = new Hall(checkDate.getCheckDate(), freeTable1, freeTable2, freeTable3);
                hallList.add(hallWithAllFreeTables);
                hallService.showHall(hallWithAllFreeTables);
                String choiceAnotherTable = hallService.readCommand("Select free table and \n" +
                        "enter number of table for your reservation ");
                while (!hallService.isTableFree(choiceAnotherTable, hallWithAllFreeTables)) {
                    choiceAnotherTable = hallService.readCommand("Select free table and \n" +
                            "enter number of table for your reservation ");
                }
                Reservation reservation = hallService.madeNewReservation(checkDate.getCheckDate(), choiceAnotherTable);
                hallService.saveReservation(reservationList, reservation);
                hallService.changeStatusOfTable(hallWithAllFreeTables, reservation);
                hallService.showHall(hallWithAllFreeTables);
            }
        }
            while (!hallService.checkDate().equals(datesOfReservations.date12122012));
    }
}