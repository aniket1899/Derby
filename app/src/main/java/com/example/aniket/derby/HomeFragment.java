package com.example.aniket.derby;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    public HomeFragment() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

                getActivity().setTitle("Home");
        CardView cardChallenge = (CardView) rootView.findViewById(R.id.card_view_Challenge_a_team);
        CardView cardPutChallenge = (CardView) rootView.findViewById(R.id.card_view_put_a_challenge);
        CardView cardSearch = (CardView) rootView.findViewById(R.id.card_view_Search_team);
        CardView cardBook = (CardView) rootView.findViewById(R.id.card_view_Book_turf_slots);
        CardView cardEvents = (CardView) rootView.findViewById(R.id.card_view_Events);

        cardChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Manage preferences?")
                .setIcon(R.drawable.ic_edit_black_24dp)
                .setMessage("Do you want to manage your Preferences before finding a Challenge?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getActivity(),ManagePreferences.class));
                    }
                })
                        .setNegativeButton("Proceed anyway", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(getActivity(),ChallengeInitialActivity.class));
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
*/
                startActivity(new Intent(getActivity(),ChallengeInitialActivity.class));

            }
        });

        cardPutChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),PutChallengeInitialActivity.class));
            }
        });

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Search");
            }
        });

        cardBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Book");
            }
        });

        cardEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Events");
            }
        });
        return rootView;
    }

    protected void toast(String text)
    {
        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
    }

}
