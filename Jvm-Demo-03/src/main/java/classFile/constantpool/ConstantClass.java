package classFile.constantpool;

import common.U1;
import common.U2;

public class ConstantClass extends ConstantBase {
    public U1 tag;
    public U2 nameIndex;/* name_index 是常量池索引，指向 CONSTANT_Utf8_info 常量*/
}

