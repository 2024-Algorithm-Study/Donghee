import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 
        
        String str=sc.next(); //정렬하려는 수 N 입력받음
        String[] num=str.split(""); //N을 한 글자씩 배열에 저장
        int arr[]=new int[num.length]; //배열 num의 길이만큼 정수배열 생성

        for(int i=0;i<num.length;i++){
            arr[i]=Integer.parseInt(num[i]); //배열 num의 숫자로된 문자를 정수로 변환
        }

        Arrays.sort(arr); //정렬
        
        //정렬된 arr 배열을 뒤에서 부터 출력
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]);
        }
    }
}
