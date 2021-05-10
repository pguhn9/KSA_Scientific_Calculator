package com.example.scicalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InputOutput{
    private HashMap<String, Integer> opPriority;
    private List<String> inputString = new ArrayList<>();//inputData에서 숫자를 묶은 것
    private List<String> postFix = new ArrayList<>();//후위표기법
    private Stack<String> opStack = new Stack<>();//연산자 스택
    private Stack<String> numStack = new Stack<>();//계산된 숫자 스택

    {
        opPriority = new HashMap<>();
        opPriority.put("(", 0);
        opPriority.put(")", 0);
        opPriority.put("+", 1);
        opPriority.put("-", 1);
        opPriority.put("*", 2);
        opPriority.put("/", 2);
        opPriority.put("%", 2);
        opPriority.put("^", 2);
        opPriority.put("!", 3);
        opPriority.put("s", 3);//sqrt
        opPriority.put("l", 3);//log
        opPriority.put("a", 3);//abs
        opPriority.put("c", 3);//conv
        opPriority.put("t", 3);//삼각함수
    }

    void init() {//리스트 초기화
        inputString.clear();
        postFix.clear();
        opStack.clear();
        numStack.clear();
    }

    String popNumStack(){ //외부에서 numStack요소 접근용
        return numStack.pop();
    }

    boolean isEmtyNumStack(){ //외부에서 numStack이 비었는지 확인용
        return numStack.empty();
    }

    double inputFunction(String inputData) {  //입력받은 String에서 끊어져있는 숫자를 이어준다.(1,0,+,5 -> 10,+,5)
		init();
		
		int index = 0;
		int start = index;
		int end = index;
		while(true) {
			char c = inputData.charAt(index);
			if (isOperator(c+"")) {
				if ( c == '-') {
					if (index == 0) {
						inputString.add("-1");
						inputString.add("*");
						index += 1;
					}
					else {
						if(isOperator(inputData.charAt(index-1)+"")) {
							inputString.add("-1");
							inputString.add("*");
							index += 1;
						} else {
								inputString.add("-");
								index += 1;
						}
					}
				}
				else{
					inputString.add(c+"");
					index += 1;
				}
			} else if (c == 'P') {
				inputString.add("3.14159265358979");
				index += 1;
			}else {
				start = index;
				while(true) {
					if(index == inputData.length()-1) {
						end = index+1;
						inputString.add(inputData.substring(start, end));
						index += 1;
						break;
					} else if(isOperator(inputData.charAt(index+1)+"")) {
						end = index+1;
						inputString.add(inputData.substring(start, end));
						index += 1;
						break;
					} else {
						index += 1;
					}
				}	
			}
			if (index == inputData.length())
				break;
		}
		System.out.println(inputString);
		return postFixFunction();
	}

    double postFixFunction() {
        for (int i=0; i<inputString.size(); i++) {
            String s = inputString.get(i);
            if(isOperator(s)) {
                if(s.equals(")")) {
                    while(true) {
                        if (opStack.peek().equals("(")) {
                            opStack.pop();
                            break;
                        }
                        postFix.add(opStack.pop());
                    }
                } else if(s.equals("(")) {
                    opStack.push(s);
                } else if(opStack.isEmpty() || opPriority.get(opStack.peek())<=opPriority.get(s)) {
                    opStack.push(s);
                } else {
                    while(true) {
                        if(opStack.isEmpty() || opStack.peek()=="(" || opPriority.get(opStack.peek())<opPriority.get(s)) break;
                        postFix.add(opStack.pop());
                    }
                    opStack.push(s);
                }

            } else {
                postFix.add(s);
            }
        }
        while(!opStack.isEmpty()) {
            postFix.add(opStack.pop());
        }
        System.out.println(postFix);

        return calculatorFunction();
    }

    double calculatorFunction() {
        double num1=(double) 0;
        double num2=(double) 0;
        double[] arr = new double[3];
        String conv [] = new String[3];
        Operation operation = new Operation();
        for(int i=0; i<postFix.size(); i++) {
            String s = postFix.get(i);
            if(isOperator(s)) {
                switch(s) {
                    case"+":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationPlus(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "-":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationMinus(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "*":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationMulti(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "/":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationDiv(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "%":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationMod(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "^":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationInvolution(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "!":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationFactorial(num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "s":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationSqrt(num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "l":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationLog10(num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "a":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.operationAbs(num2);
                            System.out.println(num1);
                            numStack.add(num1+"");
                        }
                        break;
                    case "c":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            conv = operation.operationToDeposition(num2);
                            for(int j=0; j<3; j++) {
                                numStack.add(conv[j]+"");
                            }
                            numStack.add("cov");
                        }
                        break;
                    case "t":
                        if(numStack.size()>=1) {
                            num2 = Double.parseDouble(numStack.pop());
                            arr = operation.operationTrigono(num2);
                            for(int j=0; j<3; j++) {
                                numStack.add(arr[j]+"");
                            }
                            numStack.add("tri");
                        }
                        break;
                }
            } else {
                numStack.add(s);
            }
        }
        if(numStack.size()==1) {
            System.out.println(numStack.get(0));
            return Double.parseDouble(numStack.get(0));
        } else if(numStack.size()>=3){
            System.out.println(numStack);
            return 0;
        } else {
            return 1;
        }
    }

    boolean isOperator(String c) {
        if(opPriority.containsKey(c))
            return true;
        else
            return false;
    }

}
