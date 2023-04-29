package classFile;


import classFile.attribute.AttributeInfo;
import common.U2;

public class MethodInfo {
    public U2 accessFlags;
    public U2 nameIndex;
    public U2 descriptorIndex;
    public U2 attributeCount;
    public AttributeInfo[] attributes;


}
