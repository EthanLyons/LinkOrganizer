package deepdive.cnm.edu.linkorganizer.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.net.UrlQuerySanitizer;
import android.support.annotation.NonNull;

@Entity()

public class Link {


  @ColumnInfo(name = "link_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "user_id")
  private long userId;
  private String url;
  private String descriptor;
  private String timestamp;



  public long getId() { return id;}
  public void setId(Long id) {
    this.id = id;
  }

  public long getUserId() { return userId;}
  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUrl() { return url;}
  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescriptor() { return descriptor;}
  public void setDescriptor(String descriptor) {
    this.descriptor = descriptor;
  }

  public String getTimestamp() { return timestamp;}
  public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
