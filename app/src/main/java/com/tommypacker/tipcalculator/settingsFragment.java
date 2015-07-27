package com.tommypacker.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import java.util.List;

/**
 * Created by tommypacker on 7/25/15.
 */
public class settingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference aboutApp = findPreference("appVersion");
        Preference source = findPreference("viewCode");
        source.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(  Preference preference) {
                viewSource();
                return false;
            }
        });

        aboutApp.setTitle("Tip Calculator Version " + "1.0.0");
    }

    private boolean viewSource() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://github.com/tommypacker/TipCalculator"));
        startActivity(intent);
        return true;
    }
}
