package aspect;

import java.text.ParseException;
import java.util.Date;

public interface Hall {
    entity.Hall getCheckedHall();
    void showHall(entity.Hall hall);
    Date checkDate() throws ParseException;

}
