package inmemoryMySQL.data;

public class KeyValPair {

    private final String key;
    private final String val;

    public KeyValPair(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }
}
