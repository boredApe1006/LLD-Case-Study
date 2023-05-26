package cache;

public interface CachePolicy {

     String evict();

      void update(String key);
}
