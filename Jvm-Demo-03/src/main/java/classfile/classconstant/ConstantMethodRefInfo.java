package classfile.classconstant;

import classfile.constantpool.ConstantPool;

/*Author:shyjiang233
 *  Desc:CONSTANT_Methodref_info表示普通（非接口）方法符号引用
 */public class ConstantMethodRefInfo extends ConstantMemberRef{
    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }
    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODREF;
    }
}
