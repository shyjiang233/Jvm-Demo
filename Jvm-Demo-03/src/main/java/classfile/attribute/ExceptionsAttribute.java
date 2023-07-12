package classfile.attribute;

/*Author:shyjiang233
 *  Desc:ceptions是变长属性，记录方法抛出的异常表
 */

import common.IOUtils;

/*
Exceptions_attribute {
u2 attribute_name_index;
u4 attribute_length;
u2 number_of_exceptions;
u2 exception_index_table[number_of_exceptions];
}
 */public class ExceptionsAttribute implements Attribute_info{

     int[] exceptionIndexTable;
     @Override
    public void readInfo(IOUtils utils) {
   this.exceptionIndexTable=utils.readUs();
    }

}
