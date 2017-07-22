import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class20 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 723291040655736969L
   )
   static long field321;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -822459971
   )
   static int field323;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljx;I)V",
      garbageValue = "1654627615"
   )
   static final void method151(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class92.field1406.length; ++var2) {
         class92.field1406[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class92.field1406[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class92.field1409[var5] = (class92.field1406[var5 + 128] + class92.field1406[var5 - 128] + class92.field1406[var5 + 1] + class92.field1406[var5 - 1]) / 4;
            }
         }

         int[] var8 = class92.field1406;
         class92.field1406 = class92.field1409;
         class92.field1409 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  class92.field1406[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "50"
   )
   static final void method150(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = var5 * (Client.field1157 - Client.field1163) / 100 + Client.field1163;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1162) {
         var15 = Client.field1162;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field979) {
            var6 = Client.field979;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4828(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4828(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field965) {
         var15 = Client.field965;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < Client.field913) {
            var6 = Client.field913;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4828(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4828(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1159 - Client.field1158) * var5 / 100 + Client.field1158;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2633(var14, 500, 800, var2, var3);
      }

      Client.field1164 = var0;
      Client.field1165 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
