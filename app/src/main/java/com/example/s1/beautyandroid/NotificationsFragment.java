package com.example.s1.beautyandroid;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.s1.beautyandroid.adapter.MediaAdapter;
import com.example.s1.beautyandroid.pojo.MediaList;
import com.example.s1.beautyandroid.retrofit.ApiService;
import com.example.s1.beautyandroid.retrofit.RetroClient;
import com.example.s1.beautyandroid.utils.InternetConnection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationsFragment extends Fragment {

    // private OnFragmentInteractionListener mListener;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of LoginFragment");

        /*
        mediaList = new ArrayList<>();
        storemembershipList = new ArrayList<>();
        parentView = getView().findViewById(R.id.parentLayout);
        listView = (ListView) getView().findViewById(R.id.listView);

        if (InternetConnection.checkConnection(getActivity().getApplicationContext())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog(getActivity());
            // dialog.setTitle(getString(R.string.string_getting_json_title));
            // dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            Call<MediaList> call = api.getMyJSON();
            call.enqueue(new Callback<MediaList>() {
                @Override
                public void onResponse(Call<MediaList> call, Response<MediaList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {
                        mediaList = response.body().getMedias();
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
        }
        */

        super.onResume();
    }
}
