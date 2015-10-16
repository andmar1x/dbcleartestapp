package io.andmar1x.dbcleartestapp.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseModule {

    private static final List<Class<? extends BaseModel>> TABLES = new ArrayList<>(Arrays.asList(
            ModelOne.class,
            ModelTwo.class,
            ModelThree.class,
            ModelFour.class
    ));

    public static void init(@NonNull Context context) {
        FlowManager.init(context.getApplicationContext());
    }

    public static void destroy(@NonNull Context context) {
        FlowManager.destroy();
        reflectionHack(context.getApplicationContext());
    }

    public static void clearTables() {
        for (Class table : TABLES) {
            Delete.table(table);
        }
    }

    public static boolean deleteDatabase(@NonNull Context context) {
        destroy(context);
        String databaseName = getDatabaseFullName();
        return context.deleteDatabase(databaseName) && !exists(context);
    }

    public static boolean exists(@NonNull Context context) {
        try {
            File dbFile = context.getApplicationContext().getDatabasePath(getDatabaseFullName());
            return dbFile.exists();
        } catch (Exception exception) {
            return false;
        }
    }

    @NonNull
    private static String getDatabaseFullName() {
        return Database.NAME + ".db";
    }

    private static void reflectionHack(@NonNull Context context) {
        try {
            Field field = FlowManager.class.getDeclaredField("mDatabaseHolder");
            setFinalStatic(field, null);
        } catch (NoSuchFieldException noSuchField) {
            noSuchField.printStackTrace();
        } catch (IllegalAccessException illegalAccess) {
            illegalAccess.printStackTrace();
        }

        init(context);
    }

    private static void setFinalStatic(@NonNull Field field, @Nullable Object newValue)
            throws IllegalAccessException {
        field.setAccessible(true);
        field.set(null, newValue);
    }
}
