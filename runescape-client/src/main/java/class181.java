import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class181 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -19609733
   )
   static int field2960;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IIIIIII)V",
      garbageValue = "-1525027347"
   )
   static final void method3534(class122 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field78[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2556();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class5.field77[0][var2];
                  int var11 = var4 + var2 + 932731;
                  int var12 = 556238 + var3 + var5;
                  int var13 = class111.method2463(var11 + '넵', 91923 + var12, 4) - 128 + (class111.method2463(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (class111.method2463(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class5.field77[var1][var2][var3] = class5.field77[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method2556();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class5.field77[0][var2][var3] = -var14 * 8;
               } else {
                  class5.field77[var1][var2][var3] = class5.field77[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field81[var1][var2][var3] = var0.method2573();
               class158.field2353[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class138.field2141[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field78[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field80[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2556();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2556();
               break;
            }

            if(var7 <= 49) {
               var0.method2556();
            }
         }
      }

   }
}
