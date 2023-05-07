package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*      Author:shyjiang233
*        Desc:CONSTANT_Long_info使用8字节存储整数常量，结构如下CONSTANT_Long_info {
        u1 tag;
        u4 high_bytes;
        u4 low_bytes;
}
*/
public class ConstantLongInfo implements ConstantInfo {
    Long val;
    @Override
    public void readInfo(IOUtils utils) {
     this.val=utils.readU8Long();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_LONG ;
    }
    Long value(){
        return  val;
    }
}
