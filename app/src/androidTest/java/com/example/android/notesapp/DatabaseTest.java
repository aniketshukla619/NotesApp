package com.example.android.notesapp;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.android.notesapp.database.AppDatabase;
import com.example.android.notesapp.database.NoteDao;
import com.example.android.notesapp.database.NoteEntity;
import com.example.android.notesapp.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mDB;
    private NoteDao mDao;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getTargetContext();
        mDB = Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        mDao = mDB.noteDao();
        Log.i(TAG,"createDb");

    }

    @After
    public void closeDb(){
        mDB.close();
        Log.i(TAG,"closeDb");

    }



    @Test
    public void createAndRetrieveNotes(){

        mDao.insertAll(SampleData.getNotes());
        int count = mDao.getCount();
        Log.i(TAG, "createAndRetrieveNotes: count=" + count);
        assertEquals(SampleData.getNotes().size(),count);
    }

    @Test
    public void compareStrings(){

        mDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity fromDb = mDao.getNoteById(1);
        assertEquals(original.getText(), fromDb.getText());
        assertEquals(1,fromDb.getId());
    }

}
