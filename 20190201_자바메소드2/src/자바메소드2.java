// ������ �Է��� �޾Ƽ� ==> 2�������� ��ȯ
/*
 *  0000 1010
 */
public class �ڹٸ޼ҵ�2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=(int)(Math.random()*100)+1;
		System.out.println("num : "+num);
		System.out.println(Integer.toBinaryString(num));
		bin(num);
		// ������
		
	}
	static void bin(int num) {
		int[] bin=new int[8];
		int index=7;
		// �迭 ==> 0, 7
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