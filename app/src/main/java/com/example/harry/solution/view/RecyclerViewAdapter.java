package com.example.harry.solution.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.harry.solution.R;
import com.example.harry.solution.model.Forecast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Forecast> items;

    public RecyclerViewAdapter(List<Forecast> items) {
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewDate.setText(String.format(holder.view.getContext().getString(R.string.date), items.get(position).getDate()));
        holder.textViewHigh.setText(String.format(holder.view.getContext().getString(R.string.high), items.get(position).getHigh()));
        holder.textViewLow.setText(String.format(holder.view.getContext().getString(R.string.low), items.get(position).getLow()));
        holder.textViewText.setText(String.format(holder.view.getContext().getString(R.string.description), items.get(position).getText()));
        holder.itemView.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewDate, textViewHigh, textViewLow, textViewText;
        private View view;

        MyViewHolder(View view) {
            super(view);
            this.view = view;
            textViewDate = view.findViewById(R.id.textView_date);
            textViewHigh = view.findViewById(R.id.textView_high);
            textViewLow = view.findViewById(R.id.textView_low);
            textViewText = view.findViewById(R.id.textView_text);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
