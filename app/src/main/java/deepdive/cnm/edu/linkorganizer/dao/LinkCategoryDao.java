package deepdive.cnm.edu.linkorganizer.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.entity.LinkCategory;
import java.util.Date;
import java.util.List;

@Dao
public interface LinkCategoryDao {

  @Insert
  List<Long> insert(LinkCategory... linkCategories);

  @Query("SELECT * FROM LinkCategory WHERE category_id = :category_id AND link_id = :link_id")
  LinkCategory getLinkCategory(Long category_id, Long link_id);

  @Delete
  int delete(LinkCategory... LinkCategorys);

}
