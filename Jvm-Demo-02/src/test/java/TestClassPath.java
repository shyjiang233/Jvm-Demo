import Cmd.Cmd;
import classpath.ClassPath;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

/**/
public class TestClassPath {
    public static void main(String[] args) {

        System.out.println("hint :");
        System.out.println("Usage: java [-options] class [args...]");
        System.out.println("-------------------------------------");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Cmd cmd=new Cmd(s);

    }
}
