package com.example.vsasikumar.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements OnItemSelectedListener {

    EditText num1,num2;
    Button button01;
    TextView tv1;
    ImageView iv1;
    Spinner spinOps;
    String[] ops={"Choose operation","+","-","*","/"};
    String opselected;
    double a,b,c;
    private OnClickListener myClickListener=new OnClickListener() {
        @Override
        public void onClick(View view) {
            a = Double.parseDouble(num1.getText().toString());
            b = Double.parseDouble(num2.getText().toString());
            if (opselected == "+") {
                c = a + b;
                tv1.setText(Double.toString(c));
            } else if (opselected == "-") {
                c = a - b;
                tv1.setText(Double.toString(c));
            } else if (opselected == "*") {
                c = a * b;
                tv1.setText(Double.toString(c));
            } else if (opselected == "/") {
                c = a / b;
                tv1.setText(Double.toString(c));
            } else {
                tv1.setText("Please select the operation");
            }
        }
};
    @Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv1=(TextView)findViewById(R.id.Button01);
    button01=(Button)findViewById(R.id.Button01);
    button01.setText("Display result");
    button01.setOnClickListener(myClickListener);
    num1=(EditText)findViewById(R.id.EditText01);
    num1.setText("");
    num2=(EditText)findViewById(R.id.EditText02);
    num2.setText("");
    spinOps=(Spinner)findViewById(R.id.Spinner01);
    ArrayAdapter<String> adapter=new ArrayAdapter<String>(
            this,android.R.layout.simple_spinner_item,ops);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinOps.setAdapter(adapter);
    spinOps.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
}
    public void onItemSelected(AdapterView<?>p,View v,int position,long id){
        opselected=ops[position];
        tv1.setText("You have selected"+opselected);
    }
    public void onNothingSelected(AdapterView<?>p){
        tv1.setText("Please select ops");
    }
}
