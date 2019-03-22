package deepdive.cnm.edu.linkorganizer.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import deepdive.cnm.edu.linkorganizer.model.entity.LinkCategory;
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
