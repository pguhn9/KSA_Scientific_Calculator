package SampleCal;

public class ConvertFunc {
	

	
	public static  String sosuBunsu(String str1) { //소수 -> 분수 메소드
		
		
		String sosu = str1.substring(str1.lastIndexOf(".")+1); //. 뒤에 값을 다 가져오기 
		int s = sosu.length(); // 문자열 길이재기
		double denominator = Math.pow(10, s); // 10의 거듭제곱 수 만들기
		String denominatorString = Double.toString(denominator); //실수 ->string으로 
		String denomi =denominatorString.substring(0,denominatorString.lastIndexOf(".")); // 처음부터 . 전까지 가져오기 100.0 ->100
		
		String numerator = str1.replace(".",""); // 점을 공백으로 변환
		String bunsu = numerator +"/"+denomi; // 문자열 합치기
		
		 int numerator1 = Integer.parseInt(numerator); // 문자열 -> int로
		 int denomi2 = Integer.parseInt(denomi); //문자열 -> int로
		 int c = gcd(numerator1, denomi2); // 최대공약수 구하기		 
		 String result = ((Integer.toString(numerator1/c)+"/"+Integer.toString(denomi2/c)));// 최대공약수로 나눠주기
		 System.out.println(result);
		 
		
		return result;

	}
	
	public static int gcd(int a, int b) { //최대 공약수 구하는 메소드 (유클리드 호제법)
		
		while(b!= 0) {
			int r = a%b;
			a =b;
			b=r;
			
		}
		return a;
	}
	
	
	public static String bunsuSosu (String str2) { //분수-> 소수로 변환하는 메소드
		String bunmo = str2.substring(str2.lastIndexOf("/")+1); // /의 뒷부분 가져오기 
		String bunza = str2.substring(0,str2.lastIndexOf("/")); // /의 앞부분 가져오기
		
		double bunsu = (Double.parseDouble(bunza)/Double.parseDouble(bunmo));// 실수로 변환하여 소수 계산
		String result2 = Double.toString(bunsu); // 실수 -> string으로 
		System.out.println(result2);
		
		return result2;

	}
	
	public static String jungsu (String str3) { // 정수일때 쓰는 메소드 
		System.out.println(str3);
		return str3 ;
	}

	public static String ConvertAll(String str) { // 종합 메소드
		
		if (str.contains(".")) { // .을 포함할 때 
			return sosuBunsu(str);
			
		}
		else if (str.contains("/")) { // /을 포함할 떄
			return bunsuSosu(str);
		}
		else { // 둘다 아닐 때
			return jungsu(str);
		}
			

}
	
}
