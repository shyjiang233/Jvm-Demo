package rtda;

/*Author:shyjiang233
 *  Desc:栈帧
 */public class JvmFrame {
      JvmFrame lower;//前一帧的引用，相当于单向链表的前一个指针
       LocalVars  localVars;//局部变量表的引用
     OperandStack  operandStack;//操作数栈的引用
    public JvmFrame(int maxLocals, int maxStack) {
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars(){
        return localVars;
    }

    public OperandStack operandStack(){
        return operandStack;
    }
}
