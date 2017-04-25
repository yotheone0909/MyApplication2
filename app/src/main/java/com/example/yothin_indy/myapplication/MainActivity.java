package com.example.yothin_indy.myapplication;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvHello;
    EditText edText;
    EditText editTextHello;
    Button btnCopy;
    EditText editText1;
    EditText editText2;
    TextView tvResult;
    Button btncalculate;
    RadioGroup rgGroup;
    RadioButton rbPlus;
    RadioButton rbMinus;
    RadioButton rbMultiply;
    RadioButton rbDivide;
    CustomViewGroup viewGroup1;
    CustomViewGroup viewGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText(Html.fromHtml("<b>He<u><i>llo</i>"));
        edText = (EditText)findViewById(R.id.etText);
        editTextHello = (EditText)findViewById(R.id.editextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    tvHello.setText(editTextHello.getText().toString());
                    return true;
                }
                return false;
            }
        });

        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btncalculate = (Button) findViewById(R.id.btnCalculate);
        btncalculate.setOnClickListener(this);

        rgGroup = (RadioGroup) findViewById(R.id.rgGroup);
        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
        rbMinus = (RadioButton) findViewById(R.id.rbMinus);
        rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
        rbDivide = (RadioButton) findViewById(R.id.rbDivide);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widht = size.x;
        int height = size.y;

        Toast.makeText(this, "Width = "+widht+",Height = "+height, Toast.LENGTH_SHORT).show();

        viewGroup1 = (CustomViewGroup)findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup)findViewById(R.id.viewGroup2);
        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");

    }

    @Override
    public void onClick(View v) {
        if(v == btnCopy){
            tvHello.setText(editTextHello.getText().toString());
        }else if (v == btncalculate){
            int a = 0;
            int b = 0;
            int total = 0;
            try {
                a = Integer.parseInt(editText1.getText().toString());
            }catch (NumberFormatException e){

            }
            try {
                b = Integer.parseInt(editText2.getText().toString());
            }catch (NumberFormatException e){

            }

            switch (rgGroup.getCheckedRadioButtonId()){
                case R.id.rbPlus:

                    total = a+b;
                    break;
                case R.id.rbMinus:

                    total = a-b;
                    break;
                case R.id.rbMultiply:

                    total = a*b;
                    break;
                case R.id.rbDivide:
                    total = a/b;

                    break;
            }
            tvResult.setText(total+"");

            Log.d("Calculation","Result = "+total);

            Toast.makeText(MainActivity.this,
                    "Result = " +total,
                    Toast.LENGTH_LONG)
                    .show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mune_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
