import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub "C:\Users\nikdo\eclipse-workspace\task4\src\file.txt"
		BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
		String line;
		ArrayList<Integer> arrayList = new ArrayList<>();
		while ((line = reader1.readLine()) != null) {
			String[] numbers = line.split("\\s+");
            
            for (int i = 0; i < numbers.length; i++) {
                arrayList.add(Integer.parseInt(numbers[i]));
            }
		}
		reader1.close();
		long average = 0;
		if (arrayList.size() > 0)
		{
		    double sum = 0;
		    for (int i = 0; i < arrayList.size(); i++) {
		         sum += arrayList.get(i);
		    }
		    average = Math.round(sum / arrayList.size());
		}
		int chet = 0;
		while(true) {
			int flag = 0;
			for (int i = 0; i < arrayList.size(); i++) {
		         if(arrayList.get(i)<average) {
		        	 arrayList.set(i,arrayList.get(i)+1);
		        	 chet++;
		        	 flag++;
		         } else if(arrayList.get(i)>average) {
		        	 arrayList.set(i,arrayList.get(i)-1);
		        	 chet++;
		        	 flag++;
		         }
		    }
			if(flag==0) {
				break;
			}
		}
		System.out.println(chet);
	}

}
