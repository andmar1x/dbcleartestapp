package io.andmar1x.dbcleartestapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.TransactionManager;

import java.util.Random;

import io.andmar1x.dbcleartestapp.data.Database;
import io.andmar1x.dbcleartestapp.data.DatabaseModule;
import io.andmar1x.dbcleartestapp.data.ModelFive;
import io.andmar1x.dbcleartestapp.data.ModelFour;
import io.andmar1x.dbcleartestapp.data.ModelOne;
import io.andmar1x.dbcleartestapp.data.ModelSix;
import io.andmar1x.dbcleartestapp.data.ModelThree;
import io.andmar1x.dbcleartestapp.data.ModelTwo;
import io.andmar1x.dbcleartestapp.utils.Calculator;
import io.andmar1x.dbcleartestapp.utils.TimingLogger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String STRING_VAL = "sdfhksldsdifyhosfhsdofhsdjkfgfgsdhkgfsadjfhskd" +
            "fgskdhsojili,jiojiojuiojuihiuijupjlu9h0u0u9ju9iji0ojkjio0kio0j89hu89ijkio0ki90j" +
            "hu89h09h798gh07898j89j7890h07j897890jh9ju890h78hju90h";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        long count3 = 40;
        long count6 = 4;

        Calculator aCalculator = new Calculator();
        for (int j = 1; j <= 5; ++j) {
            Calculator.Case aCase = new Calculator.Case();
            for (int i = 1; i <= 5; ++i) {

                Calculator.Attempt anAttempt = new Calculator.Attempt();
                anAttempt.count3 = count3;
                anAttempt.count6 = count6;

                anAttempt.start = SystemClock.elapsedRealtime();

                TimingLogger timings = new TimingLogger(TAG, "Database clear test. attempt=" + i + "; case=" + j);

                fillDatabase(count3, count6);

                anAttempt.fill1 = timings.addSplit("Fill database: count3=" + count3 + "; count6=" + count6);

                DatabaseModule.clearTables();

                anAttempt.method1 = timings.addSplit("Clear only tables");

                fillDatabase(count3, count6);

                anAttempt.fill2 = timings.addSplit("Fill database: count3=" + count3 + "; count6=" + count6);

                DatabaseModule.deleteDatabase(this);
                FlowManager.getDatabase(Database.NAME).getWritableDatabase();

                anAttempt.method2 = timings.addSplit("Delete database");

                timings.dumpToLog();

                aCase.attempts.add(anAttempt);
            }

            count3 *= j;
            count6 *= j;

            aCalculator.cases.add(aCase);
        }

        aCalculator.dump();
    }

    private void fillDatabase(final long count3, final long count6) {
        final Random random = new Random();
        TransactionManager.transact(Database.NAME, new Runnable() {
            @Override
            public void run() {
                ModelFive modelFive = new ModelFive();
                modelFive.bool1 = random.nextBoolean();
                modelFive.bool2 = random.nextBoolean();
                modelFive.bool3 = random.nextBoolean();
                modelFive.bool4 = random.nextBoolean();
                modelFive.bool5 = random.nextBoolean();
                modelFive.bool6 = random.nextBoolean();
                modelFive.bool7 = random.nextBoolean();
                modelFive.long2 = random.nextLong();
                modelFive.long3 = random.nextLong();
                modelFive.long4 = random.nextLong();
                modelFive.long5 = random.nextLong();
                modelFive.long6 = random.nextLong();
                modelFive.long7 = random.nextLong();
                modelFive.long8 = random.nextLong();
                modelFive.long9 = random.nextLong();
                modelFive.str1 = STRING_VAL;
                modelFive.str2 = STRING_VAL;
                modelFive.str3 = STRING_VAL;
                modelFive.str4 = STRING_VAL;
                modelFive.str5 = STRING_VAL;
                modelFive.str6 = STRING_VAL;
                modelFive.str7 = STRING_VAL;
                modelFive.str8 = STRING_VAL;
                modelFive.str9 = STRING_VAL;
                modelFive.str10 = STRING_VAL;
                modelFive.str11 = STRING_VAL;
                modelFive.save();

                for (int i = 0; i < count6; ++i) {
                    ModelSix modelSix = new ModelSix();
                    modelSix.str1 = String.valueOf(i);
                    modelSix.bool1 = random.nextBoolean();
                    modelSix.bool2 = random.nextBoolean();
                    modelSix.bool3 = random.nextBoolean();
                    modelSix.bool4 = random.nextBoolean();
                    modelSix.int1 = random.nextInt();
                    modelSix.int2 = random.nextInt();
                    modelSix.str2 = STRING_VAL;
                    modelSix.str3 = STRING_VAL;
                    modelSix.save();
                }

                for (int i = 0; i < count3; ++i) {
                    ModelThree modelThree = new ModelThree();
                    modelThree.str1 = STRING_VAL;
                    modelThree.str2 = STRING_VAL;
                    modelThree.save();

                    ModelTwo modelTwo = new ModelTwo();
                    modelTwo.modelThree = modelThree;
                    modelTwo.str1 = String.valueOf(i);
                    modelTwo.bool1 = random.nextBoolean();
                    modelTwo.long2 = random.nextLong();
                    modelTwo.str2 = STRING_VAL;
                    modelTwo.str3 = STRING_VAL;
                    modelTwo.str4 = STRING_VAL;
                    modelTwo.str5 = STRING_VAL;
                    modelTwo.save();

                    ModelFour modelFour = new ModelFour();
                    modelFour.bool1 = random.nextBoolean();
                    modelFour.bool2 = random.nextBoolean();
                    modelFour.long2 = random.nextLong();
                    modelFour.str1 = STRING_VAL;
                    modelFour.save();

                    ModelOne modelOne = new ModelOne();
                    modelOne.modelTwo = modelTwo;
                    modelOne.modelFour = modelFour;
                    modelOne.str1 = String.valueOf(i);
                    modelOne.bool1 = random.nextBoolean();
                    modelOne.bool2 = random.nextBoolean();
                    modelOne.bool3 = random.nextBoolean();
                    modelOne.bool4 = random.nextBoolean();
                    modelOne.bool5 = random.nextBoolean();
                    modelOne.bool6 = random.nextBoolean();
                    modelOne.bool7 = random.nextBoolean();
                    modelOne.bool8 = random.nextBoolean();
                    modelOne.long2 = random.nextLong();
                    modelOne.long3 = random.nextLong();
                    modelOne.long4 = random.nextLong();
                    modelOne.long5 = random.nextLong();
                    modelOne.long6 = random.nextLong();
                    modelOne.long7 = random.nextLong();
                    modelOne.str2 = STRING_VAL;
                    modelOne.save();
                }
            }
        });
    }
}
