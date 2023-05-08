package classfile;

import classfile.attribute.Attribute_info;
import classfile.constantpool.ConstantPool;
import common.IOUtils;

public class Member_info {
    private ConstantPool constantPool;
    private int accessFlags;
    private int nameIdx;
    private int descriptorIdx;
    private Attribute_info[] attributes;
    Member_info(ConstantPool constantPool, IOUtils utils){
         this.constantPool=constantPool;
        this.accessFlags=utils.readU2();
       this.nameIdx=utils.readU2();
       this.descriptorIdx=utils.readU2();
       this.attributes=Attribute_info.readAttributes(utils,constantPool);
    }

    public static Member_info[] readMembers(IOUtils utils, ConstantPool constantPool) {
        int memberCount = utils.readU2();
        Member_info[] members = new Member_info[memberCount];
        for (int i = 0; i < memberCount; i++) {
            members[i] = new Member_info(constantPool, utils);
        }
        return members;
    }


    public int accessFlags() {
        return this.accessFlags;
    }

    public String name() {
        return this.constantPool.getUtf8(this.nameIdx);
    }

    public String descriptor() {
        return this.constantPool.getUtf8(this.descriptorIdx);
    }
}
