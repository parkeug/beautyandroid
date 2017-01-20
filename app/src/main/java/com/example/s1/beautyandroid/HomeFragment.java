package com.example.s1.beautyandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.example.s1.beautyandroid.adapter.MediaAdapter;
import com.example.s1.beautyandroid.adapter.StoreMembershipAdapter;
import com.example.s1.beautyandroid.adapter.StoreTabPagerAdapter;
import com.example.s1.beautyandroid.pojo.Media;
import com.example.s1.beautyandroid.pojo.MediaList;
import com.example.s1.beautyandroid.pojo.StoreMembership;
import com.example.s1.beautyandroid.pojo.StoreMembershipList;
import com.example.s1.beautyandroid.retrofit.ApiService;
import com.example.s1.beautyandroid.retrofit.RetroClient;
import com.example.s1.beautyandroid.utils.InternetConnection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    // private ArrayList<Media> mediaList;
    // private MediaAdapter adapter;
    private ArrayList<StoreMembership> storemembershipList;
    private StoreMembershipAdapter adapter;

    private ListView listView;
    private View parentView;


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
        // tab_strp.setTextColor(Color.WHITE);
        */

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of LoginFragment");

        /**
         * Array List for Binding Data from JSON to this List
         */
        // mediaList = new ArrayList<>();
        storemembershipList = new ArrayList<>();
        parentView = getView().findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) getView().findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: handle row clicks here
                StoreMembership storeMembership = (StoreMembership) parent.getItemAtPosition(position);
                // Toast.makeText(getContext(), storeMembership.getCardimage(), Toast.LENGTH_LONG);

                Fragment fragment = new StoreMembershipFragment();
                Bundle bundle = new Bundle();
                bundle.putLong("storemembershipid", storeMembership.getId());
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

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
            Call<StoreMembershipList> callStoreMembership = api.getStoreMembershipsJSON();
            callStoreMembership.enqueue(new Callback<StoreMembershipList>() {
                @Override
                public void onResponse(Call<StoreMembershipList> callStoreMembership, Response<StoreMembershipList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {
                        storemembershipList = response.body().getStoreMemberships();
                        adapter = new StoreMembershipAdapter(getActivity(), storemembershipList);
                        listView.setAdapter(adapter);
                    } else {
                        // Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<StoreMembershipList> callStoreMembership, Throwable t) {
                    dialog.dismiss();
                }
            });
        }

        super.onResume();
    }
}
