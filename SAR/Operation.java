package com.example.scicalc;


public class Operation {
    public double operationPlus(double a, double b) {
        return a+b;
    }//덧셈

    public double operationMinus(double a, double b) {
        return a-b;
    }//뺄셈

    public double operationDiv(double a, double b) {
        return a/b;
    }//나눗셈

    public double operationMulti(double a, double b) {
        return a*b;
    }//곱셈

    public double operationMod(double a, double b) {
        return a%b;
    }//나머지

    public double operationLog10(double a) {
        return Math.log10(a);
    }//상용로그 연산

    public double operationSqrt(double a) {
        return Math.sqrt(a);
    }//제곱근 연산

    public double operationInvolution(double a,double b) {
        return Math.pow(a,b);

    }//거듭제곱 연산

    public double operationFactorial(double a) {
        if (a<=1) {
            return 1 ;
        }else {
            return (operationFactorial(a-1))*a;
        }// 팩토리얼 연산
    }
    public double[] operationTrigono(double a) {

        double trigono []  = new double[3];

        trigono[0] = Math.sin(a);
        trigono[1] = Math.cos(a);
        trigono[2] = Math.tan(a);

        return trigono;
    }//삼각함수

    public double operationAbs(double a) {
        return Math.abs(a);
    }//절대값

    public String[] operationToDeposition(double a) {
        int b = Integer.parseInt(String.valueOf(Math.round(a)));

        String Deposit [] = new String[3];

        Deposit[0] = Integer.toBinaryString((int)b);
        Deposit[1] = Integer.toOctalString((int)b);
        Deposit[2] = Integer.toHexString((int)b);

        return Deposit;
    }
}
