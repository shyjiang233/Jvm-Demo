package classfile.attribute;

import common.IOUtils;

/*Author:shyjiang233
 *  Desc: Deprecated属性用于指出类、接口、字段或方法已经不建议使用，编译器等工具可以根据Deprecated属性输出警告信息。
 */public class DeprecatedAttribute implements Attribute_info{
    int attribute_name_index;
    int attribute_length;

    @Override
    public void readInfo(IOUtils utils) {
        //由于没有数据,所以是空的.
    }
}
