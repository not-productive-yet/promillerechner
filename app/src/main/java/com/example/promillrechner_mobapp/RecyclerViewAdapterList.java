package com.example.promillrechner_mobapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapterList extends RecyclerView.Adapter<RecyclerViewAdapterList.ViewHolder> implements View.OnClickListener {
    private List<data_person> persons = Collections.emptyList();

    Context mContext;
    private data_person_dao dao;
    RecyclerViewAdapterList(Context context){
        mContext =context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_person_list_item, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerViewAdapterList.ViewHolder(view);
        return new RecyclerViewAdapterList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterList.ViewHolder holder, final int position) {
        dao = data_person_room_database.getDatabase(mContext).person_dao();

        TextView textName = holder.itemView.findViewById(R.id.textName1);
        textName.setText(persons.get(position).getName());

        holder.parentLayout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), Database_person_edit.class);
        v.getContext().startActivity(intent);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textName1);
            parentLayout = itemView.findViewById(R.id.parentLayoutList);
        }
    }
    public void setPersons(List<data_person> persons){
        this.persons = persons;
        notifyDataSetChanged();
    }


}