package deepdive.cnm.edu.linkorganizer.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.entity.Link;
import deepdive.cnm.edu.linkorganizer.entity.User;
import java.util.List;
 @Dao
  public interface UserDao {

    @Insert



    @Query("SELECT * FROM User WHERE user_id = :userId")
    User getUserById(Long userId);

    @Update
    int update(User... users);

    @Delete
    int delete(User... users);

  }


}
