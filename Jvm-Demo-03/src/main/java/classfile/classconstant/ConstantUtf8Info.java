package classfile.classconstant;

import classfile.ClassReader;

import java.io.IOException;
import java.io.UTFDataFormatException;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:放的是MUTF-8编码的字符串,
 * 注意，字符串在class文件中是以MUTF-8（Modified UTF-8）方式编码的。
 * <p>
 * MUTF-8编码方式和UTF-8大致相同，但并不兼容。
 * 差别有两点：
 * 一是null字符（代码点U+0000）会被编码成2字节：0xC0、0x80；
 * 二是补充字符（Supplementary Characters，代码点大于U+FFFF的Unicode字符）是按UTF-16拆分为代理对（Surrogate Pair）分别编码的
 * <p>
 * 字段名(变量名)、字段描述符等就是以字符串的形式存储在class文件中的
 */
public class ConstantUtf8Info implements ConstantInfo {
    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.readUint16();
        byte[] bytes = reader.readBytes(length);
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_UTF8;
    }

    public String str(){
        return this.str;
    }




}
