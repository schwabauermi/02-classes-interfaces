package de.thro.inf.prg3.a02;
import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

	// TODO: Implement the required methods.

    private Element head;
    private int size;

    public int size(){
        return size;
    }

    public SimpleListImpl(){
        head = null;
    }

    public Iterator iterator(){
        return new SimpleIteratorImpl();
    }

    public void add(Object item){
        if(head == null){
            head = new Element(item);
        }
        else{
            Element current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Element(item);
        }
        size++;
    }

    private static class Element{
        private Object item;
        private Element next;

        Element(Object item){
            this.item = item;
            this.next = null;
        }
    }

    public class SimpleIteratorImpl implements Iterator<Object>{
        private Element current = head;

        public boolean hasNext(){
            return current != null;
        }

        public Object next(){
            Object tmp = current.item;
            current = current.next;
            return tmp;
        }
    }

    public SimpleList filter(SimpleFilter filter){
        SimpleList result = new SimpleListImpl();
        for(Object o : this){
            if(filter.include(o)){
                result.add(o);
            }
        }
        return result;
    }
}