package classfile.attribute;

import common.IOUtils;

/*Author:shyjiang233
 *  Desc:Synthetic属性用来标记源文件中不存在、由编译器生成的类成员
 */public class SyntheticAttribute implements Attribute_info{

    int attribute_name_index;
    int attribute_length;
     @Override
    public void readInfo(IOUtils utils) {

    }
}
