package io.andmar1x.dbcleartestapp.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = Database.NAME, tableName = "ModelSix", insertConflict = ConflictAction.REPLACE)
public class ModelSix extends BaseModel {

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
    public int int1;

    @Column
    public int int2;

    @Column
    public String str2;

    @Column
    public String str3;
}
