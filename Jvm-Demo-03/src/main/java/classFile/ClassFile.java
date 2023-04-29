package classFile;

import classFile.attribute.AttributeInfo;
import classFile.constantpool.*;
import com.sun.org.apache.bcel.internal.classfile.ConstantInterfaceMethodref;
import com.sun.org.apache.bcel.internal.classfile.ConstantMethodref;
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

    /**
     * 将字节码转换为ClassFile
     * @param bytecode
     */
    public void processByteCode(byte[] bytecode) {
        IOUtils.bytecode = bytecode;
        IOUtils.index = 0;
       readAndCheckMagic();
      readAndCheckVersion();
         Integer poolsize=ByteUtils.byteArr2Int(bytecode);
         /*读取常量池*/
       readConstantPool(constantPool,poolsize);
        accessFlags = IOUtils.readU2();
        thisClass = IOUtils.readU2();
        superClass = IOUtils.readU2();
        interfaceCount = IOUtils.readU2();
       Integer  intfaceCount=ByteUtils.byteArr2Int(bytecode);
        interfaces = new U2[intfaceCount];
        for(Integer i = 0; i < intfaceCount; i ++){
            interfaces[i] = IOUtils.readU2();
        }
        fieldCount = IOUtils.readU2();
        Integer fieldCountInteger =ByteUtils.byteArr2Int(fieldCount.u2);
        fields = readFields( fieldCountInteger);
        methodsCount = IOUtils.readU2();
        Integer methodsCountInteger = ByteUtils.byteArr2Int(methodsCount.u2);
        methods = readMethods( methodsCountInteger);

        attributesCount = IOUtils.readU2();
        Integer tempAttributesCount = ByteUtils.byteArr2Int(attributesCount.u2);
        attributes =  new AttributeInfo[tempAttributesCount];
        for(Integer i = 0; i < tempAttributesCount; i ++){
            readANDAttribute( i, attributes);
        }


    }

    private void readANDAttribute(Integer i, AttributeInfo[] attributes) {
    }

    private MethodInfo[] readMethods(Integer methodsCountInteger) {
        return  null;
    }

    private FieldInfo[] readFields(Integer fieldCountInteger) {
    return  null;
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
                    for(Integer j = 0; j < utf8Len; j ++){
                        constantUtf8.bytes[j] = IOUtils.readU1();
                    }
                    constantPool.cpInfo[i] = constantUtf8;
                case 3:
                    ConstantInteger constantInteger = new ConstantInteger();
                    constantInteger.tag = tag;
                    constantInteger.bytes = IOUtils.readU4();
                    constantPool.cpInfo[i] = constantInteger;
                case 4:
                    ConstantFloat constantFloat = new ConstantFloat();
                    constantFloat.tag = tag;
                    constantFloat.bytes = IOUtils.readU4();
                    constantPool.cpInfo[i] = constantFloat;
                case 5:
                    ConstantLong constantLong = new ConstantLong();
                    constantLong.tag = tag;
                    constantLong.highBytes = IOUtils.readU4();
                    constantLong.lowBytes = IOUtils.readU4();
                    /*double和long类型会跳过一个常量标识*/
                    constantPool.cpInfo[i ++] = constantLong;
                case 6:
                    ConstantDouble constantDouble = new ConstantDouble();
                    constantDouble.tag = tag;
                    constantDouble.highBytes = IOUtils.readU4();
                    constantDouble.lowBytes = IOUtils.readU4();
                    /*double和long类型会跳过一个常量标识*/
                    constantPool.cpInfo[i ++] = constantDouble;
                case 7:
                    ConstantClass constantClass = new ConstantClass();
                    constantClass.tag = tag;
                    constantClass.nameIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantClass;
                case 8:
                    ConstantString constantString = new ConstantString();
                    constantString.tag = tag;
                    constantString.stringIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantString;
                case 9:
                    ConstantFieldRef constantFieldref = new ConstantFieldRef();
                    constantFieldref.tag = tag;
                    constantFieldref.classIndex = IOUtils.readU2();
                    constantFieldref.nameAndTypeIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantFieldref;
                case 10:
                    ConstantMethodRef constantMethodref = new ConstantMethodRef();
                    constantMethodref.tag = tag;
                    constantMethodref.classIndex = IOUtils.readU2();
                    constantMethodref.nameAndTypeIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantMethodref;
                case 11:
                    ConstantInterfaceMethodRef constantInterfaceMethodref = new ConstantInterfaceMethodRef();
                    constantInterfaceMethodref.tag = tag;
                    constantInterfaceMethodref.classIndex = IOUtils.readU2();
                    constantInterfaceMethodref.nameAndTypeIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantInterfaceMethodref;
                case 12:
                    ConstantNameAndType  constantNameAndType = new ConstantNameAndType();
                    constantNameAndType.tag = tag;
                    constantNameAndType.nameIndex = IOUtils.readU2();
                    constantNameAndType.descriptorIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantNameAndType;
                case 15:
                    ConstantMethodHandle constantMethodHandle=new ConstantMethodHandle();
                    constantMethodHandle.tag = tag;
                    constantMethodHandle.referenceKind = IOUtils.readU1();
                    constantMethodHandle.referenceIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantMethodHandle;
                case 16:
                    ConstantMethodType constantMethodType = new ConstantMethodType();
                    constantMethodType.tag = tag;
                    constantMethodType.descriptorIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantMethodType;
                case 18:
                    ConstantInvokeDynamic constantInvokeDynamic = new ConstantInvokeDynamic();
                    constantInvokeDynamic.tag = tag;
                    constantInvokeDynamic.bootstrapMethodAttrIndex = IOUtils.readU2();
                    constantInvokeDynamic.nameAndTypeIndex = IOUtils.readU2();
                    constantPool.cpInfo[i] = constantInvokeDynamic;

                default:
                    System.out.println("constantPool integer_tag " + integerTag);
                    return;
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
