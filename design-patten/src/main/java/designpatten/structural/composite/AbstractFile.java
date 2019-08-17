package designpatten.structural.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
    void killVirus();
}

@Data
class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件：" + name + ", 进行查杀！");
    }
}

@Data
class TxtFile implements AbstractFile {
    private String name;

    public TxtFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件：" + name + ", 进行查杀！");
    }
}


@Data
class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件：" + name + ", 进行查杀！");
    }
}


class Folder implements AbstractFile {
    private String name;

    // 定义容器，用来存放容器构建下的子节点
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        super();
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("----文件夹：" + name + ", 进行查杀");

        for(AbstractFile file : list) {
            file.killVirus();
        }
    }
}