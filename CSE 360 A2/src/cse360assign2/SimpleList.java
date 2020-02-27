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
	
	//function to add elements to the beginning of the array
	public void add(int number){
		if (count == 0) {
			list[count] = number;
			count++;
		}
		
		else if (count < list.length){
			int[] tempArray = new int[10];
			for(int index = 0; index < count; index++){
				
				tempArray[index+1]= list[index];
			}
			
			list = tempArray;
			list[0] = number;
			
			count++;
		}
		//This will change the array size by 50% if the limit is reached 
		else {
			int[] tempArray = new int[(int) ((list.length*(.5))+list.length)];

			for(int index = 0; index < count; index++){
				tempArray[index+1]= list[index];
			}
			list = tempArray;
			list[0] = number;
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
		// will decrease the size of the array by 25%
		double totalSlots = (double)list.length-1;
		double emptySlots = totalSlots-(double)count;
		double spacesEmpty  = (emptySlots/(double)list.length)*100;
		
			//System.out.println("Spaces Empty: " +spacesEmpty);
			if(spacesEmpty > 25){
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
	//function will append each number to the end of the list
	public void append(int number){
		int[] tempArray = new int[(int) ((list.length*(.5))+list.length)];
		for(int index = 0; index < count; index++){
			//list[index+1] = list[index];
			tempArray[index]= list[index];
		}
		list = tempArray;
		list[count] = number;
		count++;
	}
	
	//function will print out the first element of the array
	public int first(){
		int notThere = -1;
		if(count==0){
			return notThere;
		}
		else{
			 return list[0];
		}
	}
	
	//function will print out the last element of the array
	public int last(){
		int notThere = -1;
		if(count==0){
			return notThere;
		}
		else{
			return list[count-1];
		}
	}
	
	//return the number of possible locations left in the list
	//essentially how many numbers left a person can  add in
	public int size(){
		int size = 10;
		if (count == 0){
			return size;
		}
		else{
			int totalSlots =  (list.length );
			int emptySlots = (totalSlots - count);
			System.out.println("emptys: "+emptySlots);
			return emptySlots;
		}
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


