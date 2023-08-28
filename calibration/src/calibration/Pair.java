package calibration;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class Pair<T> implements Collection<T> {
  
  private final T fst;
  private final T snd;
  
  public Pair(T fst, T snd) {
    this.fst = fst;
    this.snd = snd;
  }

  @Override
  public int size() {
    return 2;
  }

  @Override
  public boolean isEmpty() {
    return fst == null && snd == null;
  }

  @Override
  public boolean contains(Object o) {
    return o.equals(fst) || o.equals(snd);
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[2];
    arr[0] = fst;
    arr[1] = snd;
    return arr;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T[] toArray(T[] a) {
    a = (T[]) toArray();
    return a;
  }

  @Override
  public boolean add(T e) {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o))
        return false;
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException("Tuples are fixed size");
  }
  
  public T getFst() {
    return fst;
  }
  
  public T getSnd() {
    return snd;
  }
  
  public Optional<T> get(int index) {
    return index == 0 ? Optional.of(fst) : index == 1 ? Optional.of(snd) : Optional.empty();
  }
  
  public Pair<T> swapped() {
    return new Pair<>(snd, fst);
  }
  
  @Override
  public String toString() {
    return String.format("(%s, %s)", fst, snd);
  }

}
