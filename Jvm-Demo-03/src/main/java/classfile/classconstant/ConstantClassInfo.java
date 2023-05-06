package classfile.classconstant;

import classfile.ConstantPool;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:表示类或者接口的符号引用
 * 类和超类索引，以及接口表中的接口索引指向的都是CONSTANT_Class_info常量
 * <p>
 * ClassFileTest的this_class索引是5,其 name_index=50,super_class(Object)的索引是6,其name_index=51, 这里其实存的还是名字
 * 5代表的是this_class,本类类名的引用,其值在50处,可以看到常量池50的地方保存的就是jvmgo/book/ch03/ClassFileTest的字符串
 * 51处保存的就是java/lang/Object的字符串
 */
public class ConstantClassInfo implements ConstantInfo {
    ConstantPool constantPool;
    public int nameIndex;

    public int nameIdx;

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
    }

    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }

    @Override
    public int tag() {
        return this.CONSTANT_Class ;
    }
}
