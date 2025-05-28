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

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(array,0,size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(size >= array.length){
            try{
                array = Arrays.copyOf(array,array.length*2);
            }catch (Exception e){
                System.err.println("Could not allocate new array");
                throw new ArrayStoreException();
            }
        }
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        //TODO: Find element to remove, remove and shrink array to fill gap in
        int idx = indexOf(o);
        if(-1 != idx)
        {
            remove(idx);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean hasAll = false;
        Iterator<?> it = c.iterator();
        do{
           hasAll = it.hasNext() && contains(it.next());
        }while(hasAll);
        return hasAll;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
    // Returns the element at the specified position in this list.

    /**
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws
     *     IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return element previously at the specified position
     * @throws
     *     UnsupportedOperationException - if the set operation is not supported by this list
     *     ClassCastException - if the class of the specified element prevents it from being added to this list
     *     NullPointerException - if the specified element is null and this list does not permit null elements
     *     IllegalArgumentException - if some property of the specified element prevents it from being added to this list
     *     IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T set(int index, T element) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        add(index,element);
        return get(index);
    }

    // Inserts the specified element at the specified position in this list
    @Override
    public void add(int index, T element) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        // add element to get resizing
        add(element);

        // shift elements
        for(int i = index;i < size;i++){
            array[i] = array[i+1];
        }

        // store element at index
        array[index] = element;
    }

    @Override
    public T remove(int index) {
        T elemToRemove;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        elemToRemove = array[index];
        array[index] = null;
        for(int i = index; i < size-1;i++){
            array[i] = array[i+1];
        }
        return elemToRemove;
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    @Override
    public int indexOf(Object o) {
        for(int i = 0;i < size;i++){
            if(o.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    // Returns the index of the last occurrence of the specified element.
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    // Returns a list iterator over the elements in this list (in proper sequence).
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }
    // Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array,size));
    }
}
