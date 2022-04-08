package algorithm_day16_17;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimePallindrome_AndAnagram {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public void primeNumber() {
        int i , j , flag;

        for(i=0;i<=1000;i++) {
            if(i==0 || i==1)
                continue;
            flag = 1;

            for(j=2;j<=i/2;++j) {
                if(i%j == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                arrayList.add(i);
        }
    }

    public void printArrayList() {
        primeNumber();
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }

    public void primePalindrome() {
        primeNumber();
        for (int i = 0; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            int rem = 0;
            int reverse = 0;
            int temp = num;

            while(num > 0) {
                rem = num % 10;
                num = num / 10;
                reverse = reverse * 10 + rem;
            }
            if(temp == reverse) {
                System.out.print(reverse + " ");
            }else {
                continue;
            }
        }
    }

    public void primeAnagram() {
        primeNumber();
        for(int i=0;i<arrayList.size();i++) {
            int num1 = arrayList.get(i);
            String str1 = Integer.toString(num1);

            for(int j=i+1;j<arrayList.size();j++) {
                int num2 = arrayList.get(j);
                String str2 = Integer.toString(num2);

                if(str1.length() == str2.length()) {
                    char[] array1 = str1.toCharArray();
                    char[] array2 = str2.toCharArray();

                    Arrays.sort(array1);
                    Arrays.sort(array2);

                    boolean result = Arrays.equals(array1,array2);

                    if(result) {
                        System.out.println(str1 + " And "+str2 + " Are Anagram");
                    }else {
                        continue;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrimePallindrome_AndAnagram ppa = new PrimePallindrome_AndAnagram();

        //System.out.println("Prime Numbers Are: ");
        //ppa.printArrayList();

        System.out.println("\nPrime Palindrome Numbers are: ");
        ppa.primePalindrome();

        System.out.println("\n\nPrime Anagram Numbers are: ");
        ppa.primeAnagram();
    }
}