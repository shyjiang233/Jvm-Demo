package classfile.classconstant;

import classfile.ClassReader;
import classfile.ConstantPool;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:本身并不存放字符串数据,只存了常量池索引，这个索引指向一个CONSTANT_Utf8_info常量
 * 所以在readInfo中首先读出索引，然后在去对应的CONSTANT_Utf8_info常量中读取具体的字符串
 */
public class ConstantStringInfo implements ConstantInfo {
    private ConstantPool constantPool;
    private int strIdx;

    public ConstantStringInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.strIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_STRING;
    }

    public String string(){
        return this.constantPool.getUTF8(this.strIdx);
    }
}
