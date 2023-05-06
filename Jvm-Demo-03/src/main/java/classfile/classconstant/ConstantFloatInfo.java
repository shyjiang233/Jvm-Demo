package classfile.classconstant;

import classfile.ClassReader;
import common.ByteUtils;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:
 */
public class ConstantFloatInfo  implements ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TFloat();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public float value(){
        return this.val;
    }

}