package io.andmar1x.dbcleartestapp.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = Database.NAME, tableName = "ModelFour", insertConflict = ConflictAction.REPLACE)
public class ModelFour extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long long1;

    @Column
    public boolean bool1;

    @Column
    public boolean bool2;

    @Column
    public long long2;

    @Column
    public String str1;
}
