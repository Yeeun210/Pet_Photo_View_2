package com.cookandroid.project7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnView;
    ImageView imgPet;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Exercise7_6");

        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton)findViewById(R.id.RdoDog);
        rdoCat = (RadioButton)findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton)findViewById(R.id.RdoRabbit);

        btnView = (Button)findViewById(R.id.BtnView);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView=(View)View.inflate(MainActivity.this, R.layout.dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder((MainActivity.this));
                dlg.setIcon(R.drawable.ic_baseline_group_24);
                dlg.setView(dialogView);
                imgPet = (ImageView) dialogView.findViewById(R.id.ImgPet);
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        dlg.setTitle("강아지");
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoCat:
                        dlg.setTitle("고양이");
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        dlg.setTitle("토끼");
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                }
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View)View.inflate(MainActivity.this,R.layout.toast1,null);
                        toastText = (TextView)toastView.findViewById(R.id.toastText1);
                        toastText.setText("대화상자를 닫았습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });



    }
}