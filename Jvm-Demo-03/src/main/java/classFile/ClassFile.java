package classFile;

import classFile.attribute.AttributeInfo;
import classFile.constantpool.ConstantBase;
import classFile.constantpool.ConstantUtf8;
import classFile.constantpool.Cp_info;
import common.*;
import sun.reflect.ConstantPool;

public class ClassFile {
    public U4 magic; //魔数
    public U2 minorVersion;//次版本号
    public U2 majorVersion;//主版本号
    public U2 constantPoolCount;//常量池大小
    public Cp_info constantPool=new Cp_info();//常量池
    public U2 accessFlags;////类访问标志,表明class文件定义的是类还是接口，访问级别是public还是private
    public U2 thisClass;
    public U2 superClass;
    public U2 interfaceCount;//本类实现的接口数量
    public U2[] interfaces;
    public U2 fieldCount; //本来含有的字段数量
    public FieldInfo[] fields ;
    public U2 methodsCount;//本来含有的方法数量
    public MethodInfo[] methods ;
    public U2 attributesCount;//本来含有的属性数量
    public AttributeInfo[] attributes ;
      /*将字节码转换为ClassFile*/
     public void  readByteCode(byte[] bytecode){
         IOUtils.bytecode=bytecode;
         IOUtils.index=0;
         readAndCheckMagic();
         readAndCheckVersion();
         constantPoolCount=IOUtils.readU2();
         Integer poolSize=ByteUtils.bytesToU16(constantPoolCount.u2);
          /*读取常量池*/
          readConstantPool(constantPool,poolSize);
     }
    /**
     * 解析字节码中的常量池
     * @param constantPool
     * @param poolSize
     */
    private void readConstantPool(Cp_info constantPool, Integer poolSize) {
        constantPool.cpInfo=new ConstantBase[poolSize];
        for (int i = 0; i <poolSize-1 ; i++) {
            U1 tag=IOUtils.readU1();
            Integer integerTag=ByteUtils.byteArr2Int(tag.u1);
            switch (integerTag){
                case 1:
                    ConstantUtf8 constantUtf8=new ConstantUtf8();
                    constantUtf8.tag=tag;
                    constantUtf8.length=IOUtils.readU2();
                    Integer utf8Len=ByteUtils.bytesToU16(constantUtf8.length.u2);
                    constantUtf8.bytes=new U1[utf8Len];
            }
        }
        

     }


    private void readAndCheckMagic() {

       String magic= ByteUtils.bytesToHexString(IOUtils.readU4().u4);
        if (!magic.equals("CAFEBABE")) {
            throw new RuntimeException("java.lang.ClassFormatError: magic!");
        }
    }
    private void readAndCheckVersion() {
       minorVersion=IOUtils.readU2();
       majorVersion=IOUtils.readU2();
       int minV=ByteUtils.bytesToU16(minorVersion.u2);
       int majV=ByteUtils.bytesToU16(majorVersion.u2);
        if (minV == 45) {
            return;
        }
        if (minV == 0 && majV >= 46 && majV <= 52) {
            return;
        }
        throw new RuntimeException("java.lang.UnsupportedClassVersionError!");
    }
}
