//package deepdive.cnm.edu.linkorganizer;
//
//import static org.junit.Assert.*;
//
//import android.arch.persistence.room.Room;
//import android.content.Context;
//import android.support.test.InstrumentationRegistry;
//import deepdive.cnm.edu.linkorganizer.dao.LinkDao;
//import deepdive.cnm.edu.linkorganizer.entity.Link;
//import java.util.Date;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class LinkFragmentTest {
//
//  private LinkOrganizerDB linkOrganizerDB;
//  private LinkDao linkDaol;
//
//  @Before
//  public void setUp() throws Exception {
//    Context context = InstrumentationRegistry.getTargetContext();
//    LinkOrganizerDB = Room.inMemoryDatabaseBuilder(context, LinkOrganizerDB.class).build();
//    LinkDao = linkOrganizerDB.getLinkDao();
//  }
//
//
//  @Test
//  public void insertSelectDelete()  {
//    Link link = new Link();
//
//    assertEquals(1, ids.size());
//  }
//
//
//  @Test
//  Public void selectAll() {
//    Link[] apods = new Link[10];
//    for (int i = 0; i < links.length; i++)
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    LinkDao = LinkOrganizerDB.getLinkDao();
//  }
//}