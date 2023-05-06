package classfile.classconstant;


import classfile.ClassReader;
import common.ByteUtils;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:
 */
public class ConstantDoubleInfo implements ConstantInfo {

    private double val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TDouble();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }

    public double value(){
        return this.val;
    }

}