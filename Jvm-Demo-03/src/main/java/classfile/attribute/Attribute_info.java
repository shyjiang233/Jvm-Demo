package classfile.attribute;

import classfile.constantpool.ConstantPool;
import common.IOUtils;



/*   Author:theshy
*    Desc:和常量池类似，各种属性表达的信息也各不相同，因此无法用
          统一的结构来定义。不同之处在于，常量是由Java虚拟机规范严格
          定义的，共有14种。但属性是可以扩展的，不同的虚拟机实现可以
         定义自己的属性类型。由于这个原因，Java虚拟机规范没有使用
         tag，而是使用属性名来区别不同的属性。属性数据放在属性名之后
          的u1表中，这样Java虚拟机实现就可以跳过自己无法识别的属性。
    属性的结构定义如下：Attribute_info {
u2 attribute_name_index;
u4 attribute_length;
u1 info[attribute_length];
}
*/
public interface Attribute_info {
     void readInfo(IOUtils utils);//自己读取对应的属性信息

    static Attribute_info[] readAttributes(IOUtils utils, ConstantPool constantPool) {
       int attributeCount=utils.readU2();
       Attribute_info[] attribute_infos=new Attribute_info[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
        attribute_infos[i]=readAttribute(utils,constantPool);
        }
        return  attribute_infos;
    }
    static Attribute_info readAttribute(IOUtils utils,ConstantPool constantPool){
          int attribute_name_index=utils.readU2();
          String  attrName=constantPool.getUtf8(attribute_name_index);
          int  attribute_length=utils.readU4Int();
           Attribute_info attribute_info=newAttributeInfo(attrName,attribute_length,constantPool);
           attribute_info.readInfo(utils);
           return  attribute_info;
    }

    static Attribute_info newAttributeInfo(String attrName, int attribute_length, ConstantPool constantPool) {
          switch (attrName){
              case "Deprecated":
                  return new DeprecatedAttribute();
              case "Code":
                    return new CodeAttribute(constantPool);
              default:
                  return new UnidentifiableAttribute(attrName,attribute_length);
          }

    }
}
