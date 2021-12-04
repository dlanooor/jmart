package com.ronaldJmartBO;

import java.util.Iterator;
import java.util.Vector;
import java.util.function.Function;

/**
 * Represent Object Pool Thread
 *
 * @param <T> the type parameter
 * @author Ronald Grant
 * @version 2.0
 * @since 3 November 2021
 */
public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal;
    private Vector<T> objectPool;
    private Function<T, Boolean> routine;

    /**
     * Instantiates a new Object pool thread.
     *
     * @param name    the name
     * @param routine the routine
     */
    public ObjectPoolThread(String name, Function<T, Boolean> routine) {
        super(name);
        this.routine = routine;
        objectPool = new Vector<T>();
    }

    /**
     * Instantiates a new Object pool thread.
     *
     * @param routine the routine
     */
    public ObjectPoolThread(Function<T, Boolean> routine) {
        super();
        this.routine = routine;
    }

    /**
     * Add.
     *
     * @param object the object
     */
    public void add(T object) {
        synchronized(this) {
            objectPool.add(object);
        }
    }

    /**
     * Exit.
     */
    @SuppressWarnings("deprecation")
    public void exit() {
        synchronized(this) {
            exitSignal = true;
            this.interrupt();
        }
    }

    public void run() {
        synchronized (this) {
            Iterator<T> iterator = objectPool.iterator();

            while(!exitSignal) {
                while(iterator.hasNext()) {
                    T element = iterator.next();
                    if(routine.apply(element))
                        iterator.remove();
                }
                try {
                    this.wait();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return objectPool.size();
    }
}