package classfile.classconstant;

import classfile.constantpool.ConstantInfo;
import common.IOUtils;
/*Author:shyjiang233
*  Desc:CONSTANT_Double_info {
u1 tag;
u4 high_bytes;
u4 low_bytes;
}
*/
public class ConstantDoubleInfo implements ConstantInfo {
    private Double val;
    @Override
    public void readInfo(IOUtils utils) {
         this.val=utils.readU8Double();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }
    Double value(){
        return this.val;
    }
}
