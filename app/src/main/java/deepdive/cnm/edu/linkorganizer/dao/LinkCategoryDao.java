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

  @Query
  LinkCategoryDao getLinkCategoryDao(Long);

  @Update
  List<LinkCategory> findAll();

  @Delete
  int delete(LinkCategory... LinkCategorys);

}
