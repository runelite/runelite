import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 4061839419306493621L
   )
   @Export("length")
   long length;
   @ObfuscatedName("k")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -7914536822331600479L
   )
   @Export("position")
   long position;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1768489614"
   )
   public final int method4143(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("k")
   final void method4144(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1524714639"
   )
   public final void method4145(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "115633702"
   )
   public final void method4146() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-911547729"
   )
   public final long method4147() throws IOException {
      return this.file.length();
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method4146();
      }

   }

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
}
