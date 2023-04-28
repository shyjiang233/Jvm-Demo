import Cmd.Cmd;

import java.util.Scanner;

/*测试java命令行*/
public class TestCmd {
    public static void main(String[] args) {
        System.out.println("hint :");
        System.out.println("Usage: java [-options] class [args...]");
        System.out.println("-------------------------------------");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Cmd cmd=new Cmd(s);
    }
}
