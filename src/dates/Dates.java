package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    public Date dateOfExit = format.parse("22/12/2222");

    public Dates() throws ParseException {
    }
}
