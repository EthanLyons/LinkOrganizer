package deepdive.cnm.edu.linkorganizer.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import deepdive.cnm.edu.linkorganizer.model.entity.Link;

import java.util.List;

/**
 * Interface, Dao for Links. Used to insert, update, query, and delete.
 */
@Dao
public interface LinkDao {

  /**
   *  Insert a link into the database.
   * @param links Link to be inserted
   * @return Value returned
   */
  @Insert
  List<Long> insert(Link... links);

  /**
   *  Query Links with comparison to <code>link_id</code> using SQL.
   * @param link_id link to be used for ID
   * @return returns link
   */
  @Query("SELECT * FROM Link WHERE link_id = :link_id")
  Link getLinkById(Long link_id);

  /**
   *
   * Querys a specific Link
   * @return Queried link return value.
   */
  @Query("SELECT * FROM Link")
  List<Link> getAllLinks();

  /**
   *
   * Updates the link in the Database
   * @param link Specific Link instance being updated
   */
  @Update
  void update(Link link);

  /**
   * This deletes 0 or more links (Only one deletion at a time for this program)
   * @param links Specific links to be deleted.
   * @return Notifies deletion.
   */
  @Delete
  int delete(Link... links);

}
