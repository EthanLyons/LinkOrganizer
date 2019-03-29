package deepdive.cnm.edu.linkorganizer.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.model.entity.User;
import java.util.List;

/**
 * User Dao for specific fields and updating, inserting, deleting, quering.
 */
 @Dao
  public interface UserDao {

  /**
   * Inserts one or more Users to the database.
   * @param users Users to be inserted.
   * @return Returns inserted User.
   */
    @Insert
    List<Long> insert(User... users);

  /**
   * Queries individual matching userID
   * @param userId Particular given User Id instance
   * @return Returns a User ID
   */
    @Query("SELECT * FROM User WHERE user_id = :userId")
    User getUserById(Long userId);

  /**

   * This updates 0 or more users in the database.
   * @param users Specific users to be updated.
   * @return returns updated users.
   * */
    @Update
    int update(User... users);

  /**

   * This deletes 0 or more users (not used)
   * @param users Specific users to be deleted.
   * @return Notifies deletion.
   * */
    @Delete
    int delete(User... users);


}
