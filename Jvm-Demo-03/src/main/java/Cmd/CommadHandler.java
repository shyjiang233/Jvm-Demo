package Cmd;
/* Author:shyjiang233
*   Desc:我们需要定义一个抽象类 CommadHandler，表示命令行解析的处理器。这个抽象类包含了两个方法：setSuccessor 和 handle
* ，其中 setSuccessor 方法用于设置下一个处理器，而 handle 方法则用于处理当前命令行参数并交给下一个处理器处理：*/
public abstract class CommadHandler {
     protected CommadHandler successor;
     public void setSuccessor(CommadHandler successor){
          this.successor=successor;
     }
     public  abstract  void handleCommand(String[] args);

}
