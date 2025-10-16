package lab6;

import java.util.*;


/**
 * A custom list implementation that stores {@link Toy} objects.
 * The list is backed by a dynamically resized array that increases
 * its capacity by 30% when it becomes full.
 *
 * @param <T> the type parameter representing the toy age group or category
 */
public class ToyList<T> implements List<Toy<T>> {
    /** Default initial capacity of the internal array. */
    private static final int DEFAULT_CAPACITY = 15;

    /** Internal array to store Toy objects. */
    private Toy<T>[] elements;

    /** Current number of elements in the list. */
    private int size = 0;



    // ----------------- Constructors -----------------

    /**
     * Creates an empty ToyList with the default capacity (15).
     */
    @SuppressWarnings("unchecked")
    public ToyList() {
        elements = (Toy<T>[]) new Toy[DEFAULT_CAPACITY];
    }

    /**
     * Creates a ToyList containing a single toy.
     *
     * @param toy the toy to add
     */
    @SuppressWarnings("unchecked")
    public ToyList(Toy<T> toy) {
        elements = (Toy<T>[]) new Toy[DEFAULT_CAPACITY];
        add(toy);
    }

    /**
     * Creates a ToyList from an existing collection of toys.
     *
     * @param collection the collection to copy toys from
     */
    @SuppressWarnings("unchecked")
    public ToyList(Collection<? extends Toy<T>> collection) {
        elements = (Toy<T>[]) new Toy[Math.max(DEFAULT_CAPACITY, collection.size())];
        addAll(collection);
    }



    // ----------------- Private utility methods -----------------

    /**
     * Increases the capacity of the internal array by 30%.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.3) + 1;
            Toy<T>[] newArray = (Toy<T>[]) new Toy[newCapacity];

            // System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    /**
     * Validates index for access operations.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }



    // ----------------- List interface implementation -----------------

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the specified toy to the end of this list.
     * Expands internal capacity by 30% if necessary.
     *
     * @param toy the toy to be added
     * @return true (as specified by {@link List#add})
     */
    @Override
    public boolean add(Toy<T> toy) {
        ensureCapacity();
        elements[size++] = toy;
        return true;
    }

    /**
     * Returns the toy at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the toy at the specified position
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @Override
    public Toy<T> get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Replaces the toy at the specified position in this list with the specified toy.
     *
     * @param index index of the element to replace
     * @param toy toy to be stored at the specified position
     * @return the toy previously at the specified position
     */
    @Override
    public Toy<T> set(int index, Toy<T> toy) {
        checkIndex(index);
        Toy<T> old = elements[index];
        elements[index] = toy;
        return old;
    }

    /**
     * Inserts the specified toy at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right.
     *
     * @param index index at which the specified toy is to be inserted
     * @param toy the toy to be inserted
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @Override
    public void add(int index, Toy<T> toy) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = toy;
        size++;
    }

    /**
     * Removes the toy at the specified position in this list.
     *
     * @param index the index of the element to remove
     * @return the toy that was removed
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @Override
    public Toy<T> remove(int index) {
        checkIndex(index);
        Toy<T> removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if present.
     *
     * @param o the object to be removed
     * @return true if an element was removed
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all elements from this list. The list will be empty after this call.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o))
                return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(elements[i], o))
                return i;
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<Toy<T>> iterator() {
        return new Iterator<Toy<T>>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public Toy<T> next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[cursor++];
            }
        };
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence.
     *
     * @return an array containing all the elements in this list
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence.
     * The runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements are to be stored, if it is big enough;
     *          otherwise, a new array of the same runtime type is allocated
     * @param <E> the runtime type of the array to contain the collection
     * @return an array containing all the elements in this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size)
            return (E[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) a[size] = null;
        return a;
    }

    /**
     * Checks if this list contains all elements from the specified collection.
     *
     * @param c the collection to check for containment in this list
     * @return {@code true} if all elements are present, {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) return false;
        }
        return true;
    }

    /**
     * Adds all elements from the specified collection to the end of this list.
     *
     * @param c the collection containing elements to be added
     * @return {@code true} if the list changed as a result, {@code false} otherwise
     */
    @Override
    public boolean addAll(Collection<? extends Toy<T>> c) {
        for (Toy<T> toy : c) {
            add(toy);
        }
        return !c.isEmpty();
    }

    /**
     * Inserts all elements from the specified collection starting at the given index.
     *
     * @param index index at which to insert the first element
     * @param c     the collection containing elements to be inserted
     * @return {@code true} if the list changed as a result, {@code false} otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt; size)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(int index, Collection<? extends Toy<T>> c) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (c.isEmpty()) return false;

        ensureCapacity();
        Toy<T>[] newArray = (Toy<T>[]) new Toy[size + c.size()];
        System.arraycopy(elements, 0, newArray, 0, index);

        int pos = index;
        for (Toy<T> toy : c) {
            newArray[pos++] = toy;
        }

        System.arraycopy(elements, index, newArray, pos, size - index);
        elements = newArray;
        size += c.size();
        return true;
    }

    /**
     * Removes all elements from this list that are also contained in the specified collection.
     *
     * @param c the collection containing elements to be removed from this list
     * @return {@code true} if the list changed as a result, {@code false} otherwise
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            while (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     * In other words, removes all elements that are not present in the given collection.
     *
     * @param c the collection containing elements to be retained
     * @return {@code true} if the list changed as a result, {@code false} otherwise
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Not implemented. Throws {@link UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException always
     */
    @Override
    public ListIterator<Toy<T>> listIterator() {
        throw new UnsupportedOperationException("listIterator() not implemented");
    }

    /**
     * Not implemented. Throws {@link UnsupportedOperationException}.
     *
     * @param index starting index of the iterator
     * @throws UnsupportedOperationException always
     */
    @Override
    public ListIterator<Toy<T>> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator(int) not implemented");
    }

    /**
     * Not implemented. Throws {@link UnsupportedOperationException}.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @throws UnsupportedOperationException always
     */
    @Override
    public List<Toy<T>> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList() not implemented");
    }



    // ----------------- toString -----------------
    /**
     * Returns a string representation of this list and its elements.
     *
     * @return a string containing all elements of the list, separated by commas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}