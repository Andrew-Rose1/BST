import java.util.*;

// I apolgize for this class being so messy. I know I could have optimized this
// code much better, but my time management for this lab was not the best.
// I assure you I will be condensing this code down after it is submited for my own
// personal keepings.

// A lot of the extra code is just test prints that I commented out.

public class BSTApp{

  public static ArrayList<Integer> data = new ArrayList<Integer>(0);

  public static void main(String[] args) {
    int size = 10;
    BST obj4 = new BST();
    int[] randomArr = new int[size];
    for (int i = 0; i < size; i++) {
			int tryVal = (int)(Math.random()*1000);
			while (!checkArr(randomArr, tryVal)) {
				tryVal = (int)(Math.random()*1000);
			}
			randomArr[i] = tryVal;
    }
    for (int i = 0; i < randomArr.length; i++) {
				obj4.insert(randomArr[i]);
				System.out.println("Insert " + randomArr[i]);
		}
    System.out.println("The minimum absolute difference is: " + minDiff(obj4.returnRoot()));
  }

  public static int minDiff(Node root) {
    inOrderTraversal(root);
    System.out.println("The transverse gives a BST as " + data);
    int [] intArray = new int[data.size()-1];
    int minimumDiff = 0;
    for (int i = 0; i < data.size()-1; i++) {
      minimumDiff = data.get(i+1) - data.get(i);
      intArray[i] = minimumDiff;
       System.out.println("Diff of index " + data.get(i) + " and " + data.get(i+1) + " is " + minimumDiff);
    }
    //TESTING// Print out the array holding all of the differences.
    for (int j = 0; j < intArray.length; j++) {
      System.out.println(intArray[j]);
    }

    // Set minimum difference to the first difference value, and compare all differences
    minimumDiff = intArray[0];
    for (int m = 1; m < intArray.length; m++) {
      // If the index we are checking has a value smaller than the saved minimumDiff, then assign it to minimumDiff
      if (minimumDiff > intArray[m]) {
          System.out.println("Spot " + m + " is a smaller diff than " + minimumDiff);
        minimumDiff = intArray[m];
      }
       System.out.println("Current minDiff is " + minimumDiff);
    }
    return minimumDiff;
  }

  private static void inOrderTraversal(Node node) {
      if (node != null) {
          inOrderTraversal(node.left);
          data.add(node.key);
          inOrderTraversal(node.right);
      }
  }


  public static boolean checkArr(int [] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return false;
			}
		}
		return true;
	}
}
