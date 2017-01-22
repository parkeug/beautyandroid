package com.example.s1.beautyandroid;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s1.beautyandroid.adapter.StoreMembershipAdapter;
import com.example.s1.beautyandroid.pojo.StoreMembership;
import com.example.s1.beautyandroid.pojo.StoreMembershipList;
import com.example.s1.beautyandroid.retrofit.ApiService;
import com.example.s1.beautyandroid.retrofit.RetroClient;
import com.example.s1.beautyandroid.utils.InternetConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by s1 on 1/21/2017.
 */

public class StoreMembershipFragment extends Fragment {
    private long storemembershipid = 0;

    public StoreMembershipFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_storemembership, container, false);

        Bundle bundle = getArguments();
        storemembershipid = bundle.getLong("storemembershipid");

        Button button = (Button) view.findViewById(R.id.schedulebutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragment = new ScheduleFragment();
                Bundle bundle = new Bundle();
                bundle.putLong("storemembershipid", storemembershipid);
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of LoginFragment");

        Bundle bundle = getArguments();
        long storemembershipid = bundle.getLong("storemembershipid") ;

        Toast.makeText(getActivity().getApplicationContext(), "Your message " + storemembershipid, Toast.LENGTH_LONG).show();

        if (InternetConnection.checkConnection(getActivity().getApplicationContext())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog(getActivity());
            dialog.show();
            ApiService api = RetroClient.getApiService();
            Call<StoreMembership> callStoreMembership = api.getStoreMembershipJSON(storemembershipid);
            callStoreMembership.enqueue(new Callback<StoreMembership>() {
                @Override
                public void onResponse(Call<StoreMembership> callStoreMembership, Response<StoreMembership> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if (response.isSuccessful()) {
                        TextView storeTitleTextView = (TextView) getView().findViewById(R.id.storetitle_textview);
                        storeTitleTextView.setText(response.body().getTitle());

                        TextView storeAddressTextView = (TextView) getView().findViewById(R.id.storeaddress_textview);
                        storeAddressTextView.setText(response.body().getAddress());

                        TextView storeAddress2TextView = (TextView) getView().findViewById(R.id.storeaddress2_textview);
                        storeAddress2TextView.setText(response.body().getAddress2());


                    } else {
                        // Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<StoreMembership> callStoreMembership, Throwable t) {
                    dialog.dismiss();
                }
            });
        }


        super.onResume();
    }
}
