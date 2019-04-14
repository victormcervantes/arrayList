package collections.list;

public interface List
{
   void add(int val);
   
   void add(int idx, int val) throws IndexOutOfBoundsException;
   
   int remove(int idx) throws IndexOutOfBoundsException;
   
   boolean contains(int val);
   
   int indexOf(int val);
   
   int lastIndexOf(int val);
   
   int get(int idx) throws IndexOutOfBoundsException;
   
   void set(int idx, int val) throws IndexOutOfBoundsException;
   
   boolean isEmpty();
   
   boolean isFull();
   
   String toString();
   
   void clear();
   
   int size();
}