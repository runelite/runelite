import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class151 extends class297 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field2127;
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("c")
   final boolean field2126;

   public class151(boolean var1) {
      this.field2126 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-27"
   )
   int method3135(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2126?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2126?1:-1;
      }

      return this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3135((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "111995210"
   )
   static final void method3140() {
      short var0 = 256;
      int var1;
      if(class90.field1346 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1346 > 768) {
               Item.field1408[var1] = ChatLineBuffer.method2023(class38.field489[var1], class7.field231[var1], 1024 - class90.field1346);
            } else if(class90.field1346 > 256) {
               Item.field1408[var1] = class7.field231[var1];
            } else {
               Item.field1408[var1] = ChatLineBuffer.method2023(class7.field231[var1], class38.field489[var1], 256 - class90.field1346);
            }
         }
      } else if(class90.field1357 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1357 > 768) {
               Item.field1408[var1] = ChatLineBuffer.method2023(class38.field489[var1], class36.field480[var1], 1024 - class90.field1357);
            } else if(class90.field1357 > 256) {
               Item.field1408[var1] = class36.field480[var1];
            } else {
               Item.field1408[var1] = ChatLineBuffer.method2023(class36.field480[var1], class38.field489[var1], 256 - class90.field1357);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            Item.field1408[var1] = class38.field489[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class90.field1338, 9, class90.field1338 + 128, var0 + 7);
      class317.field3926.method5868(class90.field1338, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class324.rasterProvider.width * 9 + class90.field1338;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1360[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class90.field1362[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Item.field1408[var7];
               var10 = class324.rasterProvider.pixels[var2];
               class324.rasterProvider.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class324.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class90.field1338 + 765 - 128, 9, class90.field1338 + 765, var0 + 7);
      class61.field715.method5868(class90.field1338 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class324.rasterProvider.width * 9 + class90.field1338 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1360[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class90.field1362[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = Item.field1408[var7];
               var10 = class324.rasterProvider.pixels[var2];
               class324.rasterProvider.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var9 * (var10 & 65280) + var8 * (var7 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class324.rasterProvider.width - var5 - var4;
      }

   }
}
