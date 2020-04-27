/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

/**
 *
 * @author bilka
 */
import MyUtils.Utils;

/**
 *
 * @author jde, Dec 2015, Original coding
 *
*/

public class ADTLinkedList extends ADTList{

// if we restrict the add and remove to the head of the list then we have a stack

    public int length() {
        return noOfItems;
    }

    public void createList( ) {
        noOfItems = 0;
    }

    
    public void printList( ) {
        for ( int index = 0; index < noOfItems; index++ )
            System.out.println( String.format( "%4d => %s", index, raList[ index ] ) );
        System.out.println( String.format( "No. of list items:%4d", noOfItems ) );
    }

    // insert(s) is always insertFirst(s)/addFirst(s) in this implementation
    public boolean insert( String s ) {
        return addFirst( s );
    }

    public String remove( String s ) {
        String removedString = "Error Not Found: " + s;
        int position = findString( s );
        if ( position == -1 ) {
            System.out.println( String.format( "Not found: %s", s ) );
        } else {
            removedString = raList[ position ];
            removeString( position );
        }
        return removedString;
    }

    public boolean find( String s ) {
        return ( findString( s ) != -1 );
//        return ( recursiveFind( s ) );
    }

    public void recursivePrintList( ) {
        write();
        System.out.println( String.format( "No. of recursive list items:%4d", noOfItems ) );
    }

    // internal private implementation details
    private final int MAXNOOFITEMS = 10;
    private final String[] raList = new String[MAXNOOFITEMS];
    private int noOfItems = 0;
    private final int nextFreePosition = 0;

    private boolean addFirst( String s ) {
        boolean ok = true;
        if ( ! isFull() ) {
            addItem( s );
        } else {
            System.out.println( String.format( "Array full, unable to add: %s to List", s ) );
            ok = false;
        }
        return ok;
    }

    private boolean isEmpty( ) {
        return (noOfItems == 0);
    }

    private boolean isFull( ) {
        return (noOfItems == raList.length);
    }

    private void addItem( String s ) {
        for ( int index = noOfItems; index > 0; index-- )
            raList[ index ] = raList[ index -1];
        raList[ nextFreePosition ] = s;
        noOfItems ++;
    }

    private int findString( String s ) {
        int position = 0, foundAt = -1; boolean stillLooking = ! isEmpty();
        while ( stillLooking ) {
            if ( raList[ position ].equals( s ) ) {
                foundAt = position;
                stillLooking = false;
            } else {
                position ++; // get ready to check next position
                stillLooking = ( position < noOfItems );
            }
        }
        return foundAt;
    }

    public void removeString( int pos ) {
        for ( int index = pos +1; index < noOfItems; index++ )
            raList[ index -1 ] = raList[ index ];
        noOfItems --;
    }

    private void write() { // Outputs the elements in a list from beginning to end.
        System.out.print("List : ");
        writeSub(0);
        System.out.println();
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private void writeSub(int index)  {
    // Recursive partner of the write( ) method. Processes the sublist
    // that begins with the node referenced by p.
        if (index < noOfItems) {
            System.out.println(getElement( index) + " " + index ); // Output element
            index = getNext(index);
            writeSub( index ); // Continue with next node
        }
    }

    private String getElement( int index ) {
        // return  element at position index
        if ( Utils.inRange( index, 0, noOfItems - 1 ) )
            return raList[ index ];
        else
            return "Element not found - out of range";
    }

    private int getNext( int index ) {
        //System.out.println("getNext index in:" + index );
        index = index + 1;  // dev index ++; doesn't work!
        //System.out.println("getNext index out:" + index );
        return index;
    }

    private boolean recursiveFind(String s) { // Outputs the elements in a list from beginning to end.
        System.out.print("List : ");
        boolean found = findSub(s, 0);
        System.out.println( found );
        return found;
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private boolean findSub(String searchString, int index)  {
    // Recursive partner of the write( ) method. Processes the sublist
    // that begins with the node referenced by p.
        String s; boolean found = false;
        if ( ( ! found ) && (index < noOfItems) ) {
            s = getElement( index );
            System.out.println("Checking: " + s + " " + index );
            if ( s.equals( searchString ) ) {
                System.out.println( "found it at index: " + index );
                found = true;
            } else {
                // keep searching
                index = getNext(index);
                findSub( searchString, index ); // Continue with next node
            }
        }
        System.out.println( "Not found it at index: " + index );
        return found;
    }
}