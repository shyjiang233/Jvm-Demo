package Cmd;

import classpath.ClassPath;

public class XjreHandler extends CommadHandler{
    @Override
    public void handleCommand(String[] args) {
        if("-Xjre".equals(args[1])){
            System.out.println("successful");
            ClassPath classPath = new ClassPath(null,null);
            byte[] classData = classPath.readClass(args[2]);
            int len = classData.length;
            System.out.println("the length of file is: " + len);
            for (int i = 0; i < len; i++) {
                if (i % 20 == 0) {
                    System.out.println();
                }
                System.out.printf("%04X ", classData[i], 16);

            }
        }else if (successor != null) {
            successor.handleCommand(args);
        }
    }
}
