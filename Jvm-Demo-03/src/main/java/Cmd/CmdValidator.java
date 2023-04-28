package Cmd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*   author:shyjiang233
*     Desc: 用正则表达式判断一下输入的命令
*      java -version
      java -?
      java -help
     java -cp your/classpath yourClassName
     */
public class CmdValidator {
    private static final Pattern CMD_PATTERN = Pattern.compile("^java\\s+(-version|-\\?|-help|-cp|-classpath)\\s*(.*)$");
     public  static  boolean isValidCmd(String cmdLine){
         Matcher matcher=CMD_PATTERN.matcher(cmdLine);
         return matcher.matches();
     }
}
