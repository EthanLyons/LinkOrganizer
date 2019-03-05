package edu.cnm.deepdive.nasaapod.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.entity.Link;
import edu.cnm.deepdive.nasaapod.model.entity.Apod;
import edu.cnm.deepdive.util.Date;
import java.util.List;

@Dao
public interface LinkDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Link> insert(Link... links);

  @Query
  Link getLinkById(Long link_id);

  @Update
  List<Link> findAll();

  @Delete
  int delete(List... lists);

}
