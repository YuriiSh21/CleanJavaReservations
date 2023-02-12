package aspect;

import entity.Reservation;

import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Admin implements Communication {

    public void openAdminMenu(List<Reservation> list) {
        switch (readCommand(notification3())) {
            case "1":
                System.out.println("Here will search");
                openAdminMenu(list);
                break;
            case "2":
                System.out.println(list);
                openAdminMenu(list);
                break;
            case "3":
                System.out.println("Here will method deleteReservation(id)");
                openAdminMenu(list);
                break;
            case "4":
                break;
            default:
                System.out.println("Enter correct command");
                openAdminMenu(list);
                break;
        }
    }
    @Override
    public void notification2() {

    }

    @Override
    public String notification3() {
        return "Enter 1 for RESERVATION SEARCH \n" +
                "Enter 2 for SHOW ALL RESERVATIONS \n" +
                "Enter 3 for CANCEL RESERVATION \n" +
                "Enter 4 for EXIT";
    }

    @Override
    public String readCommand(String s) {
        Scanner sc = new Scanner(System.in);
        displayMessage(s);
        return sc.nextLine();
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }
}
