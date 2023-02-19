package aspect;

public class LoggingAspImpl extends HallAspImpl implements Logging {
    private static final HallAspImpl hallAspImpl = new HallAspImpl();

    @Override
    public String notification1() {
        return "Enter password: ";
    }

    @Override
    public boolean logging() {
        String password = hallAspImpl.readCommand(this.notification1());
        return password.equals("admin");
    }
}