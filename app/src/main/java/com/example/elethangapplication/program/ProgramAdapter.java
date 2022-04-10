package com.example.elethangapplication.program;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elethangapplication.R;
import com.example.elethangapplication.cat.CatAdapter;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramHolder> {

    Context context;
    List<Program>programList;



    public ProgramAdapter(Context context, List<Program> programList) {
        this.context = context;
        this.programList = programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProgramAdapter.ProgramHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_programs, parent, false);
        return new ProgramHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ProgramHolder holder, int position) {
        holder.programType.setText(programList.get(position).getType());
        holder.date.setText(programList.get(position).getDate());
        holder.time.setText(programList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }
    public static class ProgramHolder extends RecyclerView.ViewHolder{
        TextView programType;
        TextView date;
        TextView time;
        Button btnjelentkezik;

        public ProgramHolder(@NonNull View itemView) {
            super(itemView);
            programType = itemView.findViewById(R.id.programType);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            btnjelentkezik = itemView.findViewById(R.id.btnjelentkezik);
        }
    }
}
