package io.andmar1x.dbcleartestapp.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = Database.NAME, tableName = "ModelFive", insertConflict = ConflictAction.REPLACE)
public class ModelFive extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long long1;

    @Column
    @Unique(unique = true, onUniqueConflict = ConflictAction.REPLACE)
    public String str1;

    @Column
    public boolean bool1;

    @Column
    public boolean bool2;

    @Column
    public boolean bool3;

    @Column
    public boolean bool4;

    @Column
    public boolean bool5;

    @Column
    public boolean bool6;

    @Column
    public boolean bool7;

    @Column
    public long long2;

    @Column
    public long long3;

    @Column
    public long long4;

    @Column
    public long long5;

    @Column
    public long long6;

    @Column
    public long long7;

    @Column
    public long long8;

    @Column
    public long long9;

    @Column
    public String str2;

    @Column
    public String str3;

    @Column
    public String str4;

    @Column
    public String str5;

    @Column
    public String str6;

    @Column
    public String str7;

    @Column
    public String str8;

    @Column
    public String str9;

    @Column
    public String str10;

    @Column
    public String str11;

}
