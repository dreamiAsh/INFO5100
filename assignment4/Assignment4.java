import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment4 {
	public static void main(String[] args) {
//		System.out.println(ques1("ssffddr"));
//		System.out.println(ques2(481));
//		System.out.println(Arrays.toString(ques3(0,1,0,3,12)));
//		System.out.println(ques4("babad"));
		int[][] matrix = {
							{1,2,3,4},
							{4,5,6,5},
							{7,8,9,0},
							{2,3,4,5}
						};
		ques5(matrix);
	}
	
	//(1)Check the index of the first non-repeating character
	public static int ques1(String s) {
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length; i++) {
			if(i<arr.length-1 && arr[i] != arr[i+1]) {
				return i;
			}else if(i==arr.length-1){
				return i;
			}else {
				i++;
			}	
		}
		return -1;
	}
	
	//(2)Add digits to only one digit
	public static int ques2(int num) {
		String str = String.valueOf(num);
		char[] arr = str.toCharArray();
		int res = 0;
		for(char c : arr) {
			String a = String.valueOf(c);
			res += Integer.parseInt(a);
		}
		if(res > 10) return ques2(res);
		else return res;
		
	}
	
	//(3)move 0
	public static int[] ques3(int ... nums) {
		int[] arr = new int[nums.length];
		int j = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				arr[j] = nums[i];
				j++;
			}
		}
		return arr;
	}
	
	//(4)longest palindromic substring
	public static String ques4(String s) {
		char[] arr = s.toCharArray();
		List<Character> list = new ArrayList<>();
		if(arr.length>2) {
			for(int i=0; i<arr.length; i++) {
				if(i>1 && arr[i]==arr[i-2] && list.isEmpty()) {
					list.add(arr[i-2]);
					list.add(arr[i-1]);
					list.add(arr[i]);
				}else if(i>1 && arr[i]==arr[i-2]) 
					list.add(arr[i]);
			}
			if(list.get(0) != list.get(list.size()-1)) 
				list.remove(list.size()-1);
			String res = ""; 
			for(Character i: list) res += i;
			return res;
		}else return "";
	}
	
	
	//(5)Rotate image
	public static int[][] ques5(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
			for(int j=0; j<matrix[0].length; j++) {
				res[j][matrix[0].length-i-1] = matrix[i][j];
			}
		}
		System.out.println("------------");
		for(int k=0; k<res.length; k++) {
			System.out.println(Arrays.toString(res[k]));
		}
		return res;
	}
	
}




