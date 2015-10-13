package net.runelite.cache.fs.util.gzip;

import net.runelite.cache.fs.io.Stream;
import java.util.zip.Inflater;

public class GZipDecompressor {
   private static final Inflater inflaterInstance = new Inflater(true);

   public static final void decompress(Stream stream, byte[] data) {
      Inflater var2 = inflaterInstance;
      synchronized(inflaterInstance) {
         if(stream.getBuffer()[stream.getOffset()] == 31 && stream.getBuffer()[stream.getOffset() + 1] == -117) {
            try {
               inflaterInstance.setInput(stream.getBuffer(), stream.getOffset() + 10, -stream.getOffset() - 18 + stream.getBuffer().length);
               inflaterInstance.inflate(data);
            } catch (Exception var4) {
               inflaterInstance.reset();
               data = (byte[])null;
            }

            inflaterInstance.reset();
         } else {
            data = (byte[])null;
         }
      }
   }
}
