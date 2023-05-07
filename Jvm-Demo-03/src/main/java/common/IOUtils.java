package common;

import java.math.BigInteger;

/**
 Author:shyjiang233
 * Desc:java虚拟机定义了u1、u2、u4三种数据类型来表示；1字节、2字节、4字节，无符号整数。
 * 在如下实现中，用增位方式表示无符号类型：
 * u1、u2可以用int类型存储，因为int类型是4字节
 * u4 需要用long类型存储，因为long类型是8字节
 */
public class IOUtils {

    private byte[] data;

    public IOUtils(byte[] data) {
        this.data = data;
    }

    //u1
    public int readU1() {
        byte[] val = readByte(1);
        return byte2int(val);
    }

    //u2
    public int readU2() {
        byte[] val = readByte(2);
        return byte2int(val);
    }

    //u4
    public long readU4() {
        byte[] val = readByte(4);
        String str_hex = new BigInteger(1, val).toString(16);
        return Long.parseLong(str_hex, 16);
    }

    public int readU4Int(){
        byte[] val = readByte(4);
        return new BigInteger(1, val).intValue();
    }

    public float readU4Float() {
        byte[] val = readByte(4);
        return new BigInteger(1, val).floatValue();
    }

    public long readU8Long() {
        byte[] val = readByte(8);
        return new BigInteger(1, val).longValue();
    }

    public double readU8Double() {
        byte[] val = readByte(8);
        return new BigInteger(1, val).doubleValue();
    }

    public int[] readUs() {
        int n = this.readU2();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = this.readU2();
        }
        return s;
    }

    public byte[] readBytes(int n) {
        return readByte(n);
    }
    /*从一个字节数组中读取指定长度的字节，并返回一个新的字节数组，其中包含了读取的这些字节*/
    private byte[] readByte(int length) {
        byte[] copy = new byte[length];// 创建一个与指定长度相等的新字节数组
        System.arraycopy(data, 0, copy, 0, length);// 将 data 数组中前 length 个字节复制到新数组 copy 中
        System.arraycopy(data, length, data, 0, data.length - length);// 将 data 数组中第 length 个字节到最后一个字节向前移动 length 个位置
        return copy;
    }
/*将字节数组转换为对应的整数值*/
    private int byte2int(byte[] val) {
        String str_hex = new BigInteger(1, val).toString(16);
        return Integer.parseInt(str_hex, 16);
    }

}