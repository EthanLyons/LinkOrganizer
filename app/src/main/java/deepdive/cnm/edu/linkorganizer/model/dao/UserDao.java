package deepdive.cnm.edu.linkorganizer.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.model.entity.User;
import java.util.List;
 @Dao
  public interface UserDao {

    @Insert
    List<Long> insert(User... users);



    @Query("SELECT * FROM User WHERE user_id = :userId")
    User getUserById(Long userId);

    @Update
    int update(User... users);

    @Delete
    int delete(User... users);


}
