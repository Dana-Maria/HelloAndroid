package com.example.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initText();
        addText();
    }

    private void initText()
    {
        mText = findViewById(R.id.untextbelea);
    }

    private void addText()
    {
        mText.setText("“Don’t walk in front of me… I may not follow\n" +
                "Don’t walk behind me… I may not lead\n" +
                "Walk beside me… just be my friend” \n" +
                "― Albert Camus\n" +
                "“Don’t walk in front of me… I may not follow\n" +
                "Don’t walk behind me… I may not lead\n" +
                "Walk beside me… just be my friend” \n" +
                "― Albert Camus" +
                "“Don’t walk in front of me… I may not follow\n" +
                "Don’t walk behind me… I may not lead\n" +
                "Walk beside me… just be my friend” \n" +
                "― Albert Camus" +
                "“Don’t walk in front of me… I may not follow\n" +
                "Don’t walk behind me… I may not lead\n" +
                "Walk beside me… just be my friend” \n" +
                "― Albert Camus");
    }

}
