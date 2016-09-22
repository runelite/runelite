import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("n")
   public static short[] field3260;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4002942151660187767L
   )
   @Export("length")
   long length;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 3188358527691333459L
   )
   @Export("position")
   long position;
   @ObfuscatedName("x")
   static Widget field3263;
   @ObfuscatedName("a")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("a")
   final void method4174(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1018248286"
   )
   public final void method4175(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIS)I",
      garbageValue = "19703"
   )
   public final int method4178(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method4197();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "826301400"
   )
   public final long method4180() throws IOException {
      return this.file.length();
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15894"
   )
   public final void method4197() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }
}
