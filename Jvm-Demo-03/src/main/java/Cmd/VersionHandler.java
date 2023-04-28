package Cmd;

public class VersionHandler extends CommadHandler{
    @Override
    public void handleCommand(String[] args) {
        if("-version".equals(args[1])){
            System.out.println("openjdk version \"1.8.0_342\"\n" +
                    "OpenJDK Runtime Environment Corretto-8.342.07.3 (build 1.8.0_342-b07)\n" +
                    "OpenJDK 64-Bit Server VM Corretto-8.342.07.3 (build 25.342-b07, mixed mode)");
        } else if (successor != null) {
            successor.handleCommand(args);
        }
    }
}
