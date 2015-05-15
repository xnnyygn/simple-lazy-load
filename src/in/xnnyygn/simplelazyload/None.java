package in.xnnyygn.simplelazyload;

/**
 * None.
 * 
 * @author xnnyygn
 */
final class None<T> implements Option<T> {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public T get() {
    throw new IllegalStateException("no value");
  }

  @Override
  public T getOrElse(T defaultValue) {
    return defaultValue;
  }

  @Override
  public String toString() {
    return "None";
  }

}
