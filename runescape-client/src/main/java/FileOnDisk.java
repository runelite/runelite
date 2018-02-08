import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("t")
   static int[] field1475;
   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   static TextureProvider field1471;
   @ObfuscatedName("s")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 2631415697410758815L
   )
   @Export("length")
   long length;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7424973308644706877L
   )
   @Export("position")
   long position;

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

   @ObfuscatedName("s")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "120"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "814627225"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-14"
   )
   @Export("closeSync")
   public final void closeSync(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "229133798"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-97"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("s")
   public static String method2097(long var0) {
      class193.field2553.setTime(new Date(var0));
      int var2 = class193.field2553.get(7);
      int var3 = class193.field2553.get(5);
      int var4 = class193.field2553.get(2);
      int var5 = class193.field2553.get(1);
      int var6 = class193.field2553.get(11);
      int var7 = class193.field2553.get(12);
      int var8 = class193.field2553.get(13);
      return class193.field2554[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class193.field2555[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
