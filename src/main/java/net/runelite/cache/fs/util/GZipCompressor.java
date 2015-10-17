package net.runelite.cache.fs.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZipCompressor {
   public static final byte[] compress(byte[] data) {
      ByteArrayOutputStream compressedBytes = new ByteArrayOutputStream();

      try {
         GZIPOutputStream e = new GZIPOutputStream(compressedBytes);
         e.write(data);
         e.finish();
         e.close();
         return compressedBytes.toByteArray();
      } catch (IOException var3) {
         var3.printStackTrace();
         return null;
      }
   }
}
