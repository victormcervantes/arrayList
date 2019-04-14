package collections.list;

public class ArrayList implements List
{
   private int[] data;
   private static int curIdx;

   public ArrayList()
   {
      System.out.print( "Original value of data: ");
      System.out.println(data);
      data = new int[10];
      System.out.print( "New value of data: ");
      System.out.println(data);
   }
   public ArrayList(int[] arr) //Unnecessary constructor
   {
      data = arr;
      curIdx = data.length;
      this.resizeArray();
   }
   public void resizeArray()
   {
      if (curIdx >= data.length)
      {
         int [] temp = new int[data.length * 2];
         for(int i = 0; i < curIdx; i++)
         {
            temp[i] = data[i];
         }
         data = temp;
      }
      else if(curIdx <= (data.length / 3))
      {
         int [] temp = new int[data.length/2];
         for(int i = 0; i < curIdx; i++)
         {
            temp[i] = data[i];
         }
         data = temp;
      }
   }
   public int size()
   {
      return curIdx;
   }   
   public void clear()
   {
      data = new int[10];
      curIdx = 0;
   }
   public boolean isFull()
   {
      return false;
   }
   public boolean isEmpty()
   {
      if(curIdx == 0)
         return true;
      else
         return false;
   }
   public void set(int idx, int val)
   {
      if(idx < data.length)
         data[idx] = val;
      else
         throw new IndexOutOfBoundsException("Index " + idx + " is not in range"); 
   }
   public int get(int idx)
   {
      if(idx >= curIdx)
         throw new IndexOutOfBoundsException("Index " + idx + " is not in range");
      return data[idx];
   }
   public int lastIndexOf(int val)
   {
      for(int i = curIdx - 1 ; i >= 0; i--)
      {
         if(data[i] == val)
            return i;
      }
      return -1;
   }
   public int indexOf(int val)
   {
      for(int i = 0; i < curIdx; i++)
      {
         if(data[i] == val)
            return i;
      }
      return -1;
   }
   public boolean contains(int val)
   {  
      if(indexOf(val) != -1)
         return true;
      else
         return false;
   }
   public int remove(int idx)
   {
      if(idx > curIdx)
         throw new IndexOutOfBoundsException("Index " + idx + " is not in range");
      int removed = data[idx];
      for(int i = idx; i < curIdx; i++)
      {
         data[i] = data[i+1];   
      }
      curIdx--;
      this.resizeArray();
      return removed;
   }
   public int remove()
   {
      int ret = data[curIdx - 1];
      curIdx--;
      this.resizeArray();
      return ret;
   }
   public void add(int idx, int val)
   {
      if(idx > curIdx)
         throw new IndexOutOfBoundsException("Index " + idx + " is not in range");
      for(int i = curIdx; i > idx; i--)
      {
         data[i] = data[i-1];   
      }
      data[idx] = val;
      curIdx++;
      this.resizeArray();
   }  
   public void add(int val)
   {
      data[curIdx] = val;
      curIdx++;
      this.resizeArray();
   }
   public String toString()
   {
      String ret = "[ ";
      for(int i = 0; i < curIdx; i++)
      {
         ret = ret + data[i] + " ";
      }
      ret = ret + "]";
      return ret;
   }
}