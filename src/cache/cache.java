package cache;

public interface Cache {


    public void put(String key, String value);

    public String get(String key);
}
