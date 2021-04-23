package SampleCal;

public class Operation {
	public double operationPlus(double a, double b) {
		return a+b;
	}//µ¡¼À
	
	public double operationMinus(double a, double b) {
		return a-b;
	}//»¬¼À
	
	public double operationDiv(double a, double b) {
		return a/b;
	}//³ª´°¼À
	
	public double operationMulti(double a, double b) {
		return a*b;
	}//°ö¼À
	
	public double operationMod(double a, double b) {
		return a%b;
	}//³ª¸ÓÁö
	
	public double operationLogFunction(double a) {
		return Math.log(a);
	}//
	
	public double operationInvolutionFunction(double a,double b) {
		return Math.pow(a,b);
		
	}//°ÅµìÁ¦°ö ¿¬»ê(Áö¼ö¿¬»ê)
	
	public double operationSqrtFunction(double a) {
		return Math.sqrt(a);
	}//Á¦°ö±Ù 
	
	public double operationFactorialFunction(double a) {
		if (a<=1) {
			return 1 ;
		}else {
			return operationFactorialFunction(a-1)*a;
		}// ÆÑÅä¸®¾ó ¿¬»ê 
	}
	
	public double[] operationSAMGAK(double a) {
		
		double samgak []  = new double[3];
		
		samgak[0] = Math.sin(a);
		samgak[1] = Math.cos(a);
		samgak[2] = Math.tan(a);
		
		return samgak;
		}//»ï°¢ÇÔ¼ö
	
	public double operationAbs(double a) {
		return Math.abs(a);
	}//Àý´ë°ª
	
	public String[] operationtoDeposition(double a) {
		int b = Integer.parseInt(String.valueOf(Math.round(a)));
		
		String Deposit [] = new String[3];
		
		Deposit[0] = Integer.toBinaryString((int)b);
		Deposit[1] = Integer.toOctalString((int)b);
		Deposit[2] = Integer.toHexString((int)b);
		
		return Deposit;
		
		
	}//Áø¹ýº¯È¯ 
	

}
