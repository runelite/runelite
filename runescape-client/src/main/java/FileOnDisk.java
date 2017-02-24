import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3590516184679301645L
   )
   @Export("position")
   long position;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 258609363238031901L
   )
   @Export("length")
   long length;
   @ObfuscatedName("q")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -417899429
   )
   public static int field1209;

   @ObfuscatedName("q")
   final void method1468(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "25431"
   )
   public final void method1469(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1673677475"
   )
   static final void method1471(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field560 - Client.field385) * var5 / 100 + Client.field385;
      int var7 = 512 * var3 * var6 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field565) {
         var15 = Client.field565;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 > Client.field482) {
            var6 = Client.field482;
            var8 = 512 * var6 * var3 / (334 * var15);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4058();
               Rasterizer2D.method4011(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4011(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field401) {
         var15 = Client.field401;
         var6 = 334 * var15 * var2 / (var3 * 512);
         if(var6 < Client.field378) {
            var6 = Client.field378;
            var8 = 334 * var2 * var15 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4058();
               Rasterizer2D.method4011(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4011(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field561 + (Client.field562 - Client.field561) * var5 / 100;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 128 + 32 * var10 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class84.field1468[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1790(var14, 500, 800, var2, var3);
      }

      Client.field567 = var0;
      Client.field568 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1036952742"
   )
   public final int method1472(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22592"
   )
   public final void method1475() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-77038189"
   )
   public final long method1477() throws IOException {
      return this.file.length();
   }

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method1475();
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "892902558"
   )
   static SpritePixels method1485() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class202.field3074;
      var0.maxHeight = class225.field3231;
      var0.offsetX = Ignore.field223[0];
      var0.offsetY = class225.field3233[0];
      var0.width = class225.field3234[0];
      var0.height = class41.field862[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class11.field129[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class160.field2146[var2[var3] & 255];
      }

      Ignore.field223 = null;
      class225.field3233 = null;
      class225.field3234 = null;
      class41.field862 = null;
      class160.field2146 = null;
      class11.field129 = null;
      return var0;
   }
}
