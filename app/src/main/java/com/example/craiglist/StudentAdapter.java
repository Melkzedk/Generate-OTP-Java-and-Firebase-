package com.example.craiglist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    ArrayList<Student> Students;

    public StudentAdapter(Context c , ArrayList<Student> p)
    {
        context = c;
        Students = p;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.student_info, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.Name.setText(Students.get(position).getName());
        holder.RollNo.setText(Students.get(position).getRollNo());
        holder.AttendanceCount.setText(Students.get(position).getChemistry().toString());

    }

    @Override
    public int getItemCount() {
        return Students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView Name,RollNo,AttendanceCount;

        public StudentViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.text_view_name);
            RollNo = itemView.findViewById(R.id.text_view_rollno);
            AttendanceCount = itemView.findViewById(R.id.text_attendance_count);
        }

    }
}