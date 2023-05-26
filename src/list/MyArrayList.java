package list;

// Generic
public class MyArrayList<E> implements MyListInterface<E> {

    private Object arr[];
    private int capacity;
    private int size;

    public MyArrayList() {

        this.capacity = 8;
        this.arr = new Object[capacity];
        this.size = 0;

    }

    public void add(E x) {
        if(size < capacity) {
            arr[size++] = x;
        } else {
            Object tmp[]= new Object[capacity];
            for(int i  = 0; i < capacity; i++)
                tmp[i] = arr[i];
            arr = new Object[2*capacity];
            for (int i = 0; i < capacity; i++)
                arr[i] = tmp[i];
            arr[size++] = x;
            capacity *= 2;
        }
    }

    public E get(int i ){
        if(i >= size || i < 0)
            throw new IllegalArgumentException("index out of bound");
        return (E)arr[i];
    }

}
