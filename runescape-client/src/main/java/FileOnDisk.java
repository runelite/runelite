import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1270739899
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("a")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -4512531111401429473L
   )
   @Export("length")
   long length;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6496465651702349683L
   )
   @Export("position")
   long position;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
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

   @ObfuscatedName("a")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2127451375"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2114742972"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1673795207"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-9"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-456230251"
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
}
