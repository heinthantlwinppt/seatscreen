package com.test.hein.seatscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class homescreenactivity extends AppCompatActivity {
    RelativeLayout dateSelectLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        dateSelectLayout = (RelativeLayout) findViewById(R.id.dateSelectLayout);

        dateSelectLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderviewDialog calenderviewDialog = new CalenderviewDialog();
                calenderviewDialog.show(getSupportFragmentManager(),"Calendar");
            }
        });
    }
}
