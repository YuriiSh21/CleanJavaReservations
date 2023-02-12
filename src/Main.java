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
        Date checkDate;
        checkDate = service.checkDate();
        while (!checkDate.equals(datesOfReservations.date12122025)) {
            boolean hallExist = service
                    .checkStatusOfTablesInHall(checkDate, hallList);
            if (!hallExist) {
                service.notification2();
                Hall hallWithAllFreeTables = service.makeFreeHall(checkDate);
                hallList.add(hallWithAllFreeTables);
                service.reservationProcess(reservationList, hallWithAllFreeTables, checkDate);
            } else {
                service.reservationProcess(reservationList, service.getCheckedHall(), checkDate);
            }
            checkDate = service.checkDate();
        }
    }
}