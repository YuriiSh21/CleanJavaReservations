package aspect;

import entity.Hall;
import entity.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HallAspImpl implements HallAsp, Communication {
    public static Hall checkedHall;

    public Hall getCheckedHall() {
        return checkedHall;
    }

    @Override
    public String notification1() {
        return
                "Select free table and enter number of table for your reservation. \n" +
                        "Press 0 for exit \n" +
                        "Press 9 for Log in";
    }

    @Override
    public String notification2() {
        return "This date don't have reservations";
    }

    @Override
    public void showHall(Hall hall) {
        System.out.println(hall);
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        displayMessage(s);
        return sc.nextLine();
    }

    @Override
    public Date inputAndCheckingDate() throws ParseException {
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
            return inputAndCheckingDate();
        }
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public Hall makeFreeHall(Date checkDate) {
        Table freeTable1 = new Table(1, true, 4);
        Table freeTable2 = new Table(2, true, 4);
        Table freeTable3 = new Table(3, true, 4);
        return new Hall(checkDate, freeTable1, freeTable2, freeTable3);
    }
}