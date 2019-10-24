package com.e.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Update extends AppCompatActivity {

    TextView mTv;
    Button mBtn;

    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mTv=(TextView)findViewById(R.id.txtDate);
        mBtn=(Button)findViewById(R.id.btnPick);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c=Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                dpd= new DatePickerDialog(Update.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTv.setText(mDay+"/"+mMonth+"/"+mYear+"/");
                    }
                }, year, month, day);
                dpd.show();

            }
        });

    }
}
