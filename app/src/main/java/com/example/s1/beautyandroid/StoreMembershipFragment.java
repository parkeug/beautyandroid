package com.example.s1.beautyandroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by s1 on 1/21/2017.
 */

public class StoreMembershipFragment extends Fragment {
    public StoreMembershipFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_storemembership, container, false);

        Button button = (Button) view.findViewById(R.id.schedulebutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragment = new ScheduleFragment();
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


        super.onResume();
    }
}
