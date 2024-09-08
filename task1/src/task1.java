
public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nArg = args[0];
		String mArg = args[1];
		int n = Integer.parseInt(nArg.trim());
		int m = Integer.parseInt(mArg.trim());
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = i+1;
		}
		int temp = 0;
	    System.out.print("Путь: ");
	    do {
	        System.out.print(array[temp]);
	        temp = (temp + m - 1) % n;
	    } while (temp != 0);
	}

}
