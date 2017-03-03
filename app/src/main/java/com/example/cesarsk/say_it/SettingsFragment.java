package com.example.cesarsk.say_it;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import static com.example.cesarsk.say_it.MainActivity.american_speaker_google;
import static com.example.cesarsk.say_it.MainActivity.voice_american_female;
import static com.example.cesarsk.say_it.MainActivity.voice_british_female;
import static com.example.cesarsk.say_it.Utility.rateUs;
import static com.example.cesarsk.say_it.Utility.shareToMail;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private String emails[] = {"luca.cesarano1@gmail.com"};
    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_settings,
                container, false);

        Button contact_us = (Button) view.findViewById(R.id.contact_us);
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareToMail(emails, "[CONTACT US - SAY IT!]", getActivity());
            }
        });

        Button bug_report = (Button) view.findViewById(R.id.bug_report);
        bug_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareToMail(emails, "[BUG REPORT - SAY IT!]", getActivity());
            }
        });

        Button rate_us = (Button) view.findViewById(R.id.rate_us);
        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateUs(getActivity());
            }
        });

        final Spinner default_voice = (Spinner) view.findViewById((R.id.default_voice));

        //Spinner default voice
        default_voice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO GESTIRE DEFAULT VOICE ALL'AVVIO
                if (default_voice.getSelectedItem().toString().compareTo("British English") == 0) american_speaker_google.setVoice(voice_british_female);
                else if(default_voice.getSelectedItem().toString().compareTo("American English") == 0) american_speaker_google.setVoice(voice_american_female);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }




}