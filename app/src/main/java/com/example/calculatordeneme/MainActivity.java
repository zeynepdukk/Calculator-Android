package com.example.calculatordeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstnum;
    String operation;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button div = findViewById(R.id.div);
        Button times = findViewById(R.id.times);
        Button min = findViewById(R.id.min);
        Button equal = findViewById(R.id.equal);
        Button plus = findViewById(R.id.plus);
        Button point = findViewById(R.id.point);

        TextView results =findViewById(R.id.results);

        ac.setOnClickListener(view -> {
            results.setText("0");
        });

        off.setOnClickListener(view -> results.setVisibility(View.GONE));

        on.setOnClickListener(view -> {
            results.setVisibility(View.VISIBLE);
            results.setText("0");
        });

        ArrayList<Button> nums= new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button button : nums){
            button.setOnClickListener(view -> {
                if(!results.getText().toString().equals("0")) {
                    results.setText(results.getText().toString() + button.getText().toString());
                }
                else{
                    results.setText(button.getText().toString());
                }
            });
        }

        ArrayList<Button> opers =new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(min);


        for (Button button: opers){
            button.setOnClickListener(view -> {
                firstnum = Double.parseDouble(results.getText().toString());
                operation = button.getText().toString();
                results.setText("0");
            });
        }

        del.setOnClickListener(view -> {
            String num= results.getText().toString();
            if (num.length()>1){
                results.setText(num.substring(0,num.length()-1));
            }
            else if (num.length()==1 && !num.equals("0")){
                results.setText("0");
            }
        });

        point.setOnClickListener(view -> {
            if(!results.getText().toString().contains(".")){
                results.setText(results.getText().toString()+".");
            }
        });

        equal.setOnClickListener(view -> {
            double secondNum =Double.parseDouble(results.getText().toString());
            double result = 0;
            switch (operation){
                case "%":
                    if(secondNum!=0){
                        result=firstnum/secondNum;
                    }
                    else {
                        results.setText("ERROR");
                        return;
                    }
                break;
                case "X":
                    result = firstnum*secondNum;
                    break;
                case "+":
                    result = firstnum+secondNum;
                    break;
                case "-":
                    result = firstnum-secondNum;
                    break;
                default:
                    result = firstnum+secondNum;
            }
            results.setText(String.valueOf(result));
            firstnum = result;


        });

    }
}