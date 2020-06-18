package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
   Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnMinus,btnPlus,btnDivide,btnDot,btnClear,
           btnbrackets,btnpercent,btnmultiply,btnequals,btnback;
   TextView tvInput,tvOutput;
   String process;
   boolean checkBracktes=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.bnt1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnPlus=findViewById(R.id.btnPlus);
        btnmultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);
        btnMinus=findViewById(R.id.btnMinus);
        btnequals=findViewById(R.id.btnequal);
        btnClear=findViewById(R.id.btnClear);
        btnDot=findViewById(R.id.btnDot);
        btnback=findViewById(R.id.btnBack);
        btnpercent=findViewById(R.id.btnPercent);
        btnbrackets=findViewById(R.id.btnBracket);

        tvInput=findViewById(R.id.tvInput);
        tvOutput=findViewById(R.id.tvOutput);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"9");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"-");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"/");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+".");
            }
        });
        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"%");
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"x");
            }
        });
        btnbrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (checkBracktes){
                 process=tvInput.getText().toString();
                 tvInput.setText(process+")");
                 checkBracktes=false;
             }
             else{
                 process=tvInput.getText().toString();
                 tvInput.setText(process+"(");
                 checkBracktes=true;
             }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                if(process.length()>0){
                    process = process.substring(0,process.length()-1);
                    tvInput.setText(process);
                }
            }
        });

        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                process=process.replaceAll("x","*");
                process=process.replaceAll("%","/100");

                Context rhino =Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult="";
                try{
                    Scriptable scriptable=rhino.initStandardObjects();
                    finalResult= rhino.evaluateString(scriptable,process,"javascript",1,null).toString();

                }catch (Exception e){
                    finalResult="0";
                }
                tvOutput.setText(finalResult);


            }
        });



    }

}
