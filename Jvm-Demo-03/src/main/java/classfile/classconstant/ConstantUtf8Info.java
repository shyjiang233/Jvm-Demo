package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang233
*  Desc:CONSTANT_Utf8_info常量里放的是MUTF-8编码的字符串，
         结构如下：CONSTANT_Utf8_info {
      u1 tag;
      u2 length;
      u1 bytes[length];
}*/
public class ConstantUtf8Info  implements ConstantInfo {
    @Override
    public void readInfo(IOUtils reader) {

    }

    @Override
    public int tag() {
        return 0;
    }
}
