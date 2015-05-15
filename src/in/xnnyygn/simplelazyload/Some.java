package in.xnnyygn.simplelazyload;

/**
 * Some value.
 * 
 * @author xnnyygn
 */
final class Some<T> implements Option<T> {

  private final T value;

  public Some(T value) {
    if (value == null) {
      throw new IllegalArgumentException("value should not be null");
    }
    this.value = value;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public T get() {
    return value;
  }

  @Override
  public T getOrElse(T defaultValue) {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Some<?> other = (Some<?>) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Some [" + value + "]";
  }

}
