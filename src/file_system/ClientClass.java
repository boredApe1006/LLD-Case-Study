package file_system;

public class ClientClass {

    private final static File file;
    private final static Traverser traverser;

    public static void main(String[] args) {
       // traverser.traverse(file); I have no method like that I need to know which type it is whi call fir
//        if(file instanceof Directory)
//            traverser.traverseDir((Directory) file);
//        else if (file instanceof SimpleFile)
//            traverser.traverseSimpleFile((SimpleFile) file);
        // ...

        file.accept(traverser);
    }
    // the thing we did is also called double dispatch
    // visitor design pattern

}
