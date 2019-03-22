package deepdive.cnm.edu.linkorganizer.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.model.entity.Category;
import java.util.List;

@Dao
public interface CategoryDao {

  @Insert
  List<Long> insert(Category... categories);

  @Query("SELECT * FROM Category WHERE category_id = :category_id")
  Category getCategoryDao(Long category_id);

  @Update
  int update(Category... categories);

  @Delete
  int delete(Category... categories);



}
