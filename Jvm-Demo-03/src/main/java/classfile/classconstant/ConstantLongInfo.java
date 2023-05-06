package classfile.classconstant;


import classfile.ClassReader;
import common.ByteUtils;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:
 */
public class ConstantLongInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TLong();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_LONG;
    }

    public long value(){
        return this.val;
    }

}