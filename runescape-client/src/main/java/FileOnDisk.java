import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -196499901
   )
   static int field3259;
   @ObfuscatedName("x")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 4327789691613402203L
   )
   @Export("position")
   long position;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 7146396580059741643L
   )
   @Export("length")
   long length;

   @ObfuscatedName("x")
   final void method4134(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-31"
   )
   public final void method4135(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-443189957"
   )
   public final void method4136() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-103520622"
   )
   public final long method4137() throws IOException {
      return this.file.length();
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method4136();
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1850773497"
   )
   public final int method4154(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }
}
