package com.tommypacker.tipcalculator;

import java.util.Arrays;
import java.util.List;

import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
/**
 * Created by tommypacker on 7/26/15.
 */
public class Licenses {
    private static Notices notices = new Notices();

    public static final List<Notice> NOTICE_LIST = Arrays.asList(
            new Notice(
                    "Android Support Library",
                    "http://developer.android.com/tools/support-library/",
                    "Copyright (C) 2011 The Android Open Source Project",
                    new ApacheSoftwareLicense20()
            ),

            new Notice(
                    "LicensesDialog",
                    "http://psdev.de",
                    "Copyright 2013 Philip Schiffer <admin@psdev.de>",
                    new ApacheSoftwareLicense20()
            )
    );

    public static Notices getNotices() {
        for (Notice notice : NOTICE_LIST) notices.addNotice(notice);
        return notices;
    }

}
