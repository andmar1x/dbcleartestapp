package io.andmar1x.dbcleartestapp.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyAction;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = Database.NAME, tableName = "ModelTwo", insertConflict = ConflictAction.REPLACE)
public class ModelTwo extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long long1;

    @Column
    @Unique(unique = true, onUniqueConflict = ConflictAction.REPLACE)
    public String str1;

    @Column
    @ForeignKey(
            references = {@ForeignKeyReference(columnName = "model_three_id",
                    columnType = Long.class,
                    foreignColumnName = "long1")},
            onUpdate = ForeignKeyAction.CASCADE,
            onDelete = ForeignKeyAction.CASCADE)
    public ModelThree modelThree;

    @Column
    public boolean bool1;

    @Column
    public long long2;

    @Column
    public String str2;

    @Column
    public String str3;

    @Column
    public String str4;

    @Column
    public String str5;
}
