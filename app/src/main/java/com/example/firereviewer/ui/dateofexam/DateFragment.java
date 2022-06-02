package com.example.firereviewer.ui.dateofexam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.allyants.notifyme.NotifyMe;
import com.example.firereviewer.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class DateFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    //GALLERY IS REVIEWER
    //SLIDESHOW IS EXAM SIMULATOR
    Activity context;

    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd;
    DatePickerDialog dpd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.date_fragment, container, false);
        context = getActivity();

        Button btnSchedule = root.findViewById(R.id.btnDateSchedule);
        Button btnCancel = root.findViewById(R.id.btnDateCancel);

        dpd = DatePickerDialog.newInstance(this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));

        tpd = TimePickerDialog.newInstance(this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotifyMe.cancel(context,"test");
                Toast.makeText(context, "Scheduled notification is cancelled!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpd.show(getFragmentManager(),"Datepickerdialog");
            }
        });
        return root;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        now.set(Calendar.YEAR, year);
        now.set(Calendar.MONTH, monthOfYear);
        now.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        tpd.show(getFragmentManager(),"Timepickerdialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        now.set(Calendar.HOUR_OF_DAY, hourOfDay);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, second);

        NotifyMe notifyMe = new NotifyMe.Builder(context)
                .title("Board Examination")
                .content("Board examination is coming soon. Please get ready!")
                .color(255, 0, 0, 255)
                .led_color(255, 255, 255,255)
                .time(now)
                .key("test")
                .addAction(new Intent(),"Done")
                .large_icon(R.mipmap.ic_launcher_round)
                .build();
        Toast.makeText(context, "Notification is scheduled!", Toast.LENGTH_SHORT).show();
    }
}