package Scrapper;
import java.util.*;
public class temp {

	public static void main(String[] args) {
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(4);
		temp.add(5);
		int curr = 10;
		for(int i=0;i<temp.size();i++) {
			System.out.println(temp.size());
			System.out.println(temp.get(i) + " " + curr);
			System.out.println();
			temp.add(curr);
			curr+=1;
			if(curr==20) {
				break;
			}
					
		}
	}

}
