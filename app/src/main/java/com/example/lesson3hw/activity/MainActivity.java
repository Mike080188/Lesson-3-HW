package com.example.lesson3hw.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lesson3hw.R;
import com.example.lesson3hw.activity.SecondActivity;
import com.example.lesson3hw.model.Course;
import com.example.lesson3hw.model.CourseListAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListViewCourses;
    private CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Course> courses = loadCoursesInfo();
        courseListAdapter = new CourseListAdapter(MainActivity.this, courses);

        mListViewCourses = findViewById(R.id.listview_courses);
        mListViewCourses.setAdapter(courseListAdapter);
        mListViewCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Course selectedCourse = (Course) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("selectedCourse", selectedCourse);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Course> loadCoursesInfo(){

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(888, 3, getResources().getString(R.string.sweng888_description), "Mobile Computing"));
        courses.add(new Course(894, 6, getResources().getString(R.string.sweng894_description), "Capstone"));
        courses.add(new Course(861, 3, getResources().getString(R.string.sweng861_description), "Software Construction"));
        courses.add(new Course(837, 3, getResources().getString(R.string.sweng837_description), "Software Systems Architecture"));
        courses.add(new Course(587, 3, getResources().getString(R.string.sweng587_description), "Software Systems Design"));

        return courses;
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean returnFromSecondActivity = getIntent().getBooleanExtra("RETURN_FROM_SECOND_ACTIVITY", false);

        if (returnFromSecondActivity) {
            LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);
            Snackbar snackbar = Snackbar.make(mainLayout,"Operation successful",Snackbar.LENGTH_LONG)
                    .setDuration(5000)
                    .setTextColor(getResources().getColor(R.color.green));
            snackbar.show();
        }
    }
}