package classfile.constantpool;

import common.IOUtils;

/*   Author:shyjiang233
*    Desc: 常量池也是一张表，根据tag的不同构成不同的常量信息*/
public class ConstantPool {

    private ConstantInfo[] constantInfos;
    private  int size;//真实Constant常量数量
    public ConstantPool(IOUtils utils) {
    int constantPoolCount=utils.readU2();
    constantInfos=new ConstantInfo[constantPoolCount];
        for (int i = 1; i <constantPoolCount ; i++) {
            constantInfos[i]=ConstantInfo.readConstantInfo(utils,this);
            size++;
            switch (constantInfos[i].tag()) {
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                    i++;
                    break;
            }
        }
    }


    //常量池查找字段或方法的名字和描述符
    public String getName(int index) {

    }

    //常量池查找字段或方法的描述符,描述符其实就是由其对应的类型名字对应而成;
    public String getType(int index) {

    }

    public String[] getNameAndType(int index) {

    }

    public String getClassName(int index) {

    }

    //只要调用这个方法，一定是想去读字符串常量了，所以拿到index所对应的常量后，直接强转为ConstantUtf8Info，然后获取其val值；
    public String getUtf8(int index) {

    }
    public ConstantInfo[] getInfos() {
        return constantInfos;
    }
}
