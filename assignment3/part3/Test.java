import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Test{
	public static void main(String[] args){
		String a = new String("   The     sky is blue");
		System.out.println(reverse(a));
	}

	public static String reverse(String s){
		String[] arr1 = s.trim().split(" ");
		List<String> list = Arrays.asList(arr1);
		System.out.println(list.toString());
		Collections.reverse(list);
		// List<String> newList = new ArrayList<>();
		String res = "";
		for(String word : list){
			if(word.equals("")){
			}else{
				// newList.add(word);
				// System.out.println(word.toString());
				res += word + " ";
			}
			
		}
		// System.out.println(newList.toString());
		// String[] sarr = newList.toArray(new String[0]);
		// System.out.println(sarr.toString());    //why shows it is Object?
		return res;
	}
}