package classfile.attribute;

import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*Author:shyjiang233
 *  Desc:
 */public class SourceFileAttribute implements Attribute_info{

    //sourcefile_index是常量池索引，指向CONSTANT_Utf8_info常量，其常量值是源码文件的文件名
    int sourceFileIndex;
    ConstantPool constantPool;
    public SourceFileAttribute(ConstantPool constantPool){
        this.constantPool=constantPool;

    }
     @Override
    public void readInfo(IOUtils utils) {
     sourceFileIndex=utils.readU2();
    }
     public  String  getFileName(){
        return  constantPool.getUtf8(sourceFileIndex);
     }
}
