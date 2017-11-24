import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class149 {
   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      signature = "[Lhx;"
   )
   static Widget[] field2108;
   @ObfuscatedName("d")
   final URL field2103;
   @ObfuscatedName("x")
   volatile boolean field2101;
   @ObfuscatedName("k")
   volatile byte[] field2102;

   class149(URL var1) {
      this.field2103 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-35"
   )
   public boolean method3032() {
      return this.field2101;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-11"
   )
   public byte[] method3033() {
      return this.field2102;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfr;IIIIIII)V",
      garbageValue = "-1833369656"
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
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = class90.getSmoothNoise(var11 + 45365, 91923 + var12, 4) - 128 + (class90.getSmoothNoise(10294 + var11, 37821 + var12, 2) - 128 >> 1) + (class90.getSmoothNoise(var11, var12, 1) - 128 >> 2);
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
               class61.field736[var1][var2][var3] = var0.readByte();
               class36.field481[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.field726[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.field724[var1][var2][var3] = (byte)(var7 - 81);
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
