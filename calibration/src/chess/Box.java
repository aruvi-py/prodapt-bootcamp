package chess;

public class Box<T> {
  private boolean locked;
  private T value;
  

  public void lock() {
    locked = true;
  }

  public void unlock() {
    locked = false;
  }

  public T getValue() throws Exception {
    if (locked)
      throw new Exception();
    else
      return value;
  }

  public void setValue(T newVal) throws Exception {
    if (locked)
      throw new Exception();
    else
      this.value = newVal;
  }
  
  public void transferFrom(Box<? extends T> other) throws Exception {
    if (other.locked)
      throw new Exception();
    this.value = other.value;
  }
}
