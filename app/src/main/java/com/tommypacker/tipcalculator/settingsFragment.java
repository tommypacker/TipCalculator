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

import com.tommypacker.tipcalculator.Licenses;

import java.util.List;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.License;

/**
 * Created by tommypacker on 7/25/15.
 */
public class settingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference source = findPreference("viewCode");
        source.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                viewSource();
                return false;
            }
        });

        Preference aboutApp = findPreference("appVersion");
        aboutApp.setTitle("Tip Calculator Version " + "1.0.0");

        Preference license = findPreference("licenses");
        license.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openLicensesDialog();
                return false;
            }
        });
    }

    private boolean viewSource() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://github.com/tommypacker/TipCalculator"));
        startActivity(intent);
        return true;
    }

    private boolean openLicensesDialog() {
        new LicensesDialog.Builder(getActivity())
                .setNotices(Licenses.getNotices())
                .build().show();
        return true;
    }
}
