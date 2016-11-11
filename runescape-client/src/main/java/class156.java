import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class156 {
   @ObfuscatedName("i")
   public static final class156 field2321 = new class156("LIVE", 0);
   @ObfuscatedName("h")
   public static final class156 field2322 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("e")
   public static final class156 field2323 = new class156("RC", 1);
   @ObfuscatedName("n")
   public final String field2325;
   @ObfuscatedName("g")
   public static final class156 field2326 = new class156("WIP", 2);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1300470905
   )
   public final int field2327;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1522298509
   )
   static int field2330;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2325 = var1;
      this.field2327 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-162755348"
   )
   static final void method3186(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2544();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class5.tileHeights[0][var2];
                  int var11 = var4 + 932731 + var2;
                  int var12 = 556238 + var3 + var5;
                  int var13 = XItemContainer.method183('넵' + var11, 91923 + var12, 4) - 128 + (XItemContainer.method183(10294 + var11, '鎽' + var12, 2) - 128 >> 1) + (XItemContainer.method183(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = 8 * -var13;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method2544();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = 8 * -var14;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 8 * var14;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field88[var1][var2][var3] = var0.method2545();
               class5.field89[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field90[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field102[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2544();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2544();
               break;
            }

            if(var7 <= 49) {
               var0.method2544();
            }
         }
      }

   }
}
