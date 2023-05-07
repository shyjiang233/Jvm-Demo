package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:CONSTANT_String_info常量表示java.lang.String字面量，结构
          如下：CONSTANT_String_info {
                       u1 tag;
                    u2 string_index;
}可以看到，CONSTANT_String_info本身并不存放字符串数据，
只存了常量池索引，这个索引指向一个CONSTANT_Utf8_info常
量。

 */public class ConstantStringInfo implements ConstantInfo {

  private ConstantPool constantPool;
   private   int strindex;
   public ConstantStringInfo(ConstantPool constantPool){
         this.constantPool=constantPool;
   }
    @Override
    public void readInfo(IOUtils utils) {
           this.strindex=utils.readU2();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_STRING;
    }
    public String string(){
       return this.constantPool.getUtf8(strindex);
    }
}
