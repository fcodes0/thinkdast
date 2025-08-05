package org.dast;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    int size;   // Keeps track of the number of elements
    private T[] array;  // Stores elements

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    /**
     * @return the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     */
    @Override
    public int size() {
        return size;
    }

    private void checkInternalCapacity(int newsize){
       if (newsize >= array.length){
           try {
               array = Arrays.copyOf(array, array.length * 2);
           } catch (Exception e) {
               System.err.println("Could not allocate new array");
               throw new ArrayStoreException();
           }
       }
       if(newsize >= array.length)
           checkInternalCapacity(newsize);
    }

    /**
     * @return true if list empty (i.e contains no elements)
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    /**
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(array).iterator();
    }

    /**
     * @return an array containing all the elements in this list in proper sequence (from first to last element).
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(array, 0, size);
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element);
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose
     * @return an array containing the elements of the list
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("Called toArray with null param");
        }

        return null;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param t element whose presence in this collection is to be ensured
     * @return true
     */
    @Override
    public boolean add(T t) {
        checkInternalCapacity(size+1);
        array[size] = t;
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present. If this list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
     * @throws NullPointerException
     */
    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (-1 != idx) {
            remove(idx);
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains all the elements of the specified collection.
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all the elements of the specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if ( o != null && !contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T e: c){
            if(e != null){
                add(e);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        Object[] temp = c.toArray();
        for(int i = temp.length-1;i >= 0;i--){
            if(temp[i] != null){
                add(index,(T)temp[i]);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try{
            c.clear();
        } catch(UnsupportedOperationException e){
            Iterator<?> it = iterator();
            while(it.hasNext()){
                if(c.contains(it.next())) {
                    it.remove();
                }
            }
        }
        return c.isEmpty();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Removes all the elements from this collection. The collection will be empty after this method returns
     */
    @Override
    public void clear() {
        for(int i = 0; i < size;i++){
            array[i] = null;
        }
        size = 0;
    }

    /**
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsErrMsg(index));
        }
        return array[index];
    }

    /**
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return element previously at the specified position
     * @throws UnsupportedOperationException - if the set operation is not supported by this list
     *                                       ClassCastException - if the class of the specified element prevents it from being added to this list
     *                                       NullPointerException - if the specified element is null and this list does not permit null elements
     *                                       IllegalArgumentException - if some property of the specified element prevents it from being added to this list
     *                                       IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T set(int index, T element) {
        T old;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsErrMsg(index));
        }
        old = get(index);
        array[index] = element;
        return old;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsErrMsg(index));
        }

        checkInternalCapacity(size + 1);

        // shift elements right
        for (int i = size+1; i > index; i--) {
            array[i] = array[i-1];
        }

        // store element at index
        array[index] = element;
        size++;
    }

    private String outOfBoundsErrMsg(int index) {
        return "Index: "+index+" Size: "+size;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public T remove(int index) {
        T elemToRemove = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return elemToRemove;
    }

    /**
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int indexOf(Object o) {
        if (null == o) {
            return -1;
        }

        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int lastIndexOf(Object o) {
        if (null == o) {
            return -1;
        }
        for(int i = size;i > -1;i--){
           if(o.equals(array[i])){
               return i;
           }
        }
        return -1;
    }

    // Returns a list iterator over the elements in this list (in proper sequence).
    @Override
    public ListIterator<T> listIterator() {
        return (ListIterator<T>) Arrays.stream(array).toList().iterator();
    }

    // Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
    @Override
    public ListIterator<T> listIterator(int index) {
        return Arrays.stream(array,index,size).toList().listIterator();
    }

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return Arrays.stream(array,fromIndex,toIndex).toList();
    }

    /**
     * @return Returns a string representation of the contents of the specified array
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
