import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class task2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub "C:\Users\nikdo\eclipse-workspace\task2\src\file1.txt"
		BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
		String line;
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		while ((line = reader1.readLine()) != null) {
			String[] numbers = line.split("\\s+");
            
            for (int i = 0; i < numbers.length; i++) {
                arrayList.add(Integer.parseInt(numbers[i]));
            }
		}
		reader1.close();
		BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));
		String line2;
		while ((line2 = reader2.readLine()) != null) {
			String[] numbers2 = line2.split("\\s+");
            
            for (int i = 0; i < numbers2.length; i++) {
            	arrayList2.add(Integer.parseInt(numbers2[i]));
            }
		}
		reader2.close();

		int x0 = arrayList.get(0);
		int y0 = arrayList.get(1);
		int radius = arrayList.get(2);
		for(int i = 0; i<arrayList2.size(); i = i+2) {
			int x = arrayList2.get(i);
			int y = arrayList2.get(i+1);
			if(Math.pow(x-x0, 2)+Math.pow(y-y0, 2)<Math.pow(radius, 2)) {
				System.out.println(1);
			} else if(Math.pow(x-x0, 2)+Math.pow(y-y0, 2)==Math.pow(radius, 2)) {
				System.out.println(0);
			} else {
				System.out.println(2);
			}
		}
	}

}
