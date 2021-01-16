package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
    String number = "";
    String solution = "";
    int clearFlag = 1;
    Object result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int Orientation = getResources().getConfiguration().orientation;

        final TextView output = findViewById(R.id.output);
        Button num_0 = findViewById(R.id.num_0);
        Button num_1 = findViewById(R.id.num_1);
        Button num_2 = findViewById(R.id.num_2);
        Button num_3 = findViewById(R.id.num_3);
        Button num_4 = findViewById(R.id.num_4);
        Button num_5 = findViewById(R.id.num_5);
        Button num_6 = findViewById(R.id.num_6);
        Button num_7 = findViewById(R.id.num_7);
        Button num_8 = findViewById(R.id.num_8);
        Button num_9 = findViewById(R.id.num_9);
        Button decimal = findViewById(R.id.decimal);
        Button equals = findViewById(R.id.equal);
        ImageButton delete = findViewById(R.id.delete);
        final Button clear = findViewById(R.id.clear);
        Button add = findViewById(R.id.add);
        final Button subtract = findViewById(R.id.subtract);
        Button divide = findViewById(R.id.divide);
        Button multiply = findViewById(R.id.multiply);
        final TextView input = findViewById(R.id.input);
        input.setText("0.0");

        if(Orientation == Configuration.ORIENTATION_LANDSCAPE){

        }

/*        if(savedInstanceState != null){
            solution = savedInstanceState.getString("SOLUTION");
            result = savedInstanceState.getString("RESULT");
            clearFlag = 0;
            input.setText(solution);
            output.setText(result.toString());
        }
*/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "";
                solution = "";
                input.setText("0.0");
                clearFlag = 1;
                output.setText("");
            }
        });
        num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                number += "0";
                solution+="0";
                input.setText(solution);
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                number += "1";
                solution+="1";
                input.setText(solution);
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                number += "2";
                solution+="2";
                input.setText(solution);

            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="3";
                number += "3";
                input.setText(solution);

            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                number += "4";
                solution+="4";
                input.setText(solution);

            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="5";
                number += "5";
                input.setText(solution);

            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="6";
                number += "6";
                input.setText(solution);

            }
        });
        num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="7";
                number += "7";
                input.setText(solution);

            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="8";
                number += "8";
                input.setText(solution);

            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                solution+="9";
                number += "9";
                input.setText(solution);

            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                if(number=="" && solution==""){
                    number = "0.";
                    solution += "0.";
                    input.setText(solution);
                }
                else if(!number.contains(".")) {
                    try{
                        if(!(solution.substring(solution.length()-1).contains("+") || solution.substring(solution.length()-1).contains("/") || solution.substring(solution.length()-1).contains("*") || solution.substring(solution.length()-1).contains("-"))){
                            number = number + ".";
                            solution += ".";
                            input.setText(solution);
                        }
                    }
                    catch (Exception e){

                    }
                }

            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            solutions();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(solution!="" && solution.length()>1) {
                    try{
                        if(solution.substring(solution.length()-1).contains("+") || solution.substring(solution.length()-1).contains("/") || solution.substring(solution.length()-1).contains("*") || solution.substring(solution.length()-1).contains("-")){
                        }
                        else{
                            number = number.substring(0, number.length() - 1);
                        }
                    }
                    catch (Exception e){

                    }
                    solution = solution.substring(0, solution.length() - 1);
                    input.setText(solution);
                }
                else if(solution.length()==1) {
                    solution = "";
                    clearFlag = 1;
                    number = "";
                    input.setText("0.0");
                    output.setText(" ");
                }
            }
        });
        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                solution = "";
                number = "";
                input.setText("0.0");
                clearFlag = 1;
                output.setText("");
                return true;
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                try {
                    if(solution.length()>=1) {
                        if (solution.substring(solution.length() - 1).contains("+") || solution.substring(solution.length() - 1).contains("/") || solution.substring(solution.length() - 1).contains("*") || solution.substring(solution.length() - 1).contains("-")) {
                            solution = solution.substring(0, solution.length() - 1) + "+";
                            number = "";
                            input.setText(solution);
                        } else {
                            solution = solution + "+";
                            number = "";
                            input.setText(solution);
                        }
                    }
                    else {
                            solution = "+";
                            input.setText(solution);

                    }
                }
                catch (Exception e){
                    if(solution=="") {
                        solution = "+";
                        input.setText(solution);
                    }
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                try {
                    if(solution.length()>=1) {
                        if (solution.substring(solution.length() - 1).contains("+") || solution.substring(solution.length() - 1).contains("/") || solution.substring(solution.length() - 1).contains("*") || solution.substring(solution.length() - 1).contains("-")) {
                            solution = solution.substring(0, solution.length() - 1) + "-";
                            number = "";
                            input.setText(solution);
                        } else {
                            solution = solution + "-";
                            number = "";
                            input.setText(solution);
                        }
                    }

                    else {
                            solution = "-";
                        input.setText(solution);
                    }
                }
                catch (Exception e) {
                    if (solution == "") {
                        solution = "-";
                        input.setText(solution);
                    }
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                try {
                    if(solution.length()>=1) {
                        if (solution.substring(solution.length() - 1).contains("+") || solution.substring(solution.length() - 1).contains("/") || solution.substring(solution.length() - 1).contains("*") || solution.substring(solution.length() - 1).contains("-")) {
                            solution = solution.substring(0, solution.length() - 1) + "/";
                            number = "";
                            input.setText(solution);
                        } else {
                            solution = solution + "/";
                            number = "";
                            input.setText(solution);
                        }
                    }
                }
                catch (Exception e){}
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFlag = 0;
                try {
                    if(solution.length()>=1) {
                        if (solution.substring(solution.length() - 1).contains("+") || solution.substring(solution.length() - 1).contains("/") || solution.substring(solution.length() - 1).contains("*") || solution.substring(solution.length() - 1).contains("-")) {
                            solution = solution.substring(0, solution.length() - 1) + "*";
                            number = "";
                            input.setText(solution);
                        } else {
                            solution = solution + "*";
                            number = "";
                            input.setText(solution);
                        }
                    }
                }
                catch (Exception e){}
            }
        });
    }
    void solutions (){
        final TextView output = findViewById(R.id.output);
        if(solution==""){
            output.setText("0.0");
        }
        else {
            clearFlag = 1;
            try {
                result = engine.eval(solution);
                if(result.toString().contains("NaN")){
                    output.setText("Cant divide 0/0");
                }
                else {
                    output.setText(result.toString());
                }
                Log.d("Calculator", "Operation: " + result + " result: " + result);
            } catch (ScriptException e) {
                output.setText("error");
                Log.e("Calculator", " ScriptEngine error: " + e.getMessage());
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(clearFlag!=0) {
            if (solution != null && result != null) {
                outState.putString("SOLUTION", solution);
                outState.putString("RESULT", result.toString());
            }
        }
    }
}


