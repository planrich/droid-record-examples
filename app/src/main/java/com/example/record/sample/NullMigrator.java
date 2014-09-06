package com.example.record.sample;

import android.database.sqlite.SQLiteDatabase;

import at.pasra.record.DataMigrator;


/**
 * Created by rich on 9/22/13.
 */
public class NullMigrator implements DataMigrator {

    @Override
    public void migrate(SQLiteDatabase database, long current, long target) {
        // do nothing!!!
    }

}
