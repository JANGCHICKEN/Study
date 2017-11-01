import java.util.*;
import org.apache.commons.lang3.*;

/*
네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
   지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 
* 입력 형식 
- 1 <= n <= 16
- arr1, arr2는 길이 n인 정수 배열로 주어진다.
- 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하다. 즉, 0<= x <= 2^n-1을 만족한다.
 
* 출력 형식
원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
*/

public class HiddenMap {
	public static void main(String args[]) {


		int n; //지도 크기

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("지도의 크기 (1~16): ");
			n = scan.nextInt();
			if ((1 <= n) && (n <= 16))
				break;
		}

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int arr = (int) Math.pow(2, n) - 1;

		while (true) {
			int c = 0;
			System.out.println("지도 정수는 0~" + arr);
			for (int i = 0; i < n; i++) {
				System.out.print("arr1[" + i + "] : ");
				arr1[i] = scan.nextInt();
				if (arr1[i] > arr) {
					c = 1;
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print("arr2[" + i + "] : ");
				arr2[i] = scan.nextInt();
				if (arr2[i] > arr) {
					c = 1;
				}
			}

			if (c == 1) {
				System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}
		
		String[] map = {};

		for (int i = 0; i < n; i++) {
			String m;
			m = Integer.toBinaryString(arr1[i] | arr2[i]);
			m = StringUtils.leftPad(m, n, "0");
			m = m.replaceAll("1", "#");
			m = m.replaceAll("0", "-");
			map[i] = m;	
		}
		
		System.out.print("[");
		for(int i=0; i<n; i++) {
			System.out.print("\"" + map[i] + "\"");
			if (i < n - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}