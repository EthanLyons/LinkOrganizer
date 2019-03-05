package deepdive.cnm.edu.linkorganizer.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity()

public class Category {

  @ColumnInfo(name = "category_id")
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String name;


  public long getCategory_id() { return id;}

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(long id) {
    this.id = this.id;
  }

}
