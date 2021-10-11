package ronaldJmartBO;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.*;

public class Algorithm {
    private Algorithm() {
    }

    /* collect method */
    public static <T> List<T> collect(T[] array, T value) {
        List<T> list = Arrays.asList(array);
        list.add(value);
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        List<T> list = new ArrayList<T>();
        for (T item : iterable) {
            list.add(item);
        }

        list.add(value);

        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        Iterator<T> source = iterator;
        List<T> target = new ArrayList<>();
        source.forEachRemaining(target::add);
        target.add(value);

        return target;
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = Arrays.asList(array);

        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        for (T item : iterable) {
            list.add(item);
        }

        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        Iterator<T> source = iterator;
        List<T> target = new ArrayList<>();
        source.forEachRemaining(target::add);

        return target;
    }

    /* count method */
    public static<T> int count(T[] array, T value) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return count(iter, value);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator <T> iter = iterable.iterator();
        return count(iter, value);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate <T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return count(iter, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> iter = iterable.iterator();
        return count(iter, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        return count(iterator, pred);
    }

    /* exists method */
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return exists(iter, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator <T> iter = iterable.iterator();
        return exists(iter, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate <T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return exists(iter, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> iter = iterable.iterator();
        return exists(iter, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        return exists(iterator, pred);
    }

    /* find method */
    public static <T> T find(T[] array, T value) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return find(iter, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator <T> iter = iterable.iterator();
        return find(iter, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate <T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> iter = Arrays.stream(array).iterator();
        return find(iter, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> a = iterable.iterator();
        return find(a, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        return find(iterator, pred);
    }

    /* max method */
    public static <T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        else
            return second;
    }

    public static <T extends Comparable<? super T>> T max(T[] array) {
        T temp = null;

        for(int i = 0; i < array.length; i++) {
            if(array[i].compareTo(array[i+1]) > 0)
                temp = array[i];
            else
                temp = array[i+1];
        }

        return temp;
    }

    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) {
        final Iterator <T> iterator = iterable.iterator();

        T max = null;
        T temp = null;

        while(iterator.hasNext()) {
            if(max == null) {
                max = iterator.next();
            }
            else {
                temp = iterator.next();
                if(temp.compareTo(max) > 0) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) {
        T max = null;
        T temp = null;

        while(iterator.hasNext()) {
            if(max == null) {
                max = iterator.next();
            }
            else {
                temp = iterator.next();
                if(temp.compareTo(max) > 0) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
        T[] array;
        array = (T[]) new Comparable[]{first, second};
        return Collections.max(Arrays.asList(array), comparator);
    }

    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {
        return Collections.max(Arrays.asList(array), comparator);
    }

    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
//        return (T) Collections.max(iterable, comparator);
        return null;
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
//        return (T) Collections.max(iterator, comparator);
        return null;
    }

    /* min method */
    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        else
            return second;
    }

    public static <T extends Comparable<? super T>> T min(T[] array) {
        T temp = null;

        for(int i = 0; i < array.length; i++) {
            if(array[i].compareTo(array[i+1]) < 0)
            temp = array[i];
            else
            temp = array[i+1];
        }

        return temp;
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable) {
        final Iterator <T> iterator = iterable.iterator();

        T min = null;
        T temp = null;

        while(iterator.hasNext()) {
            if(min == null) {
                min = iterator.next();
            }
            else {
                temp = iterator.next();
                if(temp.compareTo(min) < 0) {
                    min = temp;
                }
            }
        }

        return min;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator) {
        T min = null;
        T temp = null;

        while(iterator.hasNext()) {
            if(min == null) {
                min = iterator.next();
            }
            else {
                temp = iterator.next();
                if(temp.compareTo(min) < 0) {
                    min = temp;
                }
            }
        }

        return min;
    }

    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
        T[] array;
        array = (T[]) new Comparable[]{first, second};
        return Collections.min(Arrays.asList(array), comparator);
    }

    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator) {
        return Collections.min(Arrays.asList(array), comparator);
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        return null;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        return null;
    }

//    public static <T extends Comparable<? super T>> T max(T first, T second) {
//        if(first.compareTo(second) > 0)
//            return first;
//        else
//            return second;
//    }

//    public static <T extends Comparable<? super T>> T min(T first, T second) {
//        if(first.compareTo(second) < 0)
//            return first;
//        else
//            return second;
//    }
}