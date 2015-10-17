package net.runelite.cache.fs.util;

import java.util.zip.CRC32;

public final class CRC32HGenerator {
   public static final CRC32 CRC32Instance = new CRC32();

   public static int getHash(byte[] data) {
      return getHash(data, 0, data.length);
   }

   public static int getHash(byte[] data, int offset, int length) {
      CRC32 var3 = CRC32Instance;
      synchronized(CRC32Instance) {
         CRC32Instance.update(data, offset, length);
         int hash = (int)CRC32Instance.getValue();
         CRC32Instance.reset();
         return hash;
      }
   }
}
