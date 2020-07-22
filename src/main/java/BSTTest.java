import java.util.*;

public class BSTTest{
	public static void main(String[] args) {
		// perform at least one test on each operation of your BST
		//test("insert", randomArray(10))
		BSTTest obj = new BSTTest();
		obj.test(randomArray(10), 3);
		obj.test(randomArray(20), 12);
	}

	public static int[] randomArray(int size) {
		int[] randomArr = new int[size];
		for (int i = 0; i < size; i++) {
			randomArr[i] = (int)(Math.random()*100);
		}
		return randomArr;
	}

	// the parameters and return are up to you to define; this method needs to be uncommented
	public void test(int[] arr, int deleteVal) {
		BST obj2 = new BST();
		System.out.println("Testing of BST starts.");
		for (int i = 0; i < arr.length; i++) {
				obj2.insert(arr[i]);
				System.out.println("Insert " + arr[i]);
		}
		//obj2.inOrderTraversal();
		//System.out.println("The transverse give a BST as " + obj2.getData());
		obj2.delete(deleteVal);
		System.out.println("Delete " + deleteVal);
		obj2.inOrderTraversal();
		System.out.println("The transverse give a BST as " + obj2.getData());
		System.out.println("Testing of BST ends");

	}



}
