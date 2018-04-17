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

@ObfuscatedName("di")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("o")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5361995657130045831L
   )
   @Export("length")
   long length;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -7300225605936443415L
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

   @ObfuscatedName("o")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1887798545"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1973112982"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1832171393"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2086846389"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "223146812"
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
