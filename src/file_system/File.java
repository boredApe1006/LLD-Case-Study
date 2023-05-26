package file_system;

public abstract class File {
    private final String name;

    protected File(String name) {
        this.name = name;
    }

  //  public abstract void traverse();
    public String getName() {
        return name;
    }

    public abstract void accept(Traverser traverser);

    /**
    *many more important methods
     */



}
