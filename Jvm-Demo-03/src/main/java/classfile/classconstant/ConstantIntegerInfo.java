package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;

public class   ConstantIntegerInfo implements ConstantInfo {

    private  int val;
    @Override
    public void readInfo(IOUtils utils) {
       this.val=utils.readU4Int();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }
    public Integer value(){
        return this.val;
    }
}
