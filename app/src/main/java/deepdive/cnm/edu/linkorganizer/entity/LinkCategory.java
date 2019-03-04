package deepdive.cnm.edu.linkorganizer.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity (
    foreignKeys = {
        @ForeignKey(entity = Link.class, parentColumns = "link_id", childColumns = "link_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Category.class, parentColumns = "category_id", childColumns = "category_id", onDelete = ForeignKey.CASCADE)
    },
    indices = {
        @Index(value = {"link_id","category_id"}, unique = true) // enables unique variables
    }
)

public class LinkCategory {

  @ColumnInfo(name = "category_id", index = true)
  private long categoryId;

  @ColumnInfo(name = "link_id", index = true)
  private long linkId;

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public long getLinkId() {
    return linkId;
  }

  public void setLinkId(long linkId) {
    this.linkId = linkId;
  }
}
