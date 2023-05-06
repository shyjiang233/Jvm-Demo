package classfile.classconstant;

import classfile.ClassReader;
import classfile.ConstantPool;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc: 常量的抽象类，这里实现了常量池中所有常量的类型。
 * 由于常量池中存放的信息各不相同，所以每种常量的格式也不同。常量数据的第一字节是tag，用来区分常量类型。
 * 根据在常量池的字节码的每个tag字节，可以判断下一个常量类型是什么，每个常量占用多少个字节都是可以确定的，接着再读取下一个tag，确定下一个常量类型；
 */

    public interface ConstantInfo {

        int CONSTANT_TAG_CLASS = 7;
        int CONSTANT_TAG_FIELDREF = 9;
        int CONSTANT_TAG_METHODREF = 10;
        int CONSTANT_TAG_INTERFACEMETHODREF = 11;
        int CONSTANT_TAG_STRING = 8;
        int CONSTANT_TAG_INTEGER = 3;
        int CONSTANT_TAG_FLOAT = 4;
        int CONSTANT_TAG_LONG = 5;
        int CONSTANT_TAG_DOUBLE = 6;
        int CONSTANT_TAG_NAMEANDTYPE = 12;
        int CONSTANT_TAG_UTF8 = 1;
        int CONSTANT_TAG_METHODHANDLE = 15;
        int CONSTANT_TAG_METHODTYPE = 16;
        int CONSTANT_TAG_INVOKEDYNAMIC = 18;

        void readInfo(ClassReader reader);

        int tag();

        static ConstantInfo readConstantInfo(ClassReader reader, ConstantPool constantPool) {
            int tag = reader.readUint8();
            ConstantInfo constantInfo = newConstantInfo(tag, constantPool);
            constantInfo.readInfo(reader);
            return constantInfo;
        }

        static ConstantInfo newConstantInfo(int tag, ConstantPool constantPool) {
            switch (tag) {
                case CONSTANT_TAG_INTEGER:
                    return new ConstantIntegerInfo();
                case CONSTANT_TAG_FLOAT:
                    return new ConstantFloatInfo();
                case CONSTANT_TAG_LONG:
                    return new ConstantLongInfo();
                case CONSTANT_TAG_DOUBLE:
                    return new ConstantDoubleInfo();
                case CONSTANT_TAG_UTF8:
                    return new ConstantUtf8Info();
                case CONSTANT_TAG_STRING:
                    return new ConstantStringInfo(constantPool);
                case CONSTANT_TAG_CLASS:
                    return new ConstantClassInfo(constantPool);
                case CONSTANT_TAG_FIELDREF:
                    return new ConstantFieldRefInfo(constantPool);
                case CONSTANT_TAG_METHODREF:
                    return new ConstantMethodRefInfo(constantPool);
                case CONSTANT_TAG_INTERFACEMETHODREF:
                    return new ConstantInterfaceMethodRefInfo(constantPool);
                case CONSTANT_TAG_NAMEANDTYPE:
                    return new ConstantNameAndTypeInfo();
                case CONSTANT_TAG_METHODTYPE:
                    return new ConstantMethodTypeInfo();
                case CONSTANT_TAG_METHODHANDLE:
                    return new ConstantMethodHandleInfo();
                case CONSTANT_TAG_INVOKEDYNAMIC:
                    return new ConstantInvokeDynamicInfo();
                default:
                    throw new ClassFormatError("constant pool tag");
            }
        }
    }


