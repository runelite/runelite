import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("k")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 2553692343651708491L
   )
   @Export("position")
   long position;
   @ObfuscatedName("z")
   public static String field1195;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 3938644720146859787L
   )
   @Export("length")
   long length;
   @ObfuscatedName("h")
   public static String[] field1198;

   @ObfuscatedName("k")
   final void method1417(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "59"
   )
   public final void method1418(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2012434976"
   )
   public final void method1419() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1307318209"
   )
   public final long method1420() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "81"
   )
   public final int method1421(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method1419();
      }

   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)[Lclass178;",
      garbageValue = "1"
   )
   public static class178[] method1438() {
      return new class178[]{class178.field2662, class178.field2661, class178.field2667, class178.field2663};
   }
}
