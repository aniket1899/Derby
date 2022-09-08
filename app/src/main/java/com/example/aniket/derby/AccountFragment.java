package com.example.aniket.derby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AccountFragment extends Fragment {
    private List<RecyclerViewClass> recyclerViewClassList = new ArrayList<>();
    private RVAdapter adapter;
    private final static String[] accountTitle = {"Name","Email","Location","Date of Birth"};
    private String[] accountData;
    private FloatingActionButton fab;
    private SessionManager session;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_account, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab_edit_account);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditAccountActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.account_recycler_view);

        adapter = new RVAdapter(recyclerViewClassList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        session  = new SessionManager(getActivity());
        HashMap<String,String> userDetails = new HashMap<String, String>();
         userDetails = session.getUserDetails();
        String email = userDetails.get(session.KEY_EMAIL);
        String name = userDetails.get(session.KEY_NAME);
        String location = userDetails.get(session.KEY_LOCATION);
        //get location from db
        accountData=new String[]{name,email,location,"00/00/00"};
        setAccount();

        return rootView;
    }

    private void setAccount()
    {
        for(int i = 0; i < accountTitle.length;i++)
        {
            recyclerViewClassList.add(new RecyclerViewClass(accountTitle[i],accountData[i]));
        }
        adapter.notifyDataSetChanged();
    }

}
