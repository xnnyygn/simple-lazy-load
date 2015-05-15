package in.xnnyygn.simplelazyload;

/**
 * Future value.
 * <p>
 * The core object.
 * </p>
 * 
 * @author xnnyygn
 */
public class FutureValue<T> implements Option<T> {

  /**
   * A static method to make a FutureValue.
   * 
   * @param f loader
   * @return future value instance, never be null
   */
  public static <T> FutureValue<T> of(Function0<T> f) {
    if (f == null) {
      throw new IllegalArgumentException("generator must not be null");
    }
    return new FutureValue<T>(f);
  }

  protected final Function0<T> f;
  protected Option<T> underlying;

  protected FutureValue(Function0<T> f) {
    super();
    this.f = f;
  }

  protected Option<T> delegate() {
    // a model such as DTO is used in only one thread typically
    // so it's no need to add thread safe function here
    if (underlying == null) {
      underlying = OptionUtils.of(f.apply());
    }
    return underlying;
  }

  @Override
  public boolean isEmpty() {
    return delegate().isEmpty();
  }

  @Override
  public T get() {
    return delegate().get();
  }

  @Override
  public T getOrElse(T defaultValue) {
    return delegate().getOrElse(defaultValue);
  }

  /**
   * Output object in string format.
   * <p>
   * It's safe to output a future value since it will not trigger the loader.
   * </p>
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "FutureValue [underlying=" + underlying + "]";
  }

}
