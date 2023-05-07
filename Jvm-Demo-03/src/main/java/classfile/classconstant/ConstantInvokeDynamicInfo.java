package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:
 */public class ConstantInvokeDynamicInfo implements ConstantInfo {
    private int bootstrapMethodAttrIdx;
    private int nameAndTypeIdx;
    @Override
    public void readInfo(IOUtils utils) {
      bootstrapMethodAttrIdx=utils.readU2();
      nameAndTypeIdx=utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INVOKEDYNAMIC;
    }
}
