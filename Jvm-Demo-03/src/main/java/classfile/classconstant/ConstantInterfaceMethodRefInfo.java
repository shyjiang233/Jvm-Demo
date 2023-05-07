package classfile.classconstant;

import classfile.constantpool.ConstantPool;

/*Author:shyjiang233
 *  Desc:表示接口方法符号引用
 */public class ConstantInterfaceMethodRefInfo extends ConstantMemberRef {
    public ConstantInterfaceMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
       return  this.CONSTANT_TAG_INTERFACEMETHODREF ;
    }
}