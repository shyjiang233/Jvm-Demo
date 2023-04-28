package classpath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author: zhangxin
 * Time: 2017/4/30 0030.
 * Desc: 表示目录形式的类路径,这是相对来说最简单的一种了,拿到的直接就是指定的路径
 */
public class DirectoryEntry extends Entry {
    private String absDir;

    public DirectoryEntry(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            absDir = dir.getAbsolutePath();
        }
    }


    @Override
    byte[] readClass(String className) throws IOException {
        if (absDir == null) {
            return null;
        }
        Path file = Paths.get(absDir,className);
        if (!Files.exists(file)) {
            return null;
        }
        /*Files.readAllBytes() 是一个 Java 8 中的文件读取方法，用于读取指定路径下的文件的所有字节*/
        return Files.readAllBytes(file);
    }


    @Override
    String printClassName() {
        return absDir;
    }
}
