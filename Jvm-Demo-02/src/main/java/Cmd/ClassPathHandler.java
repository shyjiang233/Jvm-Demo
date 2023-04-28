package Cmd;

import classpath.ClassPath;

public class ClassPathHandler extends CommadHandler{
    @Override
    public void handleCommand(String[] args) {
     if("-cp".equals(args[1])){
         System.out.println("successful");
         ClassPath classPath = new ClassPath(null,args[2]);
         byte[] classData = classPath.readClass(args[3]);
         int len = classData.length;
         System.out.println("the length of file is: " + len);
         for (int i = 0; i < len; i++) {
             if (i % 20 == 0) {
                 System.out.println();
             }
             System.out.printf("%04X ", classData[i], 16);

         }
     } else if (successor != null) {
         successor.handleCommand(args);
     }
    }
}
