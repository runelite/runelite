import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class176 {
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] field2903;
   @ObfuscatedName("w")
   @Export("settings")
   public static int[] field2905;
   @ObfuscatedName("e")
   public static int[] field2907 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2907[var1] = var0 - 1;
         var0 += var0;
      }

      field2905 = new int[2000];
      field2903 = new int[2000];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIIB)V",
      garbageValue = "104"
   )
   static final void method3432(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field80[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2523();
            if(var7 == 0) {
               if(0 == var1) {
                  class5.field90[0][var2][var3] = -class114.method2463(var2 + 932731 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class5.field90[var1][var2][var3] = class5.field90[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(1 == var7) {
               int var8 = var0.method2523();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field90[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field90[var1][var2][var3] = class5.field90[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class124.field2024[var1][var2][var3] = var0.method2633();
               class107.field1856[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field82[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field80[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class84.field1431[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2523();
            if(var7 == 0) {
               break;
            }

            if(1 == var7) {
               var0.method2523();
               break;
            }

            if(var7 <= 49) {
               var0.method2523();
            }
         }
      }

   }
}
