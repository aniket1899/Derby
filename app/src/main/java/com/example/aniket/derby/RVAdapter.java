package com.example.aniket.derby;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aniket on 04/03/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private List<RecyclerViewClass> recyclerViewClassList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.recycler_view_title);
            subtitle = (TextView) itemView.findViewById(R.id.recycler_view_sub_title);
        }
    }
        public RVAdapter(List<RecyclerViewClass> recyclerViewClassList)
        {
            this.recyclerViewClassList = recyclerViewClassList;
        }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerViewClass recyclerViewClass = recyclerViewClassList.get(position);
        holder.title.setText(recyclerViewClass.getTitle());
        holder.subtitle.setText(recyclerViewClass.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return recyclerViewClassList.size();
    }
}
