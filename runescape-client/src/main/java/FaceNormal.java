import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -499516437
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1891448901
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -730978099
   )
   @Export("z")
   int z;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   static final void method2917() {
      short var0 = 256;
      int var1;
      if(class91.field1442 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1442 > 768) {
               class81.field1340[var1] = class47.method740(NPC.field1379[var1], class223.field2846[var1], 1024 - class91.field1442);
            } else if(class91.field1442 > 256) {
               class81.field1340[var1] = class223.field2846[var1];
            } else {
               class81.field1340[var1] = class47.method740(class223.field2846[var1], NPC.field1379[var1], 256 - class91.field1442);
            }
         }
      } else if(class91.field1448 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class91.field1448 > 768) {
               class81.field1340[var1] = class47.method740(NPC.field1379[var1], WorldMapType2.field532[var1], 1024 - class91.field1448);
            } else if(class91.field1448 > 256) {
               class81.field1340[var1] = WorldMapType2.field532[var1];
            } else {
               class81.field1340[var1] = class47.method740(WorldMapType2.field532[var1], NPC.field1379[var1], 256 - class91.field1448);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class81.field1340[var1] = NPC.field1379[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class91.field1435, 9, class91.field1435 + 128, var0 + 7);
      class19.field336.method5017(class91.field1435, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class20.field342.width * 9 + class91.field1435;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1434[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = Coordinates.field2615[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class81.field1340[var7];
               var10 = class20.field342.pixels[var2];
               class20.field342.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class20.field342.width - 128;
      }

      Rasterizer2D.setDrawRegion(class91.field1435 + 765 - 128, 9, class91.field1435 + 765, var0 + 7);
      class88.field1405.method5017(class91.field1435 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class91.field1435 + 637 + class20.field342.width * 9 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class91.field1434[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = Coordinates.field2615[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class81.field1340[var7];
               var10 = class20.field342.pixels[var2];
               class20.field342.pixels[var2++] = (var9 * (var10 & '\uff00') + var8 * (var7 & '\uff00') & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class20.field342.width - var5 - var4;
      }

   }
}
