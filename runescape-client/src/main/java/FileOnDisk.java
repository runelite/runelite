import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("c")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 5258037184149921181L
   )
   @Export("position")
   long position;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 8372313475435441603L
   )
   @Export("length")
   long length;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2130683069
   )
   public static int field1774;
   @ObfuscatedName("n")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("n")
   final void method2365(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "46"
   )
   public final void method2366(byte[] var1, int var2, int var3) throws IOException {
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
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56193190"
   )
   public final void method2368() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "32"
   )
   public final int method2369(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-19"
   )
   public final long method2370() throws IOException {
      return this.file.length();
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method2368();
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

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2106717047"
   )
   static final void method2384(Actor var0, int var1) {
      class24.method201(var0.x, var0.y, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "55"
   )
   public static int method2385(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class238.field3254 + class238.field3256;
      return var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "912541969"
   )
   public static String method2386(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
