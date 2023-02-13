package aspect;

import entity.Hall;

import java.text.ParseException;
import java.util.Date;

public interface HallAsp {
    Hall getCheckedHall();
    void showHall(Hall hall);
    Date checkDate() throws ParseException;
    Hall makeFreeHall(Date checkDate);

}
