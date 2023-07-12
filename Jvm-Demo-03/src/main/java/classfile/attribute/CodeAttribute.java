package classfile.attribute;

import classfile.constantpool.ConstantPool;
import common.IOUtils;
import lombok.Data;

/*Author:shyjiang233
 *  Desc:
 */public class CodeAttribute implements Attribute_info {
    private ConstantPool constantPool;
    private int maxStack;//操作数栈的最大深度
    private int maxLocals;//局部变量表的大小
    private byte[] code;//字节码
    private ExceptionTableEntry[] exceptionTable;
    private Attribute_info[] attribute_infos;

    public CodeAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }
    public int maxStack() {
        return this.maxStack;
    }

    public int maxLocals() {
        return this.maxLocals;
    }

    public byte[] getCode() {
        return this.code;
    }

    public ExceptionTableEntry[] exceptionTable() {
        return this.exceptionTable;
    }

    public Attribute_info[] attributes() {
        return this.attribute_infos;
    }
    @Override
    public void readInfo(IOUtils utils) {
     this.maxStack=utils.readU2();
     this.maxLocals=utils.readU2();
     int  DataLength=utils.readU4Int();

    }

    @Data
    static class ExceptionTableEntry {

        private int startPC;
        private int endPC;
        private int handlerPC;
        private int catchType;

        ExceptionTableEntry(int startPC, int endPC, int handlerPC, int catchType) {
            this.startPC = startPC;
            this.endPC = endPC;
            this.handlerPC = handlerPC;
            this.catchType = catchType;
        }
      static ExceptionTableEntry[] readExceptionTable(IOUtils utils){
       int  exception_table_length=utils.readU2();
       ExceptionTableEntry[] exceptionTableTable=new ExceptionTableEntry[exception_table_length];
          for (int i = 0; i <exception_table_length ; i++) {
              exceptionTableTable[i]=new ExceptionTableEntry(utils.readU2(),utils.readU2(),utils.readU2(),utils.readU2());
          }
          return  exceptionTableTable;
      }

    }
}
