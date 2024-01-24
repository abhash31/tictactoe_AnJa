package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView p1Score, p2Score;
    int p1=0, p2=0;
    int flag = 0;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void game(View v){
        Button btn = (Button)v;
        if(btn.getText().toString().equals("")) {
            if (flag == 0) {
                btn.setText("X");
                flag = 1;
            } else {
                btn.setText("O");
                flag = 0;
            }
            count++;
        }
        if(count>4){
            String b1 = btn1.getText().toString();
            String b2 = btn2.getText().toString();
            String b3 = btn3.getText().toString();
            String b4 = btn4.getText().toString();
            String b5 = btn5.getText().toString();
            String b6 = btn6.getText().toString();
            String b7 = btn7.getText().toString();
            String b8 = btn8.getText().toString();
            String b9 = btn9.getText().toString();

            if(b1.equals(b2) && b1.equals(b3) && !b1.equals("")){
                gameState(b1);
                gameRestart(b1);
            } else if(b4.equals(b5) && b4.equals(b6) && !b4.equals("")){
                gameState(b4);
                gameRestart(b4);
            } else if(b7.equals(b8) && b7.equals(b9) && !b7.equals("")){
                gameState(b7);
                gameRestart(b7);
            } else if(b1.equals(b4) && b1.equals(b7) && !b1.equals("")){
                gameState(b1);
                gameRestart(b1);
            } else if(b2.equals(b5) && b2.equals(b8) && !b2.equals("")) {
                gameState(b2);
                gameRestart(b2);
            } else if(b3.equals(b6) && b3.equals(b9) && !b3.equals("")){
                gameState(b3);
                gameRestart(b3);
            } else if(b1.equals(b5) && b1.equals(b9) && !b1.equals("")) {
                gameState(b1);
                gameRestart(b1);
            } else if(b3.equals(b5) && b3.equals(b7) && !b3.equals("")){
                gameState(b3);
                gameRestart(b3);
            } else if(count==9){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
                gameRestart();
            }
        }
    }
    void gameState(String s){
        if(s.equals("X")){
            p1++;
            p1Score.setText(String.format("%s",p1));
        } else{
            p2++;
            p2Score.setText(String.format("%s",p2));
        }
        Toast.makeText(this, s+" is Winner!", Toast.LENGTH_SHORT).show();
    }
    void gameRestart(String s){
        count=0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        if(s.equals("X")){
            flag=0;
        } else{
            flag=1;
        }
    }
    void gameRestart(){
        count=0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        p1Score = findViewById(R.id.txtP1Score);
        p2Score = findViewById(R.id.txtP2Score);
    }
}