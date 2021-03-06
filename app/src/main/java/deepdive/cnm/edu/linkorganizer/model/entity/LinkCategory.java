package deepdive.cnm.edu.linkorganizer.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity (
    foreignKeys = {
        @ForeignKey(entity = Link.class, parentColumns = "link_id", childColumns = "link_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Category.class, parentColumns = "category_id", childColumns = "category_id", onDelete = ForeignKey.CASCADE)
    },
    primaryKeys = {"link_id","category_id"}
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
