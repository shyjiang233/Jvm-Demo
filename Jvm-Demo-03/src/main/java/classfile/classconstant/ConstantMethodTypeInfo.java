package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:
 */public class ConstantMethodTypeInfo implements ConstantInfo {
    private int descriptorIdx;

    @Override
    public void readInfo(IOUtils utils) {
       this.descriptorIdx=utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODTYPE;
    }
}
