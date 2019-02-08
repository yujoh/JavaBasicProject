// 5개 정수 난수발생 _ max min 찾기
// Hello Github
public class 자바메소드1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[5];
		System.out.print("정수인 5개의 난수 발생 : ");
		for(int i=0;i<num.length;i++) {
			num[i]=(int)(Math.random()*100)+1;
		}
		for(int arr:num) {
			System.out.print(arr+" ");
		}
		// 최대값
		int max=max(num);
		int min=min(num);
		
		System.out.println();
		System.out.println("최대값은? : "+max);
		System.out.println("최소값은? : "+min);
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
