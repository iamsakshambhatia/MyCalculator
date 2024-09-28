package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import androidx.activity.enableEdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    double firstNum;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);
        Button equal = findViewById(R.id.equal);
        Button on = findViewById(R.id.ON);
        Button off = findViewById(R.id.off);
        Button del = findViewById(R.id.del);
        Button ac = findViewById(R.id.AC);
        Button point = findViewById(R.id.numdot);

        TextView screen = findViewById(R.id.screen);
        ac.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });
        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });
        ArrayList<Button> nums = new ArrayList<>();
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

        for(Button b : nums){
            b.setOnClickListener(view -> {
                if(!screen.getText().toString().equals("0")){
                    String op = screen.getText().toString() + b.getText().toString();
                    screen.setText(op);
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }
        ArrayList<Button> opr = new ArrayList<>();
        opr.add(add);
        opr.add(sub);
        opr.add(mul);
        opr.add(div);

        for(Button b : opr){
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }
        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if(num.length() > 1){
                screen.setText(num.substring(0,num.length()-1));
            } else if(num.length() == 1 && !num.equals("0")){
                screen.setText("0");
            }
        });

        point.setOnClickListener(view -> {
            if(!screen.getText().toString().contains(".")){
                String op = screen.getText().toString()+".";
                screen.setText(op);
            }
        });

        equal.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double res;
            switch (operation) {
                case "+":
                    res = firstNum + secondNum;
                    break;
                case "-":
                    res = firstNum - secondNum;
                    break;
                case "*":
                    res = firstNum * secondNum;
                    break;
                case "/":
                    res = firstNum / secondNum;
                    break;
                default:
                    res = firstNum + secondNum;
            }
            screen.setText(String.valueOf(res));
            firstNum = res;
        });
    }
}