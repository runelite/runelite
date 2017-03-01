import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class38 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1849370889
   )
   int field791;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1202189999
   )
   int field792;
   @ObfuscatedName("y")
   String field794;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1179665299
   )
   int field795;
   @ObfuscatedName("ey")
   static SpritePixels field797;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1427545315
   )
   int field798;
   @ObfuscatedName("ca")
   static class102 field800;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1963539689
   )
   static int field801;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   static final void method819() {
      short var0 = 256;
      int var1;
      if(class41.field831 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field831 > 768) {
               class211.field3132[var1] = class33.method769(class41.field830[var1], NPC.field765[var1], 1024 - class41.field831);
            } else if(class41.field831 > 256) {
               class211.field3132[var1] = NPC.field765[var1];
            } else {
               class211.field3132[var1] = class33.method769(NPC.field765[var1], class41.field830[var1], 256 - class41.field831);
            }
         }
      } else if(class41.field856 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field856 > 768) {
               class211.field3132[var1] = class33.method769(class41.field830[var1], PlayerComposition.field2178[var1], 1024 - class41.field856);
            } else if(class41.field856 > 256) {
               class211.field3132[var1] = PlayerComposition.field2178[var1];
            } else {
               class211.field3132[var1] = class33.method769(PlayerComposition.field2178[var1], class41.field830[var1], 256 - class41.field856);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class211.field3132[var1] = class41.field830[var1];
         }
      }

      Rasterizer2D.method4091(class41.field822, 9, class41.field822 + 128, 7 + var0);
      class41.field824.method4172(class41.field822, 0);
      Rasterizer2D.method4018();
      var1 = 0;
      int var2 = class57.bufferProvider.width * 9 + class41.field822;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field829[var3] / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class47.field946[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class211.field3132[var7];
               var10 = class57.bufferProvider.pixels[var2];
               class57.bufferProvider.pixels[var2++] = ((var7 & 16711935) * var8 + var9 * (var10 & 16711935) & -16711936) + (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class57.bufferProvider.width - 128;
      }

      Rasterizer2D.method4091(765 + class41.field822 - 128, 9, 765 + class41.field822, 7 + var0);
      class41.field825.method4172(382 + class41.field822, 0);
      Rasterizer2D.method4018();
      var1 = 0;
      var2 = 637 + class57.bufferProvider.width * 9 + 24 + class41.field822;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field829[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class47.field946[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class211.field3132[var7];
               var10 = class57.bufferProvider.pixels[var2];
               class57.bufferProvider.pixels[var2++] = (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) + (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class57.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1609223334"
   )
   static final void method820(Widget var0, int var1, int var2) {
      if(Client.field526 == 0 || Client.field526 == 3) {
         if(class115.field1811 == 1 || !Client.field291 && class115.field1811 == 4) {
            class164 var3 = var0.method3289(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1812 - var1;
            int var5 = class115.field1813 - var2;
            if(var3.method3225(var4, var5)) {
               var4 -= var3.field2160 / 2;
               var5 -= var3.field2155 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class84.field1460[var6];
               int var8 = class84.field1446[var6];
               var7 = var7 * (256 + Client.mapScaleDelta) >> 8;
               var8 = var8 * (Client.mapScaleDelta + 256) >> 8;
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + WidgetNode.localPlayer.x >> 7;
               int var12 = WidgetNode.localPlayer.y - var10 >> 7;
               Client.field332.method3144(163);
               Client.field332.method2873(18);
               Client.field332.method2872(Player.baseX + var11);
               Client.field332.method2921(SecondaryBufferProvider.baseY + var12);
               Client.field332.method3083(class105.field1718[82]?(class105.field1718[81]?2:1):0);
               Client.field332.method2873(var4);
               Client.field332.method2873(var5);
               Client.field332.method2872(Client.mapAngle);
               Client.field332.method2873(57);
               Client.field332.method2873(Client.mapScale);
               Client.field332.method2873(Client.mapScaleDelta);
               Client.field332.method2873(89);
               Client.field332.method2872(WidgetNode.localPlayer.x);
               Client.field332.method2872(WidgetNode.localPlayer.y);
               Client.field332.method2873(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }
}
