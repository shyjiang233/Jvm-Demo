package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

/*Author:shyjiang
* Desc:CONSTANT_Float_info {
u1 tag;
u4 bytes;
}*/
public class ConstantFloatInfo implements ConstantInfo {
    float val;
    @Override
    public void readInfo(IOUtils utils) {
          this.val=utils.readU4Float();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }
    public  Float value(){
        return  val;
    }
}
