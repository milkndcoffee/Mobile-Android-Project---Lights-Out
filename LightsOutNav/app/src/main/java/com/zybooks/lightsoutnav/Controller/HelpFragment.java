package com.zybooks.lightsoutnav.Controller;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zybooks.lightsoutnav.R;

public class HelpFragment extends Fragment {
    private Button mActivityCallButton;
    private Button mActivityMapButton;
    private Button mActivityAppButton1;
    private Button mActivityAppButton2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        mActivityCallButton = view.findViewById(R.id.activityCallButton);
        mActivityMapButton = view.findViewById(R.id.activityMapButton);
        mActivityAppButton1 = view.findViewById(R.id.activityAppButton);
        mActivityAppButton2 = view.findViewById(R.id.activityAppButton2);

        mActivityCallButton.setOnClickListener(this::onActivityCallClick);
        mActivityMapButton.setOnClickListener(this::onActivityMapClick);
        mActivityAppButton1.setOnClickListener(this::onActivityAppClick);
        mActivityAppButton2.setOnClickListener(this::onActivityApp2Click);

        return view;
    }

    /*
      Implicit Intents
   */
    public void onActivityCallClick(View view){
        Uri phoneNumber = Uri.parse("tel:111-222-3333");
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intent);
    }
    public void onActivityMapClick(View view){
        Uri location = Uri.parse("geo:0,0?q=U.S.+Department+of+Energy");
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


    public void onActivityAppClick(View view) {
        Context context = getActivity();

        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.zybooks.diceroller");
        if (launchIntent != null) {
            context.startActivity(launchIntent);
        } else {
            Toast.makeText(context, "Package not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityApp2Click(View view) {
        Context context = getActivity();

        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.milkndcoffee.st4rw4rs4pp");
        if (launchIntent != null) {
            context.startActivity(launchIntent);
        } else {
            Toast.makeText(context, "Package not found", Toast.LENGTH_SHORT).show();
        }
    }


}