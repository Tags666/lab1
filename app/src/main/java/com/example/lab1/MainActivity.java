package com.example.lab1;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;



import butterknife.BindView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText editText;
    Button button;
    TextView textView;
    Button buttonClick;
    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;
    Button infoToast;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnRemove)
    Button btnRemove;
    @BindView(R.id.btnReplace)
    Button btnReplace;
    @BindView(R.id.chbStack)
    CheckBox chbStack;
    @BindView(R.id.frgmCont)
    FrameLayout frgmCont;
    @BindView(R.id.LinearLayout1)
    LinearLayout LinearLayout1;
    @BindView(R.id.btnInfoToast)
    Button btnToast;
    @BindView(R.id.btn)
    Button btn;


    Button mCrowsCounterButton;
    TextView mInfoTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edittext);
        button=(Button)findViewById(R.id.btn);

        textView=(TextView)findViewById(R.id.textView);
        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        buttonClick = (Button) findViewById(R.id.btnInfoToast);
        infoToast = findViewById(R.id.btnInfoToast);
        buttonClick = (Button) findViewById(R.id.btnInfoToast);
        buttonClick.setOnClickListener(this);
        infoToast.setOnClickListener(this);
        button.setOnClickListener(this);

frag1 = new Fragment1();
        frag2 = new Fragment2();

        chbStack = (CheckBox) findViewById(R.id.chbStack);


    }

    public void onClick(View v) {

        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn:

                String value=editText.getText().toString();

                textView.setText("Ваш текст "+value);

               Toast.makeText(this,"Результат "+value,Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnAdd:

                fTrans.add(R.id.frgmCont, frag1);
                break;
            case R.id.btnRemove:
                fTrans.remove(frag1);
                break;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, frag2);
            default:
                break;

            case R.id.btnInfoToast:
                Toast toast = Toast.makeText(getApplicationContext(),"Показать мое сообщение Toast",Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.buttonBack:
                Intent i;

                i = new Intent(this, BackActivity.class);

                startActivity(i);



                break;


        }
        if (chbStack.isChecked()) fTrans.addToBackStack(null);
        fTrans.commit();





        }

        }