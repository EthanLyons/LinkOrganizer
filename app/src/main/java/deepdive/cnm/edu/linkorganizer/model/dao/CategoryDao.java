package deepdive.cnm.edu.linkorganizer.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.model.entity.Category;
import java.util.List;

/**
 * Category Dao model used to Insert, update, Query, and Delete a Category.
 */
@Dao
public interface CategoryDao {

  /**
   * Inserts one or more categories to the database.
   * @param categories Category to be inserted.
   * @return Returns inserted category.
   */
  @Insert
  List<Long> insert(Category... categories);

  /**
   * Query all categories using SQL.
   * @param category_id
   * @return
   */
  @Query("SELECT * FROM Category WHERE category_id = :category_id")
  Category getCategoryDao(Long category_id);

  /**
   * This updates 0 or more categories in the database.
   * @param categories Specific category to be updated.
   * @return returns updated categories.
   */
  @Update
  int update(Category... categories);

  /**
   * This deletes 0 or more categories (Only one deletion at a time for this program)
   * @param categories Specific category to be deleted.
   * @return Notifies deletion.
   */
  @Delete
  int delete(Category... categories);



}
