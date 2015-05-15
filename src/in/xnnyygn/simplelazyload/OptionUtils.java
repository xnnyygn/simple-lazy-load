package in.xnnyygn.simplelazyload;

/**
 * Utilities for options.
 * 
 * @author xnnyygn
 */
public class OptionUtils {

  @SuppressWarnings("rawtypes")
  private static final None NONE = new None();

  @SuppressWarnings("unchecked")
  public static <T> Option<T> of(T value) {
    return value != null ? new Some<T>(value) : NONE;
  }

  public static <T> T get(Option<T> option) {
    return isEmpty(option) ? null : option.get();
  }

  public static <T> boolean isEmpty(Option<T> option) {
    return option == null || option.isEmpty();
  }

  @SuppressWarnings("unchecked")
  public static <T> Option<T> none() {
    return NONE;
  }

  public static <T> Option<T> some(T value) {
    return new Some<T>(value);
  }

}
