import dates.Dates;
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
        Dates dates = new Dates();
        List<Hall> hallList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        Date correctDate;
        correctDate = service.inputAndCheckingDate();
        while (!correctDate.equals(dates.dateOfExit)) {
            boolean hallExist = service
                    .checkStatusOfTablesInHall(correctDate, hallList);
            if (!hallExist) {
                System.out.println(service.notification2());
                Hall hallWithAllFreeTables = service.makeFreeHall(correctDate);
                hallList.add(hallWithAllFreeTables);
                service.reservationProcess(reservationList, hallWithAllFreeTables, correctDate);
            } else {
                service.reservationProcess(reservationList, service.getCheckedHall(), correctDate);
            }
            correctDate = service.inputAndCheckingDate();
        }
    }
}