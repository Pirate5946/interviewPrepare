package lintcode;

public class IntegerSorting {
    /*
     * @param A: an integer array
     * @return: 
     */
	public static void main(String[] args) {
		
		int[] A = {10,5,12,7,15,9,4,2};
		
		
		sortIntegers(A);
	}
	
    public static void sortIntegers(int[] A) {

    	int length = A.length - 1;
         
        int i = 0;
//         int j = i + 1;
        int temp = 0;
        
        for(;i < length;i++) {
        	System.out.print("{");
        	
            for(int j = i + 1;j < length + 1;j++) {
            	// 内层循环，通过 A.length-i-1 次比较，将较小的值 赋值给 A[i],较小值往前冒泡
                if(A[i] > A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
            
            for (int s = 0; s < A.length; s++) {
            	if (s == A.length - 1) {
            		System.out.print(A[s]);
            	}else{
            		System.out.print(A[s]+",");
            	}
            }
            
            System.out.println("}"+"  i==" + i +",进行了"+ (A.length-i-1) +"次判断");
        }
    }
    
    // 拼字符串方式不同
    public static void sortIntegers2(int[] A) {

    	int length = A.length - 1;
         
        int i = 0;
//         int j = i + 1;
        int temp = 0;
        
        for(;i < length;i++) {
        	
            for(int j = i + 1;j < length + 1;j++) {
            	// 内层循环，通过 A.length-i-1 次比较，将较小的值 赋值给 A[i],较小值往前冒泡
                if(A[i] > A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
            
            String[] str = new String[length + 1];
            
            for (int s = 0; s < A.length; s++) {
            	str[s] = String.valueOf(A[s]);
            }
            
            String string = String.join(",", str);
                        
            System.out.println(string+"  i==" + i +",进行了"+ (A.length-i-1) +"次判断");
        }
    }
}
