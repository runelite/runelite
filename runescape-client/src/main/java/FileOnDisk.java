import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6880207762770644403L
   )
   @Export("length")
   long length;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 874853037
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 4856900901058070213L
   )
   @Export("position")
   long position;

   @ObfuscatedName("i")
   final void method2383(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "176402679"
   )
   public final void method2384(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   public final void method2385() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "92"
   )
   public final long method2386() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1588092024"
   )
   public final int method2387(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method2385();
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-677066588"
   )
   static final int method2407() {
      return class134.field1979;
   }
}
