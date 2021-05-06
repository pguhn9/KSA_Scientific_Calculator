package com.example.scicalc;


public class ConvertFunc {

    String convertSelect(String str) {  //소수->분수,  분수->소수 변환 선택 메소드
        if (str.contains(".")) { // .을 포함할 때
            return operationFraction(str);
        }
        else if (str.contains("/")) { // /을 포함할 떄
            return operationRealNum(str);
        }
        else { // 둘다 아닐 때
            return str;
        }
    }

    private String operationFraction(String str) { //소수 -> 분수 메소드

        String rn = str.substring(str.lastIndexOf(".")+1); //. 뒤에 값을 다 가져오기
        int rnlen = rn.length(); // 문자열 길이재기
        String denominator = Double.toString(Math.pow(10, rnlen));      //10의 거듭제곱 수 만들기, 실수 ->string으로
        denominator =denominator.substring(0,denominator.lastIndexOf("."));       // 처음부터 . 전까지 가져오기 100.0 ->100
        String numerator = str.replace(".",""); // 점을 공백으로 변환

        Long numeratorL = Long.parseLong(numerator); // 문자열 -> Long으로
        Long denominatorL = Long.parseLong(denominator); //문자열 -> Long으로
        Long gcd= operationGcd(numeratorL, denominatorL); // 최대공약수 구하기
        String result = ((Long.toString(numeratorL/gcd)+"/"+Long.toString(denominatorL/gcd)));// 최대공약수로 나눠주기, 문자열로 합치기.
        System.out.println(result);
        return result;

    }

    private String operationRealNum(String str) { //분수-> 소수로 변환하는 메소드
        String denominator = str.substring(str.lastIndexOf("/")+1); // /의 뒷부분 가져오기
        String numerator = str.substring(0,str.lastIndexOf("/")); // /의 앞부분 가져오기

        double fraction = (Double.parseDouble(numerator)/Double.parseDouble(denominator));// 실수로 변환하여 소수 계산
        String result = Double.toString(fraction); // 실수 -> string으로
        System.out.println(result);
        return result;

    }

    private long operationGcd(Long a, Long b) { //최대 공약수 구하는 메소드 (유클리드 호제법)
        while(b!= 0) {
            long u = a%b;
            a = b;
            b = u;
        }
        return a;
    }




}
