import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -1616623621638950645L
   )
   @Export("length")
   long length;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 215490599
   )
   public static int field3264;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 1104147540507229183L
   )
   @Export("position")
   long position;
   @ObfuscatedName("ey")
   static ModIcon[] field3266;
   @ObfuscatedName("f")
   @Export("file")
   RandomAccessFile file;

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method4191();
      }

   }

   @ObfuscatedName("f")
   final void method4189(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "634414588"
   )
   public final void method4190(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1515740833"
   )
   public final void method4191() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1835988409"
   )
   public final int method4193(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1093873047"
   )
   public final long method4206() throws IOException {
      return this.file.length();
   }
}
