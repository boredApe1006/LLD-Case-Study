package file_system;

public interface Traverser {

    void traverseDir(Directory directory);
    void traverseSimpleFile(SimpleFile simpleFile);

    void traverseSymlink(SimpleFile simpleFile);

    // We will use method overloading
//    void traverse(Directory directory);
//    void traverse(SimpleFile simpleFile);
//
//    void traverse(Symlink symlink);
}
