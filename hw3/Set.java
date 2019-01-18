/*
 * Student First Name: Mohao
 * Student Last Name: Yi
 * Student BU Number: U35238289
 * Email: mohaoyi@bu.edu
 * Purpose: This class works as a blueprint for the algebra structure
 *          of set, and defines the necessary fields and methods for it
 */

package hw3;

public class Set  {
    
    private int SIZE = 20;  // length of the array
    
    private int[] S;              // array holding the set
    
    private int next;             // pointer to next available slot in array
    
    // Default constructor
    // constructs this set as an instance of the empty set
    public Set() {
        this.S = new int[SIZE];
        this.next = 0;
    }
    
    // constructs this set consisting of exactly the elements of A
    public Set(int[] A) {
    	
        this.S = new int[SIZE];
        this.next = 0;
        
        for (int i = 0; i < A.length; i++) {
        	this.insert(A[i]);
        }
        
    }
    
    // returns an exact copy of this set
    public Set clone() {
        Set copySet = new Set(this.S);
        copySet.next = this.next;
        return copySet;
    }
    
    // This method reallocates the array S to twice as big and copies all the elements over.
    // It is called only by insert. 
    private void resize() {
        int[] T = new int[SIZE * 2];
        for(int i = 0; i < S.length; ++i) {
            T[i] = S[i];
        }
        SIZE = SIZE * 2;
        S = T;
    }
    
    // returns a string representation of this set
    public String toString()  {
        String stringRepr = "[";
        
        for (int i = 0; i < this.size() - 1; i++) {
        	stringRepr += (this.S[i] + ",");
        }
        
        if (this.isEmpty()) {
        	stringRepr += "]";
        } else {
        	stringRepr += (this.S[this.size() - 1]) + "]";
        }
        
        return stringRepr;
    } 
    
    // returns the number of elements in this set
    public int size() {
        return this.next;
    }
    
    // returns true if this is the empty set, and false otherwise
    public boolean isEmpty() {
        return (this.next == 0);
    }
    
    // returns true if k is in this set, and false otherwise
    public boolean member(int k) {
    	
        for (int i = 0; i < this.size(); i++) {
        	if (this.S[i] == k) {
        		return true;
        	}
        }
        return false;
        
    }    
    
    // returns true if this set is a subset of T, and false otherwise
    public boolean subset(Set T) {
    	
        for (int i = 0; i < this.size(); i++) {
        	if (! T.member(this.S[i])) {
        		return false;
        	}
        }
        return true;
        
    }
    
    // returns true is this set and T have exactly 
    // the same members, and false otherwise
    public boolean equal(Set T) {
        return (this.subset(T) && T.subset(this));
    }
    
    // updates this set as if we are trying to add k to it
    public void insert(int k) {
    	
    	if (! this.member(k)) {
    		// increases the length of this set as needed
    		if (this.size() == this.SIZE) {
    			this.resize();
    		}
    		this.S[this.next] = k;
    		this.next++;
    	}
        
    }
    
    // updates this set as if we are trying to delete k from it
    public void delete(int k) {
    	
        // the index of k in this set, initialized with 0
    	int kIndex = 0;
        
    	if (this.member(k)) {
    		
    		// find the index of k in this set
    		for (int i = 0; i < this.size(); i++) {
    			if (this.S[i] == k) {
    				kIndex = i;
    				break;
    			}
    		}
    		
    		// delete k and left shift the elements after k by one slot
    		for (int i = kIndex; i < this.size() - 1; i++) {
    			this.S[i] = this.S[i+1];
    		}
    		
    		// update this.next to specify where is the end of this set
    		this.next--;
    		
    	}
    }
    
    // returns a new set which is (this set U T)
    public Set union(Set T) {
    	
        Set union = this.clone();
        
        for (int i = 0; i < T.size(); i++) {
        	union.insert(T.S[i]);
        }
        
        return union;
    }
    
    // returns a new set which is (this set กษ T)
    public Set intersection(Set T) {
    	
    	Set intersection = new Set();
    	
    	for (int i = 0; i < this.size(); i++) {
    		
    		if (T.member(this.S[i])) {
    			intersection.insert(this.S[i]);
    		}
    		
    	}
        
        return intersection;
    }
    
    // returns a new set which is (this set - T)
    public Set setdifference(Set T) {
        
    	Set setDifference = new Set();
        
    	for (int i = 0; i < this.size(); i++) {
    		
    		if (! T.member(this.S[i])) {
    			setDifference.insert(this.S[i]);
    		}
    		
    	}
    	
        return setDifference;
    }
      
}
