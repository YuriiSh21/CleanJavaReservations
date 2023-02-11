package aspect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HallImpl implements Hall, Communication {
    public static entity.Hall checkedHall;
    public entity.Hall getCheckedHall() {
        return checkedHall;
    }

    @Override
    public void notification2() {
        System.out.println("This date don't have reservations");
    }

    @Override
    public String notification3() {
        return
                "Select free table and \n" +
                        "enter number of table for your reservation. \n" +
                        "Press 0 for exit";
    }
    @Override
    public void showHall(entity.Hall hall) {
        System.out.println(hall);
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        displayMessage(s);
        return sc.nextLine();
    }

    @Override
    public Date checkDate() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the date (DD/MM/YYYY): ");
        String date = in.nextLine();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter = formatter.withLocale(Locale.US);
            LocalDate localDate = LocalDate.parse(date, formatter);
        if (localDate.isAfter(LocalDate.now()) || localDate.equals(LocalDate.now()))
            return s.parse(date);
        else {
            System.out.println("Input correct date");
            return checkDate();
        }
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }
}