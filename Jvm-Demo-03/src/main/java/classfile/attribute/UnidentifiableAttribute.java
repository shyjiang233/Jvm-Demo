package classfile.attribute;

import common.IOUtils;

/*Author:shyjiang233
 *  Desc:其他属性直接读取字节数即可
 */public class UnidentifiableAttribute implements Attribute_info{
    private String attrName;
    private int attrLen;
    private byte[] info;
    public UnidentifiableAttribute(String attrName, int attribute_length) {
         this.attrName=attrName;
          this.attrLen=attribute_length;
    }

    @Override
    public void readInfo(IOUtils utils) {
        info=utils.readBytes(attrLen);
    }
}
