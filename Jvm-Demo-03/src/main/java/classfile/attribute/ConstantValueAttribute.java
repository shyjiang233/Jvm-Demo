package classfile.attribute;

import common.IOUtils;

/*Author:shyjiang233
 *  Desc:
 */public class ConstantValueAttribute implements Attribute_info{
    int constantValueIndex;
    @Override
    public void readInfo(IOUtils utils) {
         constantValueIndex=utils.readU2();
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
