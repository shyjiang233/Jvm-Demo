package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:CONSTANT_NameAndType_info给出字段或方法的名称和描述
         符。CONSTANT_Class_info和CONSTANT_NameAndType_info加在
         一起可以唯一确定一个字段或者方法。其结构如下：CONSTANT_NameAndType_info {
                                         u1 tag;
                                       u2 name_index;
                                       u2 descriptor_index;
                                          }字段或方法名由name_index给出，字段或方法的描述符由
                           descriptor_index给出。name_index和descriptor_index都是常量池索
引，指向CONSTANT_Utf8_info常量。字段和方法名就是代码中出
现的（或者编译器生成的）字段或方法的名字。Java虚拟机规范定义
了一种简单的语法来描述字段和方法，可以根据下面的规则生成描
述符。
1）类型描述符。
①基本类型byte、short、char、int、long、float和double的描述符
是单个字母，分别对应B、S、C、I、J、F和D。注意，long的描述符是J
而不是L。
②引用类型的描述符是L＋类的完全限定名＋分号。
③数组类型的描述符是[＋数组元素类型描述符。
2）字段描述符就是字段类型的描述符。
3）方法描述符是（分号分隔的参数类型描述符）+返回值类型描
述符，其中void返回值由单个字母V表示。

 */public class ConstantNameAndTypeInfo implements ConstantInfo {

    public int nameIdx;
    public int descIdx;
    @Override
    public void readInfo(IOUtils utils) {
           nameIdx=utils.readU2();
           descIdx=utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_NAMEANDTYPE;
    }
}
