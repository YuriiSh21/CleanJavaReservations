package aspect;

public class LoggingAspImpl extends HallAspImpl implements Logging {
private static HallAspImpl hallAspImpl = new HallAspImpl();

@Override
public String notification3() {
    return "Enter password: ";
}
    @Override
    public boolean logging() {
        String password = hallAspImpl.readCommand(notification3());
        return password.equals("admin");
    }
}
