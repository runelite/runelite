import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("l")
   static boolean field1927;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 186062521
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 157610739
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1563358177
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1135213171
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1515318095
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("w")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1322932211
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "52"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class186.currentTimeMsLast) {
         class186.currentTimeMsOffset += class186.currentTimeMsLast - var0;
      }

      class186.currentTimeMsLast = var0;
      return var0 + class186.currentTimeMsOffset;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "203"
   )
   public static void method2898() {
      if(class19.NetCache_socket != null) {
         class19.NetCache_socket.vmethod3299();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;IIIIIII)V",
      garbageValue = "1267249988"
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
                  int var13 = class185.getSmoothNoise(45365 + var11, 91923 + var12, 4) - 128 + (class185.getSmoothNoise(var11 + 10294, 37821 + var12, 2) - 128 >> 1) + (class185.getSmoothNoise(var11, var12, 1) - 128 >> 2);
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
               class29.field403[var1][var2][var3] = var0.readByte();
               TotalQuantityComparator.field288[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class62.field725[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class62.field724[var1][var2][var3] = (byte)(var7 - 81);
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
