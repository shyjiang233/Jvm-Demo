package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:CONSTANT_Class_info常量表示类或者接口的符号引用，结构
如下： CONSTANT_Class_info {
       u1 tag;
     u2 name_index;
    }和CONSTANT_String_info类似，name_index是常量池索引，指
向CONSTANT_Utf8_info常量。

 */public class ConstantClassInfo implements ConstantInfo {
     public ConstantPool constantPool;
     public int namindex;
     public  ConstantClassInfo(ConstantPool constantPool){
         this.constantPool=constantPool;
     }
    @Override
    public void readInfo(IOUtils utils) {
        namindex=utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }
    public  String name(){
       return  this.constantPool.getUtf8(this.namindex);
    }
}
