package aspect;

import entity.Hall;

import java.text.ParseException;
import java.util.Date;

public interface HallAsp {
    Hall getCheckedHall();

    void showHall(Hall hall);

    Date inputAndCheckingDate() throws ParseException;

    Hall makeFreeHall(Date checkDate);

}