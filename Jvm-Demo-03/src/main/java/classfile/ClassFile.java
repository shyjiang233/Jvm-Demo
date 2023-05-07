package classfile;

import classfile.attribute.Attribute_info;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

/*     Author:shyjiang233
*      Desc:*/
public class ClassFile {

        int  magic;	//魔数
        int minor_version;	//次版本号
        int major_version;	//主版本号
        ConstantPool constantPool; //常量池
        int  access_flags;	//类访问标志,表明 class 文件定义的是类还是接口，访问级别是 public 还是 private，等
        int this_classIdx;	//
        int super_classIdx;	//
       int[] interfaces;	//实现的接口,存放在数组中
        Field_info fields[];	//数组中存放这各个字段
        Method_info methods[];	//数组中存放着各个方法
        Attribute_info attributes[];	//数组中存放着各个属性

    /**
     * 将字节码转换为ClassFile
     * @param bytecode
     */
      public void processByteCode(byte[] bytecode){
          IOUtils utils=new IOUtils(bytecode);
          this.readAndCheckMagic(utils);
          this.readAndCheckVersion(utils);
          this.constantPool = this.readConstantPool(utils);
          this.access_flags=utils.readU2();
          this.this_classIdx=utils.readU2();
          this.super_classIdx=utils.readU2();
          this.interfaces=utils.readUs();


      }

    private ConstantPool readConstantPool(IOUtils utils) {
        return new ConstantPool(utils);
    }

    private void readAndCheckMagic(IOUtils utils) {
        long magic = utils.readU8Long();
        if (magic != (0xCAFEBABE & 0x0FFFFFFFFL)) {
            throw new ClassFormatError("magic!");
        }
    }

    private void readAndCheckVersion(IOUtils utils) {
        this.minor_version = utils.readU2();
        this.major_version = utils.readU2();
        switch (this.major_version) {
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (this.minor_version == 0)
                    return;
        }
        throw new UnsupportedClassVersionError();
    }
}
