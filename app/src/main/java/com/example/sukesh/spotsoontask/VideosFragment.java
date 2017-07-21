package com.example.sukesh.spotsoontask;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class VideosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
   String url[]={"https://2.bp.blogspot.com/-svDvqdfbML0/V955MYGN2nI/AAAAAAAANx0/eXAp598Lk7QbSdfR_7IuXAxKBCKDtag5ACLcB/s1600/Pankhida%2BO%2BPankhida%2B%2528Garba%2BSongs%2529.jpg",
   "https://pbs.twimg.com/profile_images/378800000107147378/58a374912acb476365160fd8f3b5cd94_400x400.jpeg",
   "http://vritesh.com/wp-content/uploads/2011/09/best-websites-for-downloading-english-songs.jpg"};
    String name[]={"Emptiness ft justin beaker","I'm falling in love with u","Baby ft Justin Baber"};
    String details[]={"Lorem Ipsum is simply dummy text of the printing and typesetting industry.","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry."};

    private Config config;

    public VideosFragment() {
        // Required empty public constructor
    }

   // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_videos, container, false);
        // Inflate the layout for this fragment
        recyclerView =(RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new CardAdapter(url,name,details,getActivity());
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return view;
    }




}
