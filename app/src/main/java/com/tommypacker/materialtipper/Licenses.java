/*
 * Copyright 2015 Tommy Yu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tommypacker.materialtipper;

import java.util.Arrays;
import java.util.List;

import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

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
