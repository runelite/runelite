import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class18 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 991949995
   )
   int field188;
   @ObfuscatedName("o")
   Widget field190;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1468225669
   )
   int field191;
   @ObfuscatedName("y")
   boolean field192;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1472151989
   )
   int field193;
   @ObfuscatedName("q")
   Widget field194;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -750518461
   )
   int field195;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1665322209
   )
   int field196;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1201852435
   )
   int field197;
   @ObfuscatedName("k")
   Object[] field198;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1312864823
   )
   static int field199;
   @ObfuscatedName("c")
   String field200;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 1699315237
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-604114309"
   )
   static void method201() {
      class11.underlayIds = null;
      class11.overlayIds = null;
      class189.overlayPaths = null;
      class11.overlayRotations = null;
      class7.field55 = null;
      class39.field798 = null;
      class215.field3153 = null;
      class48.field933 = null;
      class11.field100 = null;
      Ignore.field206 = null;
      class7.field62 = null;
      class47.field929 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "1636708240"
   )
   static final void method202(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class11.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class11.tileHeights[0][var2];
                  int var11 = var4 + 932731 + var2;
                  int var12 = var5 + 556238 + var3;
                  int var13 = class175.method3254(var11 + '넵', var12 + 91923, 4) - 128 + (class175.method3254(10294 + var11, var12 + '鎽', 2) - 128 >> 1) + (class175.method3254(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class11.tileHeights[var1][var2][var3] = class11.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class11.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class11.tileHeights[var1][var2][var3] = class11.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class11.overlayIds[var1][var2][var3] = var0.readByte();
               class189.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class11.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class11.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class11.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   static final void method203(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = Renderable.method1883(var0, var1, class48.plane) - var2;
         var0 -= class202.cameraX;
         var3 -= class32.cameraZ;
         var1 -= class16.cameraY;
         int var4 = class84.field1428[FloorUnderlayDefinition.cameraPitch];
         int var5 = class84.field1452[FloorUnderlayDefinition.cameraPitch];
         int var6 = class84.field1428[class3.cameraYaw];
         int var7 = class84.field1452[class3.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field383 = Client.camera2 / 2 + Client.scale * var0 / var1;
            Client.field384 = Client.scale * var8 / var1 + Client.camera3 / 2;
         } else {
            Client.field383 = -1;
            Client.field384 = -1;
         }

      } else {
         Client.field383 = -1;
         Client.field384 = -1;
      }
   }
}
