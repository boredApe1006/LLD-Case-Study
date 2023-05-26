package file_system;

import java.util.List;

public class Directory extends File{
    private final List<File> files;
    protected Directory(String name, List<File> files) {
        super(name);
        this.files = files;
    }

    @Override
    public void accept(Traverser traverser) {
        traverser.traverseDir(this);
    }

//    @Override
//    public void traverse() {
//        // multiple if - else kyoki xml ka traverser alag csv ka traverser alag
//    }
}
