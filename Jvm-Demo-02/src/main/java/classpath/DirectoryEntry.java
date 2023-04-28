package classpath;

import java.io.*;
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
        return Files.readAllBytes(file);
    }


    @Override
    String printClassName() {
        return absDir;
    }
}
