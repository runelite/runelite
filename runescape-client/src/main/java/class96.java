import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class96 {
   @ObfuscatedName("n")
   static byte[] field1491;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("r")
   static byte[] field1487;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lfe;"
   )
   static Buffer[] field1490;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1584673371
   )
   static int field1499;
   @ObfuscatedName("l")
   static int[] field1492;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -976319507
   )
   static int field1489;
   @ObfuscatedName("w")
   static int[] field1494;
   @ObfuscatedName("p")
   static int[] field1495;
   @ObfuscatedName("m")
   static int[] field1496;
   @ObfuscatedName("u")
   static int[] field1497;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1499032993
   )
   static int field1498;
   @ObfuscatedName("k")
   static int[] field1493;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   static Buffer field1500;

   static {
      field1491 = new byte[2048];
      field1487 = new byte[2048];
      field1490 = new Buffer[2048];
      field1499 = 0;
      field1492 = new int[2048];
      field1489 = 0;
      field1494 = new int[2048];
      field1495 = new int[2048];
      field1496 = new int[2048];
      field1497 = new int[2048];
      field1498 = 0;
      field1493 = new int[2048];
      field1500 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-663163711"
   )
   static final boolean method1769(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfe;IIIIIIB)V",
      garbageValue = "-111"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var4 + 932731 + var2;
                  int var12 = var5 + var3 + 556238;
                  int var13 = class98.getSmoothNoise(var11 + '넵', var12 + 91923, 4) - 128 + (class98.getSmoothNoise(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (class98.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class12.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               Item.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
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
