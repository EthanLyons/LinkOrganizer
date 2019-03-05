package deepdive.cnm.edu.linkorganizer.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.entity.Link;
import java.util.List;

@Dao
public interface CategoryDao {

  @Insert
  List<Link> insert(CategoryDao... categoryDaos);

  @Query
  CategoryDao getCategoryDao(Long category_id);

  @Update
  List<CategoryDao> findAll();

  @Delete
  int delete(CategoryDao... categoryDaos);



}
