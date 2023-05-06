package Cmd;

import classfile.ClassFile;
import classfile.MemberInfo;
import classfile.attribute.AttributeInfo;
import classpath.ClassPath;

public class XjreHandler extends CommadHandler{
    @Override
    public void handleCommand(String[] args) {
        if("-Xjre".equals(args[1])){
            System.out.println("successful");
            ClassPath classPath = new ClassPath(null,null);
            byte[] classData = classPath.readClass(args[2]);
            ClassFile classFile = new ClassFile(classData);
            int majorVersion=classFile.getMajorVersion();
            int minorVersion=classFile.getMinorVersion();
            int accessFlags=classFile.getAccessFlags();
            String classname=classFile.getClassName();
            String suppername=classFile.getSuperClassName();
            System.out.println("classFile.getMajorVersion: " + classFile.getMajorVersion());
            System.out.println("classFile.getMinorVersion: " + classFile.getMinorVersion());
            System.out.println("classFile.getAccessFlags: " + classFile.getAccessFlags());
            System.out.println("classFile.getClassName: " + classFile.getClassName());
            System.out.println("classFile.getSuperClassName: " + classFile.getSuperClassName());
            System.out.println("interface names:");
            for (String name : classFile.getInterfaceNames()) {
                System.out.println(name);
            }
            System.out.println("---------------------");
            System.out.println("field count: " + classFile.getFields().length);
            for (MemberInfo name : classFile.getFields()) {
                System.out.println(name.getName());
            }
            System.out.println("---------------------");
            System.out.println("method count: " + classFile.getMethods().length);
            for (MemberInfo name : classFile.getMethods()) {
                System.out.println(name.getName() + ":" + name.getDescriptor());
            }
            System.out.println("---------------------");
            System.out.println("constantPool count: "+classFile.getConstantPool().getConstantPoolCount());
            System.out.println("---------------------");
            System.out.println("attribute count:"+classFile.getAttributes().length);
            for (AttributeInfo attribute:classFile.getAttributes()){
                System.out.println(attribute.getClass());
            }
        }else if (successor != null) {
            successor.handleCommand(args);
        }
    }
}
