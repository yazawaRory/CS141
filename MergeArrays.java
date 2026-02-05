package HW1;

public class MergeArrays {
	public static int[] merge(int[] a,int[] b) {
		int i=0,j=0,k=0;
		int[] newArray = new int[a.length + b.length];
		while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
            	newArray[k++] = a[i++];
            } else {
            	newArray[k++] = b[j++];
            }
        }
		while (i < a.length) {
			newArray[k++] = a[i++];
        }

        while (j < b.length) {
        	newArray[k++] = b[j++];
        }
        return newArray;
	}
}
