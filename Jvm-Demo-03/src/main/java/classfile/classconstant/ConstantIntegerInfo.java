package classfile.classconstant;


import classfile.ClassReader;
import common.ByteUtils;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc: 使用4字节存储整数常量
 * 实际上比int更小的boolean、byte、short和char类型的常量也放在 CONSTANT_Integer_info 中,也是存的四字节,这是为了4k对齐,可是也造成了字节的浪费;
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private int val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32TInteger();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public int value(){
        return this.val;
    }
}
