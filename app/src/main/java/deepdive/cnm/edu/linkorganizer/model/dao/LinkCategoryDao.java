package deepdive.cnm.edu.linkorganizer.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import deepdive.cnm.edu.linkorganizer.model.entity.LinkCategory;
import java.util.List;

/**
 * LinkCategoryDao used for Updating, Deleting, Quering, and Inserting Link Categories.
 */

@Dao
public interface LinkCategoryDao {

  /**
   * Inserts one or more linkCategories to the database.
   * @param linkCategories linkCategory to be inserted.
   * @return Returns inserted linkCategory.
   */
  @Insert
  List<Long> insert(LinkCategory... linkCategories);

  /**
   * Query for all categories with the respective ID's from the database.
   * @param category_id Specific instance ID of the LinkCategory.
   * @param link_id Associated Link ID for the category
   * @return Returns an associative LinkCategory
   */

  @Query("SELECT * FROM LinkCategory WHERE category_id = :category_id AND link_id = :link_id")
  LinkCategory getLinkCategory(Long category_id, Long link_id);


  /**
   * Deletes LinkCategories from the database (not used).
   * @param LinkCategorys The LinkCategory to be deleted.
   * @return Returns a deleted link category.
   */
  @Delete
  int delete(LinkCategory... LinkCategorys);

}
