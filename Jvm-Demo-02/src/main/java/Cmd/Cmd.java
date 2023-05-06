package Cmd;

import lombok.Data;

/*Author:  shyjiang233
 *  Desc:解析命令行工具类*/
@Data
public class Cmd{
    private CommadHandler handler;
    Boolean helpFlag;//是否是help命令
    Boolean versionFlag;//是否是查看版本命令
    String cpOption;//classPath路径
    private String xJreOption;
    String[]  args;//执行clazz文件需要的参数
/*采用责任链模式处理命令*/
    public  Cmd(String cmdLine) {
        //解析命令行参数,以单个或者多个空格分开,这种方式目前不支持,因为如果输入的 路径名 中间有空格会导致下面解析失败
        if (!CmdValidator.isValidCmd(cmdLine)) {
            System.out.println("Unrecognized option: -ewf\n" +
                    "Error: Could not create the Java Virtual Machine.\n" +
                    "Error: A fatal exception has occurred. Program will exit.");
            return;
        } else {
            //初始化责任链
            CommadHandler helpHandler = new HelperHandler();
            CommadHandler vesionHandler = new VersionHandler();
            CommadHandler classpathHandler = new ClassPathHandler();
            CommadHandler XjreHandler=new XjreHandler();
            helpHandler.setSuccessor(vesionHandler);
            vesionHandler.setSuccessor(classpathHandler);
            classpathHandler.setSuccessor(XjreHandler);
            handler = helpHandler;
            String[] args = cmdLine.trim().split("\\s+");
            parseCmd(args);
        }
    }
    public void parseCmd(String[] args){

       handler.handleCommand(args);
    }
}
