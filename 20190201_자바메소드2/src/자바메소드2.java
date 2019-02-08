// 정수를 입력을 받아서 ==> 2진법으로 변환
/*
 *  0000 1010
 */
public class 자바메소드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=(int)(Math.random()*100)+1;
		System.out.println("num : "+num);
		System.out.println(Integer.toBinaryString(num));
		bin(num);
		// 이진법
		
	}
	static void bin(int num) {
		int[] bin=new int[8];
		int index=7;
		// 배열 ==> 0, 7
		while(true) {
			bin[index]=num%2;
			num=num/2;
			if(num==0) {
				break;
			}
			index--;
		}
		
		for(int i:bin) {
			System.out.print(i);
		}
	}
	
}