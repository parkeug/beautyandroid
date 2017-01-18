package com.example.s1.beautyandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.example.s1.beautyandroid.adapter.MediaAdapter;
import com.example.s1.beautyandroid.adapter.StoreTabPagerAdapter;
import com.example.s1.beautyandroid.pojo.Media;
import com.example.s1.beautyandroid.pojo.MediaList;
import com.example.s1.beautyandroid.pojo.StoreMembership;
import com.example.s1.beautyandroid.pojo.StoreMembershipList;
import com.example.s1.beautyandroid.retrofit.ApiService;
import com.example.s1.beautyandroid.retrofit.RetroClient;
import com.example.s1.beautyandroid.utils.InternetConnection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private ArrayList<Media> mediaList;
    private ArrayList<StoreMembership> storemembershipList;
    private MediaAdapter adapter;

    private ListView listView;
    private View parentView;

    ViewPager pager;
    PagerTabStrip tab_strp;

    // private OnFragmentInteractionListener mListener;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*
        getActivity().setContentView(R.layout.storemaintab);
        StoreTabPagerAdapter pagerAdapter = new StoreTabPagerAdapter(getActivity().getSupportFragmentManager());
        pager=(ViewPager) getView().findViewById(R.id.pager);

        pager.setAdapter(pagerAdapter);
        tab_strp=(PagerTabStrip) getView().findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
        */


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of LoginFragment");

        /**
         * Array List for Binding Data from JSON to this List
         */
        mediaList = new ArrayList<>();
        storemembershipList = new ArrayList<>();
        parentView = getView().findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) getView().findViewById(R.id.listView);

        /**
         * Checking Internet Connection
         */
        if (InternetConnection.checkConnection(getActivity().getApplicationContext())) {
            final ProgressDialog dialog;
            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(getActivity());
            // dialog.setTitle(getString(R.string.string_getting_json_title));
            // dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            Call<MediaList> call = api.getMyJSON();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<MediaList>() {
                @Override
                public void onResponse(Call<MediaList> call, Response<MediaList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        mediaList = response.body().getMedias();

                        /**
                         * Binding that List to Adapter
                         */
                        adapter = new MediaAdapter(getActivity(), mediaList);
                        listView.setAdapter(adapter);

                    } else {
                        // Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<MediaList> call, Throwable t) {
                    dialog.dismiss();
                }
            });


            /*
            Call<StoreMembershipList> callStoreMembership = api.getStoreMembershipsJSON();
            callStoreMembership.enqueue(new Callback<StoreMembershipList>() {
                @Override
                public void onResponse(Call<StoreMembershipList> callStoreMembership, Response<StoreMembershipList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {
                        storemembershipList = response.body().getStoreMemberships();
                        // adapter = new MediaAdapter(getActivity(), mediaList);
                        // listView.setAdapter(adapter);
                    } else {
                        // Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<StoreMembershipList> callStoreMembership, Throwable t) {
                    dialog.dismiss();
                }
            });
            */
        }

        super.onResume();
    }
}
