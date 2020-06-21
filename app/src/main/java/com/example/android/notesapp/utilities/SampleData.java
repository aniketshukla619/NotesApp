package com.example.android.notesapp.utilities;

import com.example.android.notesapp.database.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {

    private static final String SAMPLE_TEXT_1 = "A Simple Note";
    private static final String SAMPLE_TEXT_2 = "A note with a\nline feed";
    private static final String SAMPLE_TEXT_3 = "CentOS is an Enterprise-class Linux Distribution derived from sources freely provided to the public by Red Hat, Inc. for Red Hat Enterprise Linux. CentOS conforms fully with the upstream vendors redistribution policy and aims to be functionally compatible. (CentOS mainly changes packages to remove upstream vendor branding and artwork.\n\n" +
            "CentOS is developed by a small but growing team of core developers.  In turn the core developers are supported by an active user community including system administrators, network administrators, enterprise users, managers, core Linux contributors and Linux enthusiasts from around the world.";


    private static Date getDate(int diff) {
        Calendar cal = new GregorianCalendar();
            cal.add(Calendar.MILLISECOND, diff);
            return cal.getTime();

        }

    public static List<NoteEntity> getNotes() {
        List<NoteEntity> notes = new ArrayList<>();
        notes.add(new NoteEntity(getDate(0),SAMPLE_TEXT_1));
        notes.add(new NoteEntity(getDate(-1),SAMPLE_TEXT_2));
        notes.add(new NoteEntity(getDate(-2),SAMPLE_TEXT_3));
        return notes;

    }
    }
