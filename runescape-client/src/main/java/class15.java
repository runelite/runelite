import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class15 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1436240791
   )
   static int field298;
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -767622985
   )
   static int field303;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lb;Lb;I)I",
      garbageValue = "404248605"
   )
   int method91(class14 var1, class14 var2) {
      return var1.field295.totalQuantity < var2.field295.totalQuantity?-1:(var2.field295.totalQuantity == var1.field295.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method91((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1942965117"
   )
   public static int method98(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "16711935"
   )
   static int method95(int var0, int var1) {
      Overlay var2 = class43.method626(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var4;
         int var5;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            byte var11 = 96;
            int var3;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var11 < 0) {
                  var11 = 0;
               } else if(var11 > 127) {
                  var11 = 127;
               }

               var5 = 127 - var11;
               var3 = var5;
            } else {
               var5 = var11 * (var4 & 127) / 128;
               if(var5 < 2) {
                  var5 = 2;
               } else if(var5 > 126) {
                  var5 = 126;
               }

               var3 = var5 + (var4 & 65408);
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var4 = var2.hue;
            var5 = var2.saturation;
            int var6 = var2.lightness;
            if(var6 > 179) {
               var5 /= 2;
            }

            if(var6 > 192) {
               var5 /= 2;
            }

            if(var6 > 217) {
               var5 /= 2;
            }

            if(var6 > 243) {
               var5 /= 2;
            }

            int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
            byte var9 = 96;
            int var8;
            if(var7 == -2) {
               var8 = 12345678;
            } else {
               int var12;
               if(var7 == -1) {
                  if(var9 < 0) {
                     var9 = 0;
                  } else if(var9 > 127) {
                     var9 = 127;
                  }

                  var12 = 127 - var9;
                  var8 = var12;
               } else {
                  var12 = var9 * (var7 & 127) / 128;
                  if(var12 < 2) {
                     var12 = 2;
                  } else if(var12 > 126) {
                     var12 = 126;
                  }

                  var8 = var12 + (var7 & 65408);
               }
            }

            return Graphics3D.colorPalette[var8] | -16777216;
         }
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1139435692"
   )
   static final void method97(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      class211.cameraX = var0 - var8;
      ScriptState.cameraZ = var1 - var9;
      ChatLineBuffer.cameraY = var2 - var10;
      class9.cameraPitch = var3;
      class174.cameraYaw = var4;
   }
}
