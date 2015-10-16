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

@Table(databaseName = Database.NAME, tableName = "ModelOne", insertConflict = ConflictAction.REPLACE)
public class ModelOne extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long long1;

    @Column
    @Unique(unique = true, onUniqueConflict = ConflictAction.REPLACE)
    public String str1;

    @Column
    @ForeignKey(
            references = {@ForeignKeyReference(columnName = "modelTwo_id",
                    columnType = Long.class,
                    foreignColumnName = "long1")},
            onUpdate = ForeignKeyAction.CASCADE,
            onDelete = ForeignKeyAction.CASCADE)
    public ModelTwo modelTwo;

    @Column
    @ForeignKey(
            references = {@ForeignKeyReference(columnName = "modelFour_id",
                    columnType = Long.class,
                    foreignColumnName = "long1")},
            onUpdate = ForeignKeyAction.CASCADE,
            onDelete = ForeignKeyAction.CASCADE)
    public ModelFour modelFour;

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
    public boolean bool8;

    @Column
    public long long2;

    @Column
    public long long3;

    @Column
    public long long4;

    @Column
    public long long5;

    @Column
    public String str2;

    @Column
    public long long6;

    @Column
    public long long7;
}
