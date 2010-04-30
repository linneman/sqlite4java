package com.almworks.sqlite4java;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class MiscTests extends SQLiteTestFixture {
  public MiscTests() {
    super(false); 
  }

  public void testAdjustingLibPath() throws IOException {
    String jar = tempName("sqlite4java.jar");
    File jarFile = new File(jar);
    new RandomAccessFile(jarFile, "rw").close();
    assertTrue(jarFile.exists());
    jarFile.deleteOnExit();
    String dir = jarFile.getParentFile().getPath();
    char c = File.pathSeparatorChar;
    String url = "jar:file:" + jar + "!/sqlite/Internal.class";

    assertEquals(dir, Internal.getDefaultLibPath(null, url));
    assertEquals(dir, Internal.getDefaultLibPath("xxx", url));
    assertEquals(dir, Internal.getDefaultLibPath("xxx" + c + c + "yyy" + c, url));
    assertNull(Internal.getDefaultLibPath("xxx" + File.pathSeparatorChar + File.pathSeparatorChar + dir, url));
    assertEquals(dir, Internal.getDefaultLibPath(dir + "x", url));
    assertNull(Internal.getDefaultLibPath(dir, url));
  }

  public void testCreatingDatabaseInNonExistingDirectory() {
    String dir = tempName("newDir");
    File db = new File(dir, "db");
    SQLiteConnection c = new SQLiteConnection(db);
    try {
      c.open(true);
      fail("created a connection to db in a non-existing directory");
    } catch (SQLiteException e) {
      assertTrue(e.getMessage().toLowerCase(Locale.US).contains("file"));
    }
  }
}
