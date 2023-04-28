package classpath;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Author: zhangxin
 * Time: 2017/4/30 0030.
 * Desc: CompositeEntry由众多的Entry组成，正好可以表示成 Entry list;
 * 构造函数把参数（路径列表）按分隔符分成小路径，然后把每个小路径都转换成具体的 Entry实例
 */
public class MultipPathsEntry extends Entry {
    //不用担心,list中的entry是按照父类来转入的,在真正执行的时候,是按照各自的实际类型执行readClass()方法
    ArrayList<Entry> Entries;
    private String pathList;

    public MultipPathsEntry() {
    }

    public MultipPathsEntry(String pathList, String pathListSeparator) {
        this.pathList = pathList;
        String[] paths = pathList.split(pathListSeparator);
        Entries = new ArrayList<Entry>(paths.length);
        for (String path:paths) {
            Entries.add(new DirectoryEntry(path));
        }
    }

    @Override
    byte[] readClass(String className) {
        return Entries.stream()
                .map(entry -> {
                    try {
                        return entry.readClass(className);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(data -> data != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    String printClassName() {
        return pathList;
    }
}
