package in.xnnyygn.simplelazyload;

/**
 * Option.
 * 
 * @author xnnyygn
 */
public interface Option<T> {

  boolean isEmpty();

  T get();

  T getOrElse(T defaultValue);

}
