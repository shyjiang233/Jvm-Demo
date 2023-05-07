package classfile;

import classfile.attribute.Attribute_info;
import classfile.constantpool.ConstantPool;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import common.IOUtils;

public class Method_info {
    private ConstantPool constantPool;
    private int accessFlags;
    private int nameIdx;
    private int descriptorIdx;
    private Attribute_info[] attributes;
    Method_info(ConstantPool constantPool, IOUtils utils){
         this.constantPool=constantPool;
        this.accessFlags=utils.readU2();
       this.nameIdx=utils.readU2();
       this.descriptorIdx=utils.readU2();

    }
}
