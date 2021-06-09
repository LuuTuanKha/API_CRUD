package com.example.testapiktth;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView name, clazz, diem;
    Button btnEdit, btnDelete;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.item_Name);
        clazz = itemView.findViewById(R.id.item_Class);
        diem = itemView.findViewById(R.id.item_Point);

        btnEdit = itemView.findViewById(R.id.item_btn_edit);
        btnDelete = itemView.findViewById(R.id.item_btn_delete);
    }
}