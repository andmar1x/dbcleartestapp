package io.andmar1x.dbcleartestapp.data;

@com.raizlabs.android.dbflow.annotation.Database(name = Database.NAME, version = Database.VERSION,
        foreignKeysSupported = true)
public class Database {

    /**
     * Database name.
     */
    public static final String NAME = "Test";

    /**
     * Database version.
     */
    public static final int VERSION = 1;
}
