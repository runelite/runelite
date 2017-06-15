import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 6171799702701076863L
   )
   @Export("length")
   long length;
   @ObfuscatedName("cv")
   static IndexData field1763;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -2661727364008696793L
   )
   @Export("position")
   long position;
   @ObfuscatedName("p")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("o")
   static IndexDataBase field1769;

   @ObfuscatedName("p")
   final void method2263(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "874059073"
   )
   public final void method2264(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
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
      signature = "(I)J",
      garbageValue = "415244951"
   )
   public final long method2266() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-755587131"
   )
   public final int method2267(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method2274();
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1327545018"
   )
   public final void method2274() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "147"
   )
   static final void method2278(int var0) {
      class134.field2002[++class134.field2000 - 1] = var0;
   }
}
