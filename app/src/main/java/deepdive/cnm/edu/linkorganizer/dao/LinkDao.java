package deepdive.cnm.edu.linkorganizer.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.entity.Link;

import java.util.List;

@Dao
public interface LinkDao {

  @Insert
  List<Long> insert(Link... links);

  @Query("SELECT * FROM Link WHERE link_id = :link_id")
  Link getLinkById(Long link_id);

  @Delete
  int delete(Link... links);

}
