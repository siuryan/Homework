// Ryan Siu
// APCS1 pd5
// HW55 -- His Toe Grammar
// 2017-01-05

/***
    An AP-style question, for practice...

    Write the StatPrinter class below. The StatPrinter Object receives an
    ArrayList of nonnegative integers, then builds a frequency ArrayList where
    the index values are the data and the entry at the index is the frequency.
    For example, if the received data is : 2,3,2,5,1,3 then the frequency 
    list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
    2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
    the maximum value of the data.

    A capability of the class is to calculate local modes from the frequency 
    list. A local mode is a value that is greater than the value at index - 1 
    and greater than the value at index + 1. A local mode is never at the end
    points of the list. For example if the frequency list is [1,2,1,4,2,3,5] 
    then the local modes are: 2 and 4.



    This class is also capable of printing a histogram of the frequencies, using
    ‘*’ to indicate a frequency amount. To print a histogram, the user specifies
    the longest sequence of ‘*’s used and then all other values are printed in 
    proportion to this value. For example, if longest bar is 10 and the frequency
    list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

    0 : **
    1 : ****
    2 : **
    3 : ********
    4 : ****
    5 : ******
    6 : **********

    For each method, state the run time efficiencies using Big O notation.
    =======================================
    Tip:
    * Develop 1 fxn at a time, test it, then move to next.
    * Look over all, think a bit, decide which to tackle first.
    ( Simplest?  Prerequisite? . . . )
    * Coding today, what extra code do you need to get past Mr. Compiler?
    ***/

import java.util.ArrayList;

public class StatPrinter 
{

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data ) 
    {
	
	_frequency = new ArrayList<Integer>();
	Integer maxVal = max(data);
	
	for (int i = 0; i <= maxVal; i++) {
	    _frequency.add(0);
	}
	
        for (Integer i : data) {
	    _frequency.set(i, _frequency.get(i) + 1);
	}
    } // O(n)


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) 
    { 
        Integer king = data.get(0);
	for (Integer i : data) {
	    if (i > king) {
		king = i;
	    }
	}
	return king;
    } // O(n)


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) 
    { 
	return i > 0
	    && i < _frequency.size() - 1
	    &&  _frequency.get( i - 1 ) < _frequency.get( i ) 
	    &&  _frequency.get( i + 1 ) < _frequency.get( i );
    } // O(1)


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList <Integer> getLocalModes() 
    {
	
	ArrayList<Integer> modes = new ArrayList<Integer>();
	for (int i = 1; i < _frequency.size(); i++) {
	    if (isLocalMode(i)) {
		modes.add(i); // amortized O(1)
	    }
	}
	return modes;
    } // O(n)


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) 
    { 
	Integer maxVal = max(_frequency);
	int factor = longestBar / maxVal;
	
	String h = "";
	for (int i = 0; i < _frequency.size(); i++) {
	    h += "\n" + i + " : ";
	    for (int j = 0; j < _frequency.get(i) * factor; j++) {
		h += "*";
	    } // O(1)
	} // O(n)
	System.out.println(h);
    } // O(n)

    // testing
    public static void main( String[] args ) {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	arr.add(1);
	arr.add(2);
	arr.add(1);
	arr.add(4);
	arr.add(2);
	arr.add(3);
	arr.add(5);
	arr.add(0);
	arr.add(2);
	arr.add(4);
	System.out.println( arr );
	StatPrinter s = new StatPrinter( arr );
	System.out.println( s._frequency );
	System.out.println( s.getLocalModes() );
	s.printHistogram(12);
    }

 
}//end class StatPrinter
