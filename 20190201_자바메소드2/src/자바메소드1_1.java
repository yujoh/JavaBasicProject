// 5�� ���� �����߻� _ max min ã��
public class �ڹٸ޼ҵ�1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[5];
		System.out.print("������ 5���� ���� �߻� : ");
		for(int i=0;i<num.length;i++) {
			num[i]=(int)(Math.random()*100)+1;
		}
		for(int arr:num) {
			System.out.print(arr+" ");
		}
		// �ִ밪
		int max=max(num);
		int min=min(num);
		
		System.out.println();
		System.out.println("�ִ밪��? : "+max);
		System.out.println("�ּҰ���? : "+min);
	}
	
	static int max(int[] num) {
		int max=num[0];
		for(int i=0;i<num.length;i++) {
				if(num[i]>max) {
					max=num[i];
				}
		}
		return max;
	}
	
	static int min(int[] num) {
		int min=num[0];
		for(int i=0;i<num.length;i++) {
				if(num[i]<min) {
					min=num[i];
				}
		}
		return min;
	}

}
