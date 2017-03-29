import java.util.*;

public final class RandIndexQueue<T> implements MyQ<T>, Indexable<T>, Shufflable {
  // Instance Variables
  private final T[] arrQ;
  private int numOfEntries;

  // toString() method used to get String value of Object
  public String toString() {
    String returnVal = " ";
    System.out.print("Contents:");
    for (int i = 0; i < numOfEntries; i++) {
      returnVal += arrQ[i].toString() + " ";
    }
    return returnVal;
  } // end toString()

  // Creates an empty array and sizes it from the passed in size
  // Casts the "generic" Object
  public RandIndexQueue(int size) {
    @SuppressWarnings("unchecked")
    T[] TEMParrQ = (T[]) new Object[size]; // unchecked cast
    arrQ = TEMParrQ;
  } // end constructor

  /*************************************MYQ************************************/

  // Adds item to available location in array and increments the number of
  // entries
  public boolean addItem(T item) {
    if (this.full()) {
      return false;
    } else {
      for (int i = 0; i < arrQ.length; i++) {
        // adds item if next available location is null
        if (arrQ[i] == null) {
          arrQ[i] = item;
          break;
        }
      }
      numOfEntries++;
      return true;
    }
  } // end addItem(T)

  // removes item, shifts all elements up a space and decrements when removed
  public T removeItem() {
    if (this.empty()) {
      return null;
    } else {
      // sets removed item to a temp variable
      T item = arrQ[0];
      for(int i = 0; i < arrQ.length - 1; i++) {
        // makes index that last element was in to null
        if (i >= numOfEntries - 1) {
          arrQ[i] = null;
        } else {
          arrQ[i] = arrQ[i + 1];
        }
      } // end for
      numOfEntries--;
      return item;
    }
  } // end removeItem()

  // checks if array is full
  public boolean full() {
    if (numOfEntries < arrQ.length){
      return false;
    } else {
      return true;
    }
  } // end full()

  // checks if array is false
  public boolean empty() {
    if (arrQ[0] == null) {
      return true;
    } else {
      return false;
    }
  } // end empty();

  // returns current size of array
  public int size() {
    return numOfEntries;
  } // end size()

  // clears entire array
  public void clear() {
    for (int i = 0; i < arrQ.length; i++) {
      arrQ[i] = null;
    } // end for
    numOfEntries = 0;
  } // end clear()

/**********************************INDEXABLE***********************************/

  // gets data from specific index and throws an IndexOutOfBoundsException
  public T get(int i) {
    int temp = 0;
    // throws IndexOutOfBoundsException if the number of entries is less than
    // i+1
    if (numOfEntries < (i+1)) {
      throw new IndexOutOfBoundsException("Error");
    } // end if

    // finds index that is passed in and returns its value
    for (int m = 0; m < arrQ.length; m++) {
      if (i == m) {
        temp = m;
        break;
      }
    }
    return arrQ[temp];
  } // end get(int)

  // handles IndexOutOfBoundsException and sets desired index to specific item
  public void set(int i, T item) {
    // throws IndexOutOfBoundsException if the number of entries is less than
    // i+1
    if (numOfEntries < (i+1)) {
      throw new IndexOutOfBoundsException("Error");
    } // end if

    // sets item at specific index of the array
    for (int m = 0; m < arrQ.length; m++) {
      if (i == m) {
        arrQ[m] = item;
      }
    }
  } // end void set(int, T))

/**********************************SHUFFLABLE**********************************/
  // randomly shuffles Objects
  public void shuffle() {
    // Creates a random object
    Random rnd = new Random();
    // swaps variables to random indices
    for (int i = numOfEntries - 1; i > 0; i--) {
      int r = (int)(rnd.nextInt(i + 1));
	    T t = arrQ[i];
	    arrQ[i] = arrQ[r];
	    arrQ[r] = t;
    } // end for
  } // end shuffle()


} // end final class ... MyQ, Indexable, Shufflable
