package cse360assign2;
// Eric Munoz
// ID: 1215668155
// Assignment 1
//Description: this program will create an array called list and either add, remove, keep count of its elements along witha  search of the elements at its
// ith position 

import java.util.Arrays; 

public class SimpleList {
	//initialize variables
	private int list[];
	private int count; 
	
	public SimpleList(){
		count = 0;
		list = new int[10];
	}
	
	//function to add elements in the array
	public void add(int number){
		if (count == 0) {
			list[count] = number;
			count++;
		}
		else if (count < list.length){
			list[count] = number;
			count++;
		}
		else {
			//list[count -1] = 0;
			int[] tempArray = new int[(int) ((list.length*(.5))+list.length)];
			//must shift the array to have numbers fall off
			for(int index = 0; index < count; index++){
				//list[index+1] = list[index];
				tempArray[index]= list[index];
			}
			list = tempArray;
			list[count] = number;
			count++;
			//System.out.println(list.length);
		}
	}
	
	//function to remove elements from the array
	public void remove(int number){
		//the loop will iterate through the primary array and copying its contents to a temporary array.
		// Once the element is found to be removed, the temp array will not have the element
		for (int index =0; index < count; index++)
			if (list[index] == number){
				int[] tempArray = new int[10];
				for (int i= 0, k = 0; i < list.length;i++){
					if (i == index){
						continue;
					}
					tempArray[k++]= list[i]; 
					//list = anotherArray;
					
				}
				//copy over the new array from tempArray to the main array "list" 
				list = tempArray;
				count--;
			}
		//equation to get the percentage of emtpy slots in the list
			float totalSlots = (float) ((float)list.length - 1.00);
			float emptySlots = totalSlots/(float)count;
			float spacesEmpty  = (emptySlots/(float)count);
				
			//System.out.println("Spaces Empty: " +spacesEmpty);
			if(spacesEmpty > .25){
				int[] tempArray2 = new int[count];
				for(int index = 0; index < count; index++){
					tempArray2[index]= list[index];
				}
				list = tempArray2;
			}
		     
	   }
	
	//return the count of the array
	public int count(){
		return count;
	}
	
	//searches for an element the user chose, and will give the element integer position in the array
	public int search(int number){
		int location = -1; 
		 boolean test = false; 
		 //iterating through the array and finind number chosen 
	        for (int element = 0; element < count; element++) {
	            if (list[element] == number) { 
	            
	            	location = element;
	            	test = true;
	            } 
	           
	        
	        //if the test boolean is true, the value in location will remain the same
	   if (test = false){
		   location = -1;}
	}
			return location;
}
	
	//returning the array in a string
	@Override
	   public String toString() {
	       String temp = "";
	       for (int i = 0; i < count; i++) {
	           temp += list[i];
	           if (i != count - 1) {
	               temp += ", ";
	           }
	       }
	       return temp;
	   }

	
	     


	
	
}


