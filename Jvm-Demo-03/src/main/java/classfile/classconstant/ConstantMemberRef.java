package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc: * CONSTANT_Fieldref_info表示字段符号引用
 * CONSTANT_Methodref_info表示普通（非接口）方法符号引用
 * CONSTANT_InterfaceMethodref_info表示接口方法符号引用
 * 这三种类型结构一样,所以给出统一的类结构;
 * 然后定义三个类继承这个超类;
 * class_index和name_and_type_index都是常量池索引，分别指向CONSTANT_Class_info和CONSTANT_NameAndType_info常量。
 */public class ConstantMemberRef implements ConstantInfo {
    protected ConstantPool constantPool;
    protected int classIdx;
    private int nameAndTypeIdx;




    public ConstantMemberRef(ConstantPool constantPool) {
  this.constantPool=constantPool;
    }

    @Override
    public void readInfo(IOUtils utils) {
       classIdx=utils.readU2();
       nameAndTypeIdx=utils.readU2();
    }

    @Override
    public int tag() {
        return 0;
    }
    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }
    public String getDescriptor() {
        return constantPool.getType(this.nameAndTypeIdx);
    }
}
