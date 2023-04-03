package com.example.lesson3hw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson3hw.R;
import com.example.lesson3hw.model.Course;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewID;
    private TextView mTextViewCredits;
    private TextView mTextViewDescription;
    private TextView mTextViewName;

    private Button mButtonPreviousActivity;
    private Button mShowCourseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mButtonPreviousActivity = findViewById(R.id.id_back_button);
        mShowCourseDetails = findViewById(R.id.show_course_details);
        mTextViewID = findViewById(R.id.course_id);
        mTextViewCredits = findViewById(R.id.course_credits);
        mTextViewDescription = findViewById(R.id.course_description);
        mTextViewName = findViewById(R.id.course_name);

        Intent intent = getIntent();
        Course selectedCourse = (Course) intent.getSerializableExtra("selectedCourse");

        mTextViewID.setText("SWENG: " + selectedCourse.getID());
        mTextViewName.setText("Name: " + selectedCourse.getName());
        mTextViewCredits.setText("Credits: " + selectedCourse.getCredits());
        mTextViewDescription.setText("Description: " + selectedCourse.getDescription());

        mButtonPreviousActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("RETURN_FROM_SECOND_ACTIVITY", true);
                startActivity(intent);

                // Reset the visibility of these items when returning to main activity
                mTextViewCredits.setVisibility(View.GONE);
                mTextViewName.setVisibility(View.GONE);
                mTextViewDescription.setVisibility(View.GONE);
                mShowCourseDetails.setEnabled(true);
            }
        });

        mShowCourseDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewName.setVisibility(View.VISIBLE);
                mTextViewCredits.setVisibility(View.VISIBLE);
                mTextViewDescription.setVisibility(View.VISIBLE);

                mShowCourseDetails.setEnabled(false);
            }
        });
    }
}