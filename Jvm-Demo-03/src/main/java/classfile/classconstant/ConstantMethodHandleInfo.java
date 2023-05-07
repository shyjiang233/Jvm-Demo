package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:
 */public class ConstantMethodHandleInfo implements ConstantInfo {
    private int referenceKind;
    private int referenceIndex;

    @Override
    public void readInfo(IOUtils utils) {
        this.referenceKind = utils.readU1();
        this.referenceIndex = utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODHANDLE;
    }
}
