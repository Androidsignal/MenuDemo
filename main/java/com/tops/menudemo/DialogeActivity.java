package com.tops.menudemo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogeActivity extends AppCompatActivity {

    TextView txtTime, txtDate;
    Calendar calendar;

    @Override
    protected void onCreate(    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialoge);

        txtTime = (TextView) findViewById(R.id.txtTime);
        txtDate = (TextView) findViewById(R.id.txtDate);
        calendar = Calendar.getInstance();
    }

    public void onClick(View view) {

        if (view.getId() == R.id.btnAlert) {
            AlertDialog.Builder alert = new AlertDialog.Builder(DialogeActivity.this);
            alert.setTitle("Delete?");
            alert.setMessage("Are u sure watn to delete?");

            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(DialogeActivity.this, "You press the Yes Button...", Toast.LENGTH_SHORT).show();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(DialogeActivity.this, "You press the No Button...", Toast.LENGTH_SHORT).show();
                }
            });

            alert.setNeutralButton("Ok", null);
            alert.show();
        } 
	else if (view.getId() == R.id.btnTime) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(DialogeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    txtTime.setText("You set the time is = " + i + ":" + i1);
                }
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
            timePickerDialog.show();
        } 
	else if (view.getId() == R.id.btnDate) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(DialogeActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    txtDate.setText("You set date is : " + i2 + "/" + (i1+1) + "/" + i);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
	 else if (view.getId() == R.id.btnProgress) {
            ProgressDialog progressDialog = new ProgressDialog(DialogeActivity.this);
            progressDialog.setTitle("Wait");
            progressDialog.setMessage("Data is Loading...");
            progressDialog.show();
        }
    }
}
