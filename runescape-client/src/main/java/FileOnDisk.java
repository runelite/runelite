import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 3887187898014660955L
   )
   @Export("length")
   long length;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4924614775558776311L
   )
   @Export("position")
   long position;
   @ObfuscatedName("x")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("x")
   final void method1486(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   public final void method1488() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-337913910"
   )
   public final long method1489() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "247271349"
   )
   public final int method1490(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1677299647"
   )
   public final void method1495(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
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

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method1488();
      }

   }
}
