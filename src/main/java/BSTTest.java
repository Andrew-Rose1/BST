import java.util.*;

public class BSTTest{
	public static void main(String[] args) {
		// perform at least one test on each operation of your BST
		//test("insert", randomArray(10))
		BSTTest obj = new BSTTest();
		obj.test(randomArray(100), 25);
		obj.test(randomArray(150), 50);
	}

	// create a unqiue random list of integers form 0-1000.
	public static int[] randomArray(int size) {
		int[] randomArr = new int[size];
		for (int i = 0; i < size; i++) {
			int tryVal = (int)(Math.random()*1000);
			while (!checkArr(randomArr, tryVal)) {
				tryVal = (int)(Math.random()*1000);
			}
			randomArr[i] = tryVal;
		}
		return randomArr;
	}

	// randomArray Helper method: Checks whether an integer is in an array list
	public static boolean checkArr(int [] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return false;
			}
		}
		return true;
	}

	// takes in to parameters. an array of integers and an integer value. The integer value determines the
	// quantity of integer values to be removed from arr array,
	public void test(int[] arr, int deleteVal) {
		BST obj2 = new BST();
		System.out.println("Testing of BST starts.");
		for (int i = 0; i < arr.length; i++) {
				obj2.insert(arr[i]);
				System.out.println("Insert " + arr[i]);
		}
		// use deleteVal to delete a set amount of random integers from 0-1000
		for (int j = 0; j < deleteVal; j++) {
			int delVal = (int)(Math.random()*1000);
			System.out.print("Delete  " + delVal + ". ");
			obj2.delete(delVal);
			System.out.println("");
		}
		// Sort the BST and output the result
		obj2.inOrderTraversal();
		System.out.println("The transverse give a BST as " + obj2.getData());
		System.out.println("Testing of BST ends");

	}



}
