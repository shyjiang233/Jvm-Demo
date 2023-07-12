package rtda;

/*Author:shyjiang233
 *  Desc:
 */public class JvmThread {
    //Program Counter 寄存器
    private int pc;

    //虚拟机栈
    private JvmStack stack;

    //创建线程时同时会初始化一个可以容纳 1024 帧的虚拟机栈代码如下；
    public JvmThread() {
        stack = new JvmStack(1024);
    }

    public int pc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    //向栈中压入帧；
    public void pushFrame(JvmFrame frame) {
        this.stack.push(frame);
    }

    //从栈中弹出帧
    public JvmFrame popFrame() {
        return this.stack.pop();
    }

    //返回当前正在执行的方法的栈帧；
    public JvmFrame currentFrame() {
        return this.stack.top();
    }

}
