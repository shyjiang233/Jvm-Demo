package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:CONSTANT_Fieldref_info表示字段符号引用，
 */public class ConstantFieldRefInfo extends ConstantMemberRef {
    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }


    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }
}
