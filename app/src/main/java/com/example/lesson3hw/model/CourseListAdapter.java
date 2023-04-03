package com.example.lesson3hw.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lesson3hw.R;

import java.util.List;


public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(@NonNull Context context, @NonNull List<Course> objects) {
       super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewElement = convertView;

        if (listViewElement == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewElement = inflater.inflate(R.layout.list_item, parent, false);
        }

        Course course = getItem(position);
        TextView textViewID = listViewElement.findViewById(R.id.course_id);
        TextView textViewName = listViewElement.findViewById(R.id.course_name);

        textViewID.setText("SWENG: "+course.getID());
        textViewName.setText("Course Name: " + course.getName());

        return listViewElement;

    }
}
