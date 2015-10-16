package io.andmar1x.dbcleartestapp.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public final List<Case> cases = new ArrayList<>();

    public void dump() {
        for (int i = 0; i < cases.size(); ++i) {
            long fillSum = 0;
            long method1Sum = 0;
            long method2Sum = 0;
            long count = 0;
            List<Attempt> attempts = cases.get(i).attempts;
            for (int j = 0; j < attempts.size(); ++j) {
                Attempt anattempt = attempts.get(j);
                long fill1 = anattempt.fill1 - anattempt.start;
                long method1 = anattempt.method1 - anattempt.fill1;
                long fill2 = anattempt.fill2 - anattempt.method1;
                long method2 = anattempt.method2 - anattempt.fill2;

                fillSum += fill1 + fill2;
                method1Sum += method1;
                method2Sum += method2;

                ++count;
            }

            Log.d("Calculator", "Case=" + i + "AvgInsert=" + fillSum / (count * 2));
            Log.d("Calculator", "Case=" + i + "AvgMethod1=" + method1Sum / count);
            Log.d("Calculator", "Case=" + i + "AvgMethod2=" + method2Sum / count);
        }
    }

    public static class Case {

        public final List<Attempt> attempts = new ArrayList<>();

    }

    public static class Attempt {

        public long start;

        public long count3;
        public long count6;

        public long fill1;
        public long fill2;
        public long method1;
        public long method2;

    }
}
