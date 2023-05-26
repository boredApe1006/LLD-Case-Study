package file_system;

public class Symlink extends File{


    private final String actualFileName;
    protected Symlink(String name, String actualFileName) {
        super(name);
        this.actualFileName = actualFileName;
    }

//    @Override
//    public void traverse() {
//
//    }
}
