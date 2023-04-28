package classpath;

import java.io.File;
import java.util.ArrayList;

/**
 * Author: zhangxin
 * Time: 2017/4/30 0030.
 * Desc:处理的是路径匹配的 xxx.* 的情况
 * 首先把路径末尾的星号去掉，得到baseDir，然后遍历该baseDir路径下的文件,只取以 .jar 结尾的文件;
 *
 * 这个类其实是CompositeEntry的一个包装类;
 */
public class WildcardEntry extends Entry {

    public MultipPathsEntry multipPathsEntry;

    public WildcardEntry(String jreLibPath) {

        String baseDir = jreLibPath.substring(0, jreLibPath.length() - 1);  //去掉最后的一个字符 *
        File dir = new File(baseDir);
        File[] files = dir.listFiles();
        multipPathsEntry = new MultipPathsEntry();
        multipPathsEntry.Entries = new ArrayList<Entry>();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                multipPathsEntry.Entries.add(new ZipJarEntry(baseDir,file.getName()));
            }
        }

    }

    @Override
    byte[] readClass(String className) {
        return multipPathsEntry.readClass(className);
    }

    @Override
    String printClassName() {
        return null;
    }
}
