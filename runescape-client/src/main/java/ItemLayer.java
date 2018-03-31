import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1302142755
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1176722639
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 496517009
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -122810767
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1294947835
   )
   @Export("height")
   int height;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "2065823381"
   )
   public static boolean method2580(String var0, int var1) {
      return WorldMapType2.method553(var0, var1, "openjs");
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;IIIIIII)V",
      garbageValue = "-1873681428"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class62.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class62.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = class22.getSmoothNoise(45365 + var11, var12 + 91923, 4) - 128 + (class22.getSmoothNoise(10294 + var11, var12 + 37821, 2) - 128 >> 1) + (class22.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class62.tileOverlayIds[var1][var2][var3] = var0.readByte();
               class62.tileOverlayPath[var1][var2][var3] = (byte)((var7 - 2) / 4);
               RunException.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class62.tileUnderlayIds[var1][var2][var3] = (byte)(var7 - 81);
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
}
