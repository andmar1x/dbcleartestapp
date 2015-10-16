package io.andmar1x.dbcleartestapp.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = Database.NAME, tableName = "ModelThree", insertConflict = ConflictAction.REPLACE)
public class ModelThree extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long long1;

    @Column
    public String str1;

    @Column
    public String str2;
}
