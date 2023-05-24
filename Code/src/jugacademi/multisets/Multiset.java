package jugacademi.multisets;


import java.util.Collection;

public class Multiset<E> implements java.util.Set<E>{
    private java.util.HashMap<E,Integer> elements = new java.util.HashMap<>();

    public static void main(String[] args) {
        Multiset<Integer> mset = new Multiset<Integer>();
        mset.add(2);
        mset.add(2);
        mset.add(2);
        mset.add(2);
        mset.add(3);
        mset.add(3);

        System.out.println(MultisetUtils.min(mset));
        System.out.println(MultisetUtils.minWeighted(mset));
        System.out.println(MultisetUtils.sum(mset));
        System.out.println(MultisetUtils.sumWeighted(mset));
        System.out.println(MultisetUtils.toList(mset));
    }

    public int count(E element){
        if(elements.get(element) != null){
            return elements.get(element);
        }
        return 0;
    }
    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(elements.get(o) != null){
            return true;
        }
        return false;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return elements.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(!elements.containsKey(e)){
            elements.put(e, 0);
        }
        elements.put(e, elements.get(e)+1);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(java.util.Collection<?> c) {
        return false;
    }


    @Override
    public boolean addAll(java.util.Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}