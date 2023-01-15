import db.HallDB;
import entity.CheckDate;
import entity.DatesOfReservations;
import entity.Reservation;
import service.HallService;
import service.HallServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static HallService hallService = new HallServiceImpl();

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello world!");
        DatesOfReservations datesOfReservations = new DatesOfReservations();
        List<HallDB> hallDBList = new ArrayList<>();
        HallDB hallDB1 = new HallDB(1, datesOfReservations.date01032023, false, true,true);
        hallDBList.add(hallDB1);
        CheckDate checkDate = new CheckDate();
        checkDate.setCheckDate(hallService.checkDate());

        
        boolean hallExist = hallService
                .checkStatusOfTablesInHall(checkDate.getCheckDate(), hallDBList);
        if (hallExist) {
            hallService.showHall(hallService.getCheckedHall());
            String choiceTable = hallService.readCommand("Select free table and \n" +
                    "enter number of table for your reservation ");
            //hallService.madeNewReservation(checkDate.getCheckDate(), choiceTable);
            Reservation test = hallService.madeNewReservation(checkDate.getCheckDate(), choiceTable);
            System.out.println(test);
        } else {
            hallService.notification2();
        }
    }
}