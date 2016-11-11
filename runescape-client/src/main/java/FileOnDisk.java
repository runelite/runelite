import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1203593337595622491L
   )
   @Export("length")
   long length;
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 4070088608280391861L
   )
   @Export("position")
   long position;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "166245958"
   )
   public final void method4153(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("i")
   final void method4154(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1619921534"
   )
   public final void method4156() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-2090892801"
   )
   public final int method4157(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method4156();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "124193045"
   )
   public final long method4160() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-863194448"
   )
   static final int method4168(int var0, int var1) {
      int var2 = class31.method669(var0 - 1, var1 - 1) + class31.method669(var0 + 1, var1 - 1) + class31.method669(var0 - 1, 1 + var1) + class31.method669(var0 + 1, 1 + var1);
      int var3 = class31.method669(var0 - 1, var1) + class31.method669(1 + var0, var1) + class31.method669(var0, var1 - 1) + class31.method669(var0, var1 + 1);
      int var4 = class31.method669(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
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
}
