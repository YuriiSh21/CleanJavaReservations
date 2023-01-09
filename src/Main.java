import db.HallDB;
import entity.DatesOfReservations;
import service.HallService;
import service.HallServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static HallService hallService = new HallServiceImpl();

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello world!");
        DatesOfReservations datesOfReservations = new DatesOfReservations();
        List<HallDB> hallDBList = new ArrayList<>();
        HallDB hallDB1 = new HallDB(1, datesOfReservations.date01032023, false, true,true);
        hallDBList.add(hallDB1);

        boolean hallExist = hallService.checkStatusOfTablesInHall(checkDate(), hallDBList);
        if (hallExist) {
            System.out.println(hallService.getCheckedHall());
            hallService.notification1();
        } else {
            hallService.notification2();
        }

    }

    public static Date checkDate() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a date: ");
        String date = in.nextLine();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date dateForCheck = s.parse(date);
        in.close();
        return dateForCheck;
    }
}