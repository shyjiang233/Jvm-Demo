package rtda;

/*Author:shyjiang233
 *  Desc:java虚拟机栈
 */public class JvmStack {
          private  int maxSize;//虚拟机栈包含栈帧的最大容量
          private  int size;//当前栈帧的容量
          private  JvmFrame top_;//栈顶指针

    public JvmStack(int maxSize) {
        this.maxSize=maxSize;
    }
    public JvmFrame  top(){
        if(this.top_==null){
            throw new RuntimeException("Jvm stack is empty");
        }
           return  this.top_;
    }

    public void push(JvmFrame frame) {
       if(this.maxSize<this.size){
            throw new StackOverflowError();
       }
        if(this.top_!=null){
           frame.lower=this.top_;
        }
        this.top_=frame;
        this.size++;
    }
    public JvmFrame pop(){
        if (this.top_ == null) {
            throw new RuntimeException("Jvm stack is empty!");
        }

        JvmFrame frame2 = this.top_;
        this.top_ = frame2.lower;
        frame2.lower = null;
        this.size--;

        return frame2;
    }
}
