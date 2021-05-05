package com.example.scicalc;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnReset, btnDel, btnLeftP, btnRightP, btnDot, btnEqual;
    Button btnPlus, btnMinus, btnMulti, btnDivision, btnLog, btnConvertSD, btnMod, btnInvolution, btnFactorial;
    Button btnConv, btnPi, btnSqrt, btnAbs, btnTrigono;

    TextView operExpressionDisplay, historyDisplay;
    ScrollView scrollView;

    InputOutput io;
    History history;


    String operExpression, input, historyData, comp;
    Double result;
    ConvertFunc cvf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기화
        init();

        //버튼 리스너
        setNumListener();
        setOperationListener();
    }


    void init() {
        //리소스 연결
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnReset = (Button) findViewById(R.id.btnReset);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnLeftP = (Button) findViewById(R.id.btnLeftParenthesis);
        btnRightP = (Button) findViewById(R.id.btnRightParenthesis);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnReset = (Button) findViewById(R.id.btnReset);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnConvertSD = (Button) findViewById(R.id.btnConvertSD);
        btnInvolution = (Button) findViewById(R.id.btnInvolution);
        btnFactorial = (Button) findViewById(R.id.btnFactorial);

        btnConv = (Button) findViewById(R.id.btnConv);
        btnPi = (Button) findViewById(R.id.btnPi);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnAbs = (Button) findViewById(R.id.btnAbs);
        btnTrigono = (Button) findViewById(R.id.btnTrigono);


        operExpressionDisplay = (TextView) findViewById(R.id.operExpression);
        historyDisplay = (TextView) findViewById(R.id.historyDisplay);
        scrollView = (ScrollView) findViewById(R.id.sv);

        io = new InputOutput();
        history = new History();
        cvf = new ConvertFunc();

        //변수 초기화
        operExpression = "";
        input = "";
        result = 0.0;
        comp = new String();
    }


    void setNumListener() {

        //리스너 정의
        //숫자 버튼 눌렸을 때
        View.OnClickListener NumListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**   id 상수값으로 코드 줄이는 방법 생각해보기   **/
                switch (view.getId()) {
                    case R.id.btn0:
                        input += "0";
                        operExpression += "0";
                        break;

                    case R.id.btn1:
                        input += "1";
                        operExpression += "1";
                        break;

                    case R.id.btn2:
                        input += "2";
                        operExpression += "2";
                        break;

                    case R.id.btn3:
                        input += "3";
                        operExpression += "3";
                        break;

                    case R.id.btn4:
                        input += "4";
                        operExpression += "4";
                        break;

                    case R.id.btn5:
                        input += "5";
                        operExpression += "5";
                        break;

                    case R.id.btn6:
                        input += "6";
                        operExpression += "6";
                        break;

                    case R.id.btn7:
                        input += "7";
                        operExpression += "7";
                        break;

                    case R.id.btn8:
                        input += "8";
                        operExpression += "8";
                        break;

                    case R.id.btn9:
                        input += "9";
                        operExpression += "9";
                        break;

                }
                //operExpressionDisplay에 연산식 출력
                operExpressionDisplay.setText(operExpression);
            }
        };
        btn0.setOnClickListener(NumListener);
        btn1.setOnClickListener(NumListener);
        btn2.setOnClickListener(NumListener);
        btn3.setOnClickListener(NumListener);
        btn4.setOnClickListener(NumListener);
        btn5.setOnClickListener(NumListener);
        btn6.setOnClickListener(NumListener);
        btn7.setOnClickListener(NumListener);
        btn8.setOnClickListener(NumListener);
        btn9.setOnClickListener(NumListener);
    }


    void setOperationListener() {
        View.OnClickListener OperationListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnPlus:
                        input += "+";
                        operExpression += "+";
                        break;

                    case R.id.btnMinus:
                        input += "-";
                        operExpression += "-";
                        break;

                    case R.id.btnMulti:
                        input += "*";
                        operExpression += "*";
                        break;

                    case R.id.btnDivision:
                        input += "/";
                        operExpression += "/";
                        break;

                    case R.id.btnMod:
                        input += "%";
                        operExpression += "mod";
                        break;

                    case R.id.btnInvolution:
                        input += "^";
                        operExpression += "^";
                        break;

                    case R.id.btnConv: //my
                        input += "c(";
                        operExpression += "conv(";
                        break;

                    case R.id.btnPi:
                        input += "P";
                        operExpression += "π";
                        break;

                    case R.id.btnSqrt:
                        input += "s(";
                        operExpression += "Sqrt(";
                        break;

                    case R.id.btnAbs:
                        input += "a(";
                        operExpression += "Abs(";
                        break;

                    case R.id.btnTrigono:
                        input += "t(";
                        operExpression += "trigono(";
                        break;

                    case R.id.btnLog:
                        input += "l(";
                        operExpression += "log(";
                        break;

                    case R.id.btnConvertSD: //con
                        //input += "";
                        operExpression = cvf.convertSelect(input);
                        System.out.println(input);
                        System.out.println(operExpression);
                        input = operExpression;
                        break;

                    case R.id.btnFactorial:
                        input += "!";
                        operExpression += "!";
                        break;

                    case R.id.btnLeftParenthesis:
                        input += "(";
                        operExpression += "(";
                        break;

                    case R.id.btnRightParenthesis:
                        input += ")";
                        operExpression += ")";
                        break;

                    case R.id.btnDot:
                        input += ".";
                        operExpression += ".";
                        break;

                    case R.id.btnEqual:
                        operExpression += "=";
                        result = io.inputFunction(input);

                        //show history
                        historyData = history.showHistory(operExpression + result);
                        historyDisplay.append(historyData);


                        comp = io.popNumStack();
                        if(comp=="tri" && !io.isEmtyNumStack()) {
                            //System.out.println(io.popNumStack());
                            historyDisplay.append("tan: "+io.popNumStack()+"\n");
                            historyDisplay.append("cos: "+io.popNumStack()+"\n");
                            historyDisplay.append("sin: "+io.popNumStack()+"\n");
                            scrollView.fullScroll(View.FOCUS_DOWN);
                            operExpression = "";
                            input = "";
                        } else if(comp=="cov" && !io.isEmtyNumStack()) {
                            historyDisplay.append("HEX: "+io.popNumStack()+"\n");
                            historyDisplay.append("OCT: "+io.popNumStack()+"\n");
                            historyDisplay.append("BIN: "+io.popNumStack()+"\n");
                            scrollView.fullScroll(View.FOCUS_DOWN);
                            operExpression = "";
                            input = "";
                        } else{
                            scrollView.fullScroll(View.FOCUS_DOWN);
                            operExpression = result + "";
                            input = result + "";
                        }

                        break;

                    case R.id.btnDel:
                        if (input.length() - 1 >= 0) {
                            input = input.substring(0, input.length() - 1);
                            operExpression = input;
                        }
                        break;

                    case R.id.btnReset:
                        input = "";
                        operExpression = "";
                        operExpressionDisplay.setText("");
                        break;
                }

                //operExpressionDisplay에 연산식 출력
                operExpressionDisplay.setText(operExpression);

            }
        };

        btnPlus.setOnClickListener(OperationListener);
        btnMinus.setOnClickListener(OperationListener);
        btnMulti.setOnClickListener(OperationListener);
        btnDivision.setOnClickListener(OperationListener);
        btnMod.setOnClickListener(OperationListener);
        btnInvolution.setOnClickListener(OperationListener);
        btnLog.setOnClickListener(OperationListener);
        btnConvertSD.setOnClickListener(OperationListener);
        btnFactorial.setOnClickListener(OperationListener);
        btnLeftP.setOnClickListener(OperationListener);
        btnRightP.setOnClickListener(OperationListener);
        btnDot.setOnClickListener(OperationListener);
        btnEqual.setOnClickListener(OperationListener);
        btnReset.setOnClickListener(OperationListener);
        btnDel.setOnClickListener(OperationListener);

        btnConv.setOnClickListener(OperationListener);
        btnPi.setOnClickListener(OperationListener);
        btnSqrt.setOnClickListener(OperationListener);
        btnAbs.setOnClickListener(OperationListener);
        btnTrigono.setOnClickListener(OperationListener);



    }
}
