package file_system;

public class SimpleFile extends File{

    protected SimpleFile(String name) {
        super(name);
    }

    @Override
    public void accept(Traverser traverser) {
     traverser.traverseSimpleFile(this);
    }

//
}
