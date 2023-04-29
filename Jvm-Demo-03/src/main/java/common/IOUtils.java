package common;
/*Author: shyjiang233*/
public class IOUtils {
public static byte[] bytecode;
public static  Integer index;
 public static U1 readU1(){
  U1 res=new U1();
   res.u1=read(1);
   index++;
   return  res;
 }
  public  static U2 readU2(){
      U2 res=new U2();
      res.u2=read(2);
      index+=2;
      return  res;
  }
  public  static U4 readU4(){
     U4  res=new U4();
     res.u4=read(4);
     index+=4;
     return  res;
  }


    public static byte[] read(Integer size){
        byte[] bytes = new byte[size];
        for(Integer i = 0; i < size; i++){
            bytes[i] = bytecode[index + i];
        }
        return bytes;
    }
}
