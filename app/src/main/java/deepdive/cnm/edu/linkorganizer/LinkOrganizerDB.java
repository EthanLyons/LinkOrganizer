package deepdive.cnm.edu.linkorganizer;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;
import deepdive.cnm.edu.linkorganizer.dao.LinkDao;
import deepdive.cnm.edu.linkorganizer.dao.UserDao;
import deepdive.cnm.edu.linkorganizer.entity.Category;
import deepdive.cnm.edu.linkorganizer.entity.Link;
import deepdive.cnm.edu.linkorganizer.entity.LinkCategory;
import deepdive.cnm.edu.linkorganizer.entity.User;
import deepdive.cnm.edu.linkorganizer.LinkOrganizerDB.Converters;
import deepdive.cnm.edu.linkorganizer.dao.CategoryDao;
import deepdive.cnm.edu.linkorganizer.dao.LinkCategoryDao;
import java.util.Calendar;
import java.util.Date;

/**
 * Defines the local database as a collection of its entities and converters, with the singleton
 * pattern implemented for app-wide use of a single connection, and declares methods to retrieve
 * data access objects (DAOs) for the database entities.
 */
@Database(
    entities = {LinkCategory.class, Category.class, User.class, Link.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class LinkOrganizerDB extends RoomDatabase {

  private static final String DB_NAME = "LinkOrganizerDB_db";

  public synchronized static LinkOrganizerDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract CategoryDao getCategoryDao();

  public abstract LinkCategoryDao getLinkCategoryDao();

  public abstract LinkDao getLinkDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final LinkOrganizerDB INSTANCE = Room.databaseBuilder(
        LinkOrganizerApplication.getInstance().getApplicationContext(), LinkOrganizerDB.class, DB_NAME)
        .build();

  }

  /**
   * Supports conversion operations for persistence of relevant types not natively supported by
   * Room/SQLite.
   */
  public static class Converters {

    @Nullable
    @TypeConverter
    public static Calendar calendarFromLong(@Nullable Long milliseconds) {
      if (milliseconds != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return calendar;
      }
      return null;
    }

    /**
     * Converts a {@link Calendar} date-time value number of milliseconds since the start of the
     * Unix epoch (1970-01-01 00:00:00.000 UTC), and returns the latter.
     *
     * @param calendar date-time as a {@link Calendar} instance.
     * @return date-time as a number of milliseconds since the start of the Unix epoch.
     */
    @Nullable
    @TypeConverter
    public static Long longFromCalendar(@Nullable Calendar calendar) {
      return (calendar != null) ? calendar.getTimeInMillis() : null;
    }
//
//    /**
//     * Converts an {@link Integer} value containing the days since the start of the Unix epoch
//     * (1970-01-01) to an instance of {@link Date}, and returns the latter. Both of these are
//     * interpreted as local dates, with no reference to time zone.
//     *
//     * @param days local date as a number of days since the start of the Unix epoch.
//     * @return local date as a {@link Date} instance.
//     */
//    @Nullable
//    @TypeConverter
//    public static Date dateFromInt(@Nullable Integer days) {
//      return (days != null) ? Date.fromEpochDays(days) : null;
//    }
//
//    /**
//     * Converts a {@link Date} local date value to a number of days since the start of the Unix
//     * epoch (1970-01-01), and returns the latter. Both of these are interpreted as local dates,
//     * with no reference to time zone.
//     *
//     * @param date local date as a {@link Date} instance.
//     * @return local date as a number of days since the start of the Unix epoch.
//     */
//    @Nullable
//    @TypeConverter
//    public static Integer intFromDate(@Nullable Date date) {
//      return (date != null) ? date.toEpochDays() : null;
//    }
//
}
}
