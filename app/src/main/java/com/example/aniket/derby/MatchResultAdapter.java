package com.example.aniket.derby;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Aniket on 10/04/17.
 */

public class MatchResultAdapter extends RecyclerView.Adapter<MatchResultAdapter.MatchResultAdapterViewHolder> {

    private Context context;
    private List<ChallengerMatchResult> resultList;

    public class MatchResultAdapterViewHolder extends RecyclerView.ViewHolder
    {
        public TextView matchResultName;
        public TextView matchResultStartTime;
        public TextView matchResultEndTime;
        public TextView matchResultDays;
        public TextView matchResultLocation;
        public TextView matchResultLevel;
        public TextView matchResultTurf1;
        public TextView matchResultTurf2;
        public TextView matchResultTurf3;
        public TextView matchResultTurf4;
        public TextView matchResultTurf5;
        public Button matchResultButtonAccept;

        public MatchResultAdapterViewHolder(View itemView) {
            super(itemView);

            matchResultName = (TextView) itemView.findViewById(R.id.card_view_match_result_name);
            matchResultStartTime = (TextView) itemView.findViewById(R.id.card_view_match_result_start_time);
            matchResultEndTime = (TextView) itemView.findViewById(R.id.card_view_match_result_end_time);
            matchResultLocation = (TextView) itemView.findViewById(R.id.card_view_match_result_location);
            matchResultLevel = (TextView) itemView.findViewById(R.id.card_view_match_result_level);
            matchResultDays = (TextView) itemView.findViewById(R.id.card_view_match_result_days);
            matchResultTurf1 = (TextView) itemView.findViewById(R.id.card_view_match_result_turf1);
            matchResultTurf2 = (TextView) itemView.findViewById(R.id.card_view_match_result_turf2);
            matchResultTurf3 = (TextView) itemView.findViewById(R.id.card_view_match_result_turf3);
            matchResultTurf4 = (TextView) itemView.findViewById(R.id.card_view_match_result_turf4);
            matchResultTurf5 = (TextView) itemView.findViewById(R.id.card_view_match_result_turf5);

            matchResultButtonAccept = (Button) itemView.findViewById(R.id.card_view_match_result_button_accept);

        }
    }
    public MatchResultAdapter(Context context, List<ChallengerMatchResult> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @Override
    public MatchResultAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_match_result,parent,false);
        return new MatchResultAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MatchResultAdapterViewHolder holder, int position) {
    final ChallengerMatchResult result = resultList.get(position);
        holder.matchResultName.setText(result.getName());
        holder.matchResultStartTime.setText(result.getStart_time());
        holder.matchResultEndTime.setText(result.getEnd_time());
        holder.matchResultLocation.setText(result.getLocation());
        holder.matchResultLevel.setText(result.getLevel());
        holder.matchResultDays.setText(result.getDays());
        holder.matchResultTurf1.setText(result.getTurf1());
        holder.matchResultTurf2.setText(result.getTurf2());
        holder.matchResultTurf3.setText(result.getTurf3());
        holder.matchResultTurf4.setText(result.getTurf4());
        holder.matchResultTurf5.setText(result.getTurf5());
        final String id = result.getID();
        holder.matchResultButtonAccept.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,id,Toast.LENGTH_SHORT).show();
                    }

                }
        );
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }



}
