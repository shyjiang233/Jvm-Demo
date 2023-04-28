package Cmd;

public class HelperHandler extends CommadHandler {
    @Override
    public void handleCommand(String[] args) {
        if ("-?".equals(args[1]) || "-help".equals(args[1])) {
            System.out.println("Sorry, we do not support this feature implementation at the moment");
        } else if (successor != null) {
            successor.handleCommand(args);
        }
    }
}
